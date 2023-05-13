package tn.esprit.firstproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.entity.Universite;
import tn.esprit.firstproject.service.UniversiteService;

import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    private UniversiteService universiteService;

    @PostMapping("/add")
    public Universite saveUniversiteC(@RequestBody Universite universite){
        return universiteService.addUniversite(universite);
    }

    @GetMapping("/getAll")
    public List<Universite> getAllUniversities(){
        return universiteService.retrieveAllUniversities();
    }


    @GetMapping("/getById/{id}")
    public List<Universite> findUniversiteByIdC(@PathVariable("id") Integer id){
        List<Universite> universiteList = universiteService.findUniversiteById(id);
        return universiteList;
    }

    @GetMapping("/getByNom/{nom}")
    public List<Universite> findUniversitiesByNomC(@PathVariable("nom") String nom){
        List<Universite> universiteList=universiteService.findUniversiteByNom(nom);
        return universiteList;
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable("id") Integer id){
        universiteService.deleteUniversite(id);
    }

    @PutMapping("/update/{idUniversite}/{idDep}")
    public Universite updateUniv(@PathVariable("idUniversite")Integer idUniversite, @PathVariable("idDep")Integer idDep){
        return universiteService.assignUniversiteToDepartement(idUniversite,idDep);
    }

    @PutMapping("/updated/{id}")
    public Universite updateUniversite(@PathVariable("id")Integer id, @RequestBody Universite universite){
        return universiteService.updateUniv(id,universite);
    }
}
