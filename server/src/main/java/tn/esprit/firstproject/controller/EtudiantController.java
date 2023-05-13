package tn.esprit.firstproject.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.entity.Etudiant;
import tn.esprit.firstproject.service.EtudiantService;

import java.util.List;


@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;


    @PostMapping("/add")
    public Etudiant saveEtudiantC(@RequestBody Etudiant etudiant){
        return etudiantService.saveEtudiant(etudiant);
    }

    @GetMapping("getAll")
    public List<Etudiant> getAllEtudiants(){
        return etudiantService.retrieveAllEtudiants();
    }


    @GetMapping("/getById/{id}")
    public List<Etudiant> findByIdC(@PathVariable("id") Integer id){
        return etudiantService.findEtudiantById(id);
    }

    @GetMapping("/getByNom/{nom}")
    public List<Etudiant> findByNomEC(@PathVariable("nom") String nom){
        return etudiantService.findEtudiantByNom(nom);
    }

    @GetMapping("/getByPrenom/{prenom}")
    public List<Etudiant> findBypreomEC(@PathVariable("prenom") String prenom){
        return etudiantService.findEtudiantByPrenom(prenom);
    }

   /* @GetMapping("/getByOption/{option}")
    public List<Etudiant> findByOptionC(@PathVariable("option") Option option){
        return etudiantService.findEtudiantByOption(option);
    }*/


    @DeleteMapping("/delete/{id}")
    public void DeleteE(@PathVariable Integer id){
        etudiantService.deleteEtudiant(id);
    }

    @PutMapping("/updated/{id}")
    public Etudiant updateDepartement(@PathVariable("id")Integer id, @RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(id,etudiant);
    }

    @PutMapping("/assignEtudiant/{idC}/{idE}")
    public Etudiant addAndAssignEtudiantToEquipeAndContractC(@RequestBody Etudiant e ,@PathVariable("idC")Integer idContrat,@PathVariable("idE") Integer idEquipe){
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
    
    @GetMapping("getByDep/{idDep}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDep")Integer idDep){
        return etudiantService.retrieveEtudiantsByDepartement(idDep);
    }

}
