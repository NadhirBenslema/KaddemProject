package tn.esprit.firstproject.service;


import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.entity.Universite;

import java.util.List;

public interface UniversiteService {
    Universite addUniversite(Universite universite);

    List<Universite> retrieveAllUniversities();

    List<Universite> findUniversiteById(Integer id);

    List<Universite> findUniversiteByNom(String nom);

    void deleteUniversite(Integer id);

    Universite assignUniversiteToDepartement(Integer idUniversite , Integer idDep);

    Universite updateUniv(Integer id, Universite universite);

}
