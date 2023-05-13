package tn.esprit.firstproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entity.DetailEquipe;
import tn.esprit.firstproject.service.DetailEquipeService;

import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/detailEquipe")
public class DetailEquipeController {
    @Autowired
    DetailEquipeService detailEquipeService;

    @PostMapping("/add")
    public DetailEquipe addDetailEquipeC(@RequestBody DetailEquipe detailEquipe){
        return detailEquipeService.addDetailEquipe(detailEquipe);
    }

    @GetMapping("/getAll")
    public List<DetailEquipe> getAllDetailEquipe(){
        List<DetailEquipe> detailEquipeList = detailEquipeService.retrieveAllDetailEquipe();
        return detailEquipeList;
    }

    @GetMapping("/getById/{id}")
    public List<DetailEquipe> getDetailEquipeByIdC(@PathVariable("id") Integer id){
        List<DetailEquipe> detailEquipeList = detailEquipeService.afficherDetailEquipeById(id);
        return detailEquipeList;
    }

    @GetMapping("/getBySalle/{num}")
    public List<DetailEquipe> getDetailEquipeBySalleC(@PathVariable("num") Integer num){
        List<DetailEquipe> detailEquipeList = detailEquipeService.afficherDetailEquipeBySalle(num);
        return detailEquipeList;
    }

    @GetMapping("/getByThematique/{thematique}")
    public List<DetailEquipe> getDetailEquipeByThematiqueC(@PathVariable("thematique") String thematique){
        List<DetailEquipe> detailEquipeList = detailEquipeService.afficherDetailEquipeByThematique(thematique);
        return detailEquipeList;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDetailEquipeC(@PathVariable("id") Integer id){
        detailEquipeService.deleteDetailEquipe(id);
    }

}
