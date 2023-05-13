package tn.esprit.firstproject.service;



import tn.esprit.firstproject.entity.Departement;


import java.util.List;
import java.util.Optional;


public interface DepartementService {

    Departement saveDepartement(Departement departement);

    List<Departement> findDepartementById(Integer id);

    List<Departement> findDepartementByNom(String nom);

    List<Departement> retrieveAllDepartements();

    List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);

    Departement updateDepart(Integer id,Departement departement);

    void deleteDepartement(Integer id);

    Departement affecterEtudiant(Integer idDep,Integer idEtudiant);




}
