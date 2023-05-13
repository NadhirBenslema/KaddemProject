package tn.esprit.firstproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Encadreur;

import java.util.List;

@Repository
public interface IEncadreurRepository extends JpaRepository<Encadreur,Integer> {
    List<Encadreur> findEncadreurByIdEncadreur(Integer id);
    List<Encadreur> findEncadreurByNomEnc(String nom);
    List<Encadreur> findEncadreurByPrenomEnc(String prenom);

}
