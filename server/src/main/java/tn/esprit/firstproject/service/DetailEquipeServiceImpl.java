package tn.esprit.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.Repository.IDetailEquipeRepository;
import tn.esprit.firstproject.entity.DetailEquipe;

import java.util.List;

@Service
public class DetailEquipeServiceImpl implements DetailEquipeService{

    @Autowired
    IDetailEquipeRepository detailEquipeRepository;


    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public List<DetailEquipe> retrieveAllDetailEquipe() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public List<DetailEquipe> afficherDetailEquipeById(Integer id) {
        return detailEquipeRepository.findDetailEquipeByIdDetailEquipe(id);
    }

    @Override
    public List<DetailEquipe> afficherDetailEquipeBySalle(Integer num) {
        return detailEquipeRepository.findDetailEquipeBySalle(num);
    }

    @Override
    public List<DetailEquipe> afficherDetailEquipeByThematique(String thematique) {
        return detailEquipeRepository.findDetailEquipeByThematique(thematique);
    }

    @Override
    public void deleteDetailEquipe(Integer id) {
        detailEquipeRepository.deleteDetailEquipeByIdDetailEquipe(id);

    }
}
