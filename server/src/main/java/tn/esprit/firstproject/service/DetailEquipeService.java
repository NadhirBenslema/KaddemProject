package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entity.DetailEquipe;

import java.util.List;

public interface DetailEquipeService {
    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe);

    List<DetailEquipe> retrieveAllDetailEquipe();

    List<DetailEquipe> afficherDetailEquipeById(Integer id);

    List<DetailEquipe> afficherDetailEquipeBySalle(Integer num);

    List<DetailEquipe> afficherDetailEquipeByThematique(String thematique);

    void deleteDetailEquipe(Integer id);

}
