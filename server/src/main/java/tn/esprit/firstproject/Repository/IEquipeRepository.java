package tn.esprit.firstproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.Equipe;

import java.util.List;

@Repository
public interface IEquipeRepository extends JpaRepository<Equipe,Integer> {
    List<Equipe> findEquipeByIdEquipe(Integer id);
    List<Equipe> findEquipeByNomEquipe(String nom);

    List<Equipe> findEquipeByNiveau(Equipe.Niveau niv);
}
