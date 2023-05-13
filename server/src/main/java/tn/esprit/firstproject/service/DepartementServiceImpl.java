package tn.esprit.firstproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.Repository.IDepartementRepository;
import tn.esprit.firstproject.Repository.IEtudiantRepository;
import tn.esprit.firstproject.entity.Departement;
import tn.esprit.firstproject.entity.Etudiant;

import java.util.List;
import java.util.Optional;


@Service
public class DepartementServiceImpl implements DepartementService{

    @Autowired
    IDepartementRepository departementRepository;
    @Autowired
    IEtudiantRepository etudiantRepository;

    @Override
    public Departement saveDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public List<Departement> findDepartementById(Integer id) {
        //List<Departement> departementList=departementRepository.findById(id);
        List<Departement> departementList=departementRepository.findDepartementsByIdDepart(id);

        return departementList;
    }

    @Override
    public List<Departement> findDepartementByNom(String nom) {
         List<Departement> departementList =departementRepository.findDepartementsByNomDepart(nom);
        return departementList;
    }

    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        return departementRepository.findDepartementsByIdUniv(idUniversite);
    }

    @Override
    public Departement updateDepart(Integer id, Departement departement) {
        departement.setIdDepart(id);
        return departementRepository.save(departement);
    }


    @Override
    public void deleteDepartement(Integer id) {
         departementRepository.deleteById(id);
    }

    @Override
    public Departement affecterEtudiant(Integer idDep,Integer idEtudiant) {

        Etudiant etudiant=etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement=departementRepository.findById(idDep).orElse(null);
        assert etudiant != null;
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
        return departementRepository.save(departement);
    }





}
