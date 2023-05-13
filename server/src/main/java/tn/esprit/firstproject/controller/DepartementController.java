package tn.esprit.firstproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.service.DepartementService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/departement")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @PostMapping("/add")
    public Departement saveDepartementC(@RequestBody  Departement departement){
        return departementService.saveDepartement(departement);
    }

    @GetMapping("/getAll")
    public List<Departement> getAllDepartements(){
        return departementService.retrieveAllDepartements();
    }


    @GetMapping("/getById/{id}")
    public List<Departement> findDepartementByIdC(@PathVariable("id") Integer id){
        List<Departement> departementList =  departementService.findDepartementById(id);
        return departementList;
    }

    @GetMapping("/getByNom/{nom}")
    public List<Departement> findDepartementsByNomC(@PathVariable("nom") String nom){
         List<Departement> departementList=departementService.findDepartementByNom(nom);
        return departementList;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteDepartementC(@PathVariable("id") Integer id){
        departementService.deleteDepartement(id);
    }


    @PutMapping("/updated/{id}")
    public Departement updateDepartement(@PathVariable("id")Integer id,@RequestBody Departement departement){
        return departementService.updateDepart(id,departement);
    }



    @GetMapping("/getByUniv/{idUniversite}")
    public List<Departement> retrieveDepartementByIdUniversiteC(@PathVariable("idUniversite") Integer idUniversite){
        List<Departement> departementList=departementService.retrieveDepartementsByUniversite(idUniversite);
        return departementList;
    }


    @PutMapping("/update/{idDep}/{idEtudiant}")
    public Departement updateDep(@PathVariable("idDep")Integer idDep,@PathVariable("idEtudiant")Integer idEtudiant){
        return departementService.affecterEtudiant(idDep,idEtudiant);
    }

}
