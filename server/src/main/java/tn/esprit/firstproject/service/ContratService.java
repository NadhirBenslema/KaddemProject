package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entity.Contrat;
import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.entity.Equipe;

import java.util.Date;
import java.util.List;

public interface ContratService {
    Contrat saveContrat(Contrat contrat);

    List<Contrat> retrieveAllContrats();
    List<Contrat> findContartById(Integer id);
    List<Contrat> findContartBySpecialiteS(Contrat.Specialite specialite);

    List<Contrat> findContratByDateDebut(Date date);

    List<Contrat> findContratByDateFin(Date date);

    List<Contrat> findContratByArchive(Boolean archive);

    List<Contrat> findContratByMontant(Integer montant);

    void deleteContratById(Integer id);


    Contrat affectContratToEtudiant(Contrat ce ,String nomE,String prenomE);

    Contrat secondWayAffectation(Contrat ce , String nomE,String prenomE);


    String getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

   Integer nbContratsValides(Date startDate, Date endDate);

   void retrieveAndUpdateStatusContrat();

    Contrat updateContrat(Integer id, Contrat contrat);

    public List<Contrat> listAll() ;


}
