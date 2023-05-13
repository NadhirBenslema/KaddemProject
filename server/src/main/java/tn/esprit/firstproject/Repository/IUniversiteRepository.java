package tn.esprit.firstproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.entity.Universite;

import java.util.List;

@Repository

public interface IUniversiteRepository extends JpaRepository<Universite,Integer> {
    List<Universite> findUniversiteByIdUniv(Integer id);
    List<Universite> findUniversiteByNomUniv(String nom);





}
