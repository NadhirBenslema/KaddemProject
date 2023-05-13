package tn.esprit.firstproject.service;


import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.entity.Etudiant;

import java.util.List;


public interface EtudiantService {


    Etudiant saveEtudiant(Etudiant etudiant);

    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> findEtudiantById(Integer id);

    List<Etudiant> findEtudiantByNom(String nom );

    List<Etudiant> findEtudiantByPrenom(String prenom );

    //List<Etudiant> findEtudiantByOption(Option option);

    void deleteEtudiant (Integer id);


    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e,Integer idContrat ,Integer idEquipe);

    List<Etudiant> retrieveEtudiantsByDepartement(Integer idDep);



    Etudiant updateEtudiant(Integer id, Etudiant etudiant);



}
