package tn.esprit.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.Repository.IDepartementRepository;
import tn.esprit.firstproject.Repository.IUniversiteRepository;
import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.entity.Universite;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UniversiteServiceImpl implements UniversiteService {

    @Autowired
    IUniversiteRepository universiteRepository;

    @Autowired
    IDepartementRepository departementRepository;


    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public List<Universite> findUniversiteById(Integer id) {
        return universiteRepository.findUniversiteByIdUniv(id);
    }

    @Override
    public List<Universite> findUniversiteByNom(String nom) {
        return universiteRepository.findUniversiteByNomUniv(nom);
    }

    @Override
    public void deleteUniversite(Integer id) {
        universiteRepository.deleteById(id);

    }
/*
    @Override
    public Universite assignUniversiteToDepartement(Integer idUniversite, Integer idDep) {
        Departement departement=departementRepository.findById(idDep).orElse(null);
        Universite universite=universiteRepository.findById(idUniversite).orElse(null);
        universite.getDepartements().add(departement);
        departementRepository.save(departement);
        return universiteRepository.save(universite);
    }

 */
    @Override
    public Universite assignUniversiteToDepartement(Integer idUniversite, Integer idDep) {
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        Departement d = departementRepository.findById(idDep).orElse(null);
        if(u.getDepartements() == null){
            Set<Departement> departementSet = new HashSet<>();
            departementSet.add(d);
            u.setDepartements(departementSet);
            return universiteRepository.save(u);
        }
        u.getDepartements().add(d);
        return universiteRepository.save(u);


    }

    @Override
    public Universite updateUniv(Integer id, Universite universite) {
        universite.setIdUniv(id);
        return universiteRepository.save(universite);
    }
}
