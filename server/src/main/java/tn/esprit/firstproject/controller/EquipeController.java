package tn.esprit.firstproject.controller;


import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.PDF.EquipePDF;
import tn.esprit.firstproject.entity.Equipe;
import tn.esprit.firstproject.service.EquipeService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/equipe")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;

    @PostMapping("/add")
    public Equipe addEquipeC(@RequestBody Equipe equipe){
        return equipeService.addEquipe(equipe);
    }

    @GetMapping("/getAll")
    public List<Equipe> getAllEquipes(){
        return equipeService.retrieveAllEquipes();
    }

    @GetMapping("/getById/{id}")
    public List<Equipe> getEquipeByIdC(@PathVariable("id") Integer id){
        return equipeService.findEquipeById(id);
    }

    @GetMapping("/getByNom/{nom}")
    public List<Equipe> getEquipeByNomC(@PathVariable("nom") String nom){
        return equipeService.findEquipeByNom(nom);
    }

    @GetMapping("/getByNiv/{niv}")
    public List<Equipe> getEquipeByNivC(@PathVariable("niv") Equipe.Niveau niv){
        return equipeService.findEquipesByNiveau(niv);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEquipe(@PathVariable("id") Integer id){
        equipeService.deleteEquipe(id);
    }

    @PutMapping("/addAssign")
    public Equipe addAndAssign(@RequestBody Equipe equipe){
        return equipeService.addEquipeAndAssign(equipe);
    }

    @PutMapping("/updated/{id}")
    public Equipe updateEquipe(@PathVariable("id")Integer id, @RequestBody Equipe equipe){
        return equipeService.updateEquipe(id,equipe);
    }


    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Equipe> listEquipePDF = equipeService.listAll();

        EquipePDF exporter = new EquipePDF(listEquipePDF);
        exporter.export(response);

    }

}
