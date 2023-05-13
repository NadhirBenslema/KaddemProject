package tn.esprit.firstproject.controller;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.PDF.ContratPDF;
import tn.esprit.firstproject.entity.Contrat;

import tn.esprit.firstproject.service.ContratService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    private ContratService contratService;

    @PostMapping("/add")
    public Contrat saveContartC(@RequestBody Contrat contrat){
        return contratService.saveContrat(contrat);
    }

    @GetMapping("/getAll")
    public List<Contrat> findAllContrats(){
        return contratService.retrieveAllContrats();
    }

    @GetMapping("/getById/{id}")
    public List<Contrat> findContratByIdC(@PathVariable("id") Integer id ){
        return contratService.findContartById(id);
    }

    @GetMapping("/getBySpecialite/{specialite}")
    public List<Contrat> getContratBySpecialiteC(@PathVariable("specialite")Contrat.Specialite specialite){
        return contratService.findContartBySpecialiteS(specialite);
    }

    @GetMapping("/getByDateDebut/{date}")
    public List<Contrat> getContratByDateDebutC(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return contratService.findContratByDateDebut(date);
    }

    @GetMapping("/getByDateFin/{date}")
    public List<Contrat> getContratsByDateFinC(@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return contratService.findContratByDateFin(date);
    }

    @GetMapping("/getByMontant/{montant}")
    public List<Contrat> getContratsByMontantC(@PathVariable("montant") Integer montant){
        return contratService.findContratByMontant(montant);
    }

    @GetMapping("/getByArchive/{archive}")
    public List<Contrat> getContratsByArchiveC(@PathVariable("archive") Boolean archive){
        return contratService.findContratByArchive(archive);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteC(@PathVariable("id")Integer id){
        contratService.deleteContratById(id);
    }


    @PutMapping("/updated/{id}")
    public Contrat updateContrat(@PathVariable("id")Integer id, @RequestBody Contrat contrat){
        return contratService.updateContrat(id,contrat);
    }



    @PutMapping("/affecterContratEtudiant/{nomE}/{prenomE}")
    public Contrat affecterContratToEtudiantC(@RequestBody Contrat ce , @PathVariable("nomE")String nomE,@PathVariable("prenomE")String prenomE){
        return contratService.affectContratToEtudiant(ce,nomE,prenomE);
    }
    @PutMapping("/affecterCE/{nomE}/{prenomE}")
    public Contrat secondWayAffC(@RequestBody Contrat ce, @PathVariable("nomE")String nomE,@PathVariable("prenomE") String prenomE){
        return contratService.secondWayAffectation(ce,nomE,prenomE);
    }
    
    
    

    @GetMapping("/contratValide/{startDate}/{endDate}")

    public Integer getNombreContratValides(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate ,@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return contratService.nbContratsValides(startDate,endDate);
    }

    @GetMapping("/affaire/{startDate}/{endDate}")
    public  String calculChiffreAffaire(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return contratService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }



    @GetMapping("/statusContrat")
    public void retrieveAndUpdateStatusContratC(){
          contratService.retrieveAndUpdateStatusContrat();
    }






    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Contrat> listContratPDF = contratService.listAll();

        ContratPDF exporter = new ContratPDF(listContratPDF);
        exporter.export(response);

    }




}
