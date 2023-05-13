package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.entity.Equipe;


import java.util.List;

public interface EquipeService {
    Equipe addEquipe(Equipe equipe);

    List<Equipe> retrieveAllEquipes();

    List<Equipe> findEquipeById(Integer id);

    List<Equipe> findEquipeByNom(String nom);

    List<Equipe> findEquipesByNiveau(Equipe.Niveau niv);

    void deleteEquipe(Integer id);

    Equipe addEquipeAndAssign(Equipe equipe);

    Equipe updateEquipe(Integer id, Equipe equipe);

    public List<Equipe> listAll() ;
}
