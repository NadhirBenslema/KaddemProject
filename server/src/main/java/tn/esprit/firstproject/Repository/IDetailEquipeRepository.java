package tn.esprit.firstproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entity.DetailEquipe;


import java.util.List;
@Repository
public interface IDetailEquipeRepository extends JpaRepository<DetailEquipe,Integer> {
    List<DetailEquipe> findDetailEquipeByIdDetailEquipe(Integer id);
    List<DetailEquipe> findDetailEquipeBySalle(Integer num);
    List<DetailEquipe> findDetailEquipeByThematique(String thematique);
    void deleteDetailEquipeByIdDetailEquipe(Integer id);

}
