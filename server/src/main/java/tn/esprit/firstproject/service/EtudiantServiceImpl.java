package tn.esprit.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.Repository.IContratRepository;

import tn.esprit.firstproject.Repository.IEquipeRepository;
import tn.esprit.firstproject.Repository.IEtudiantRepository;

import tn.esprit.firstproject.entity.Contrat;

import tn.esprit.firstproject.entity.Equipe;
import tn.esprit.firstproject.entity.Etudiant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class EtudiantServiceImpl implements EtudiantService{

    @Autowired
    private IEtudiantRepository etudiantRepository;

    @Autowired
    private IContratRepository contratRepository;

    @Autowired
    private IEquipeRepository equipeRepository;




    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant) ;
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> findEtudiantById(Integer id) {
        return etudiantRepository.findByIdEtudiant(id);
    }

    @Override
    public List<Etudiant> findEtudiantByNom(String nom) {
        return etudiantRepository.findByNomE(nom);
    }

    @Override
    public List<Etudiant> findEtudiantByPrenom(String prenom) {
        return etudiantRepository.findEtudiantByPrenomE(prenom);
    }

   /* @Override
    public List<Etudiant> findEtudiantByOption(Option option) {
        return etudiantRepository.findEtudiantByOption(option);
    }*/


    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);

    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {

        etudiantRepository.save(e);
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        //Affectation avec contrat
        contrat.setEtudiant(e);
        contratRepository.save(contrat);
        //Affectation avec equipe
        Set<Equipe> equipeSet=new HashSet<>();
        equipeSet.add(equipe);
        e.setEquipes(equipeSet);
        return e;
    }

    @Override
    public List<Etudiant> retrieveEtudiantsByDepartement(Integer idDep) {
        return etudiantRepository.findEtudiantsByDepartementIdDepart(idDep);
    }

    @Override
    public Etudiant updateEtudiant(Integer id, Etudiant etudiant) {
        etudiant.setIdEtudiant(id);
        return etudiantRepository.save(etudiant);
    }
}
