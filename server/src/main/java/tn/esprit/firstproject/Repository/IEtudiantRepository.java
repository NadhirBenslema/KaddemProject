package tn.esprit.firstproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Etudiant;

import java.util.List;

@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant,Integer> {

    List<Etudiant> findByNomE(String nom );
    List<Etudiant> findByIdEtudiant(Integer id );

    List<Etudiant> findEtudiantByPrenomE(String prenom);

    //List<Etudiant> findEtudiantByOption(Option option);

    Etudiant findEtudiantByPrenomEAndAndNomE(String nomE,String prenomE);


    @Query("select e from Etudiant e where e.nomE= :nom and e.prenomE= :prenom ")
    Etudiant rechercheEtudiantParNomEtPrenom(@Param("nom") String nom ,@Param("prenom") String prenom);





    List<Etudiant> findEtudiantsByDepartementIdDepart(Integer idDep);



}
