package tn.esprit.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.Repository.IDetailEquipeRepository;
import tn.esprit.firstproject.Repository.IEquipeRepository;
import tn.esprit.firstproject.Repository.IEtudiantRepository;
import tn.esprit.firstproject.entity.DetailEquipe;
import tn.esprit.firstproject.entity.Equipe;
import tn.esprit.firstproject.entity.Etudiant;


import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class EquipeServiceImpl implements EquipeService {
    @Autowired
    private IEquipeRepository equipeRepository;

    @Autowired
    private IDetailEquipeRepository detailEquipeRepository;

    @Autowired
    private IEtudiantRepository etudiantRepository;



    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public List<Equipe> findEquipeById(Integer id) {
        return equipeRepository.findEquipeByIdEquipe(id);
    }

    @Override
    public List<Equipe> findEquipeByNom(String nom) {
        return equipeRepository.findEquipeByNomEquipe(nom);
    }

    @Override
    public List<Equipe> findEquipesByNiveau(Equipe.Niveau niv) {
        return equipeRepository.findEquipeByNiveau(niv);
    }

    @Override
    public void deleteEquipe(Integer id) {
        equipeRepository.deleteById(id);

    }

    @Override
    public Equipe addEquipeAndAssign(Equipe equipe) {
        DetailEquipe detailEquipe=equipe.getDetailEquipe();
        assert detailEquipe!=null;
        detailEquipe.setEquipes(equipe);
        detailEquipeRepository.save(detailEquipe);
        for(Etudiant etudiant:equipe.getEtudiants()){
            if(etudiant.getEquipes() ==null){
                Set<Equipe> equipes=new HashSet<>();
                equipes.add(equipe);
                etudiant.setEquipes(equipes);
            }
            else {
                etudiant.getEquipes().add(equipe);
            }
            etudiantRepository.save(etudiant);
        }
        return equipe;
    }

    @Override
    public Equipe updateEquipe(Integer id, Equipe equipe) {
        equipe.setIdEquipe(id);
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> listAll() {

            return equipeRepository.findAll(Sort.by("nomEquipe").ascending());

    }
}
