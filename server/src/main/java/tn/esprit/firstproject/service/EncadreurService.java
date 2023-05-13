package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entity.Encadreur;


import java.util.List;

public interface EncadreurService {
    Encadreur saveEncadreur(Encadreur encadreur);

    List<Encadreur> retrieveAllEncadreurs();

    List<Encadreur> findEncadreurById(Integer id);

    List<Encadreur> findEncadreurByNom(String nom );

    List<Encadreur> findEncadreurByPrenom(String prenom );

    void deleteEncadreur (Integer id);

}
