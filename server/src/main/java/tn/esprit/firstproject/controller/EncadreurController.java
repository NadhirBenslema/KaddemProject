package tn.esprit.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Encadreur;

import tn.esprit.firstproject.service.EncadreurService;


import java.util.List;

@RestController
@RequestMapping("/encadreur")
public class EncadreurController {
    @Autowired
    private EncadreurService encadreurService;


    @PostMapping("/add")
    public Encadreur saveEncadreurC(@RequestBody Encadreur encadreur){
        return encadreurService.saveEncadreur(encadreur);
    }

    @GetMapping("getAll")
    public List<Encadreur> getAllEtudiants(){
        return encadreurService.retrieveAllEncadreurs();
    }


    @GetMapping("/getById/{id}")
    public List<Encadreur> findByIdC(@PathVariable("id") Integer id){
        return encadreurService.findEncadreurById(id);
    }

    @GetMapping("/getByNom/{nom}")
    public List<Encadreur> findByNomEnC(@PathVariable("nom") String nom){
        return encadreurService.findEncadreurByNom(nom);
    }

    @GetMapping("/getByPrenom/{prenom}")
    public List<Encadreur> findBypreomEnC(@PathVariable("prenom") String prenom){
        return encadreurService.findEncadreurByPrenom(prenom);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteE(@PathVariable Integer id){
        encadreurService.deleteEncadreur(id);
    }

}
