package tn.esprit.firstproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Contrat;
import tn.esprit.firstproject.entity.Etudiant;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Repository
public interface IContratRepository extends JpaRepository<Contrat,Integer>{
    List<Contrat> findContratByIdContrat(Integer id);
    List<Contrat> findContratBySpecialite(Contrat.Specialite specialite);

    List<Contrat> findContratsByDateDebutContrat(Date date);

    List<Contrat> findContratsByDateFinContrat(Date date);

    List<Contrat> findContratsByMontantContrat(Integer montant);

    List<Contrat> findContratsByArchiveIsFalse();

    List<Contrat> findContratsByArchiveIsTrue();


    List<Contrat> findContratsByEtudiant(Etudiant etudiant);


    Integer countByArchiveIsFalseAndEtudiant(Etudiant etudiant);





    List<Contrat> findContratsByDateDebutContratAndDateFinContratAndArchiveIsFalse(Date startDate ,Date endDate);

    List<Contrat> findContratsByArchiveIsFalseAndDateDebutContratBetween(Date startDate ,Date endDate);

   /* List<Contrat> findContratsByDateDebutContratBeforeAndDateFinContratAfter(Date startDate,Date endDate);*/
}
