package tn.esprit.firstproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Departement;

import java.util.List;

@Repository
public interface IDepartementRepository extends JpaRepository<Departement,Integer> {


    Departement findDepartementByIdDepart(Integer id);
    List<Departement> findDepartementsByNomDepart(String nom);

    List<Departement> findDepartementsByIdDepart(Integer id);

    // @Query("select d from Departement d join Universite u where u.idUniv=:idUniversite")
    @Query("select d from Universite u join u.departements d where u.idUniv=:idUniversite ")
    List<Departement> findDepartementsByIdUniv(@Param("idUniversite")Integer idUniversite);




}
