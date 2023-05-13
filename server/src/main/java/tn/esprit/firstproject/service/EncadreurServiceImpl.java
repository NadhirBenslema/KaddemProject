package tn.esprit.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.Repository.IEncadreurRepository;
import tn.esprit.firstproject.entity.Encadreur;

import java.util.List;

@Service
public class EncadreurServiceImpl implements EncadreurService{

    @Autowired
    IEncadreurRepository encadreurRepository;

    @Override
    public Encadreur saveEncadreur(Encadreur encadreur) {
        return encadreurRepository.save(encadreur);
    }

    @Override
    public List<Encadreur> retrieveAllEncadreurs() {
        return encadreurRepository.findAll();
    }

    @Override
    public List<Encadreur> findEncadreurById(Integer id) {
        return encadreurRepository.findEncadreurByIdEncadreur(id);
    }

    @Override
    public List<Encadreur> findEncadreurByNom(String nom) {
        return encadreurRepository.findEncadreurByNomEnc(nom);
    }

    @Override
    public List<Encadreur> findEncadreurByPrenom(String prenom) {
        return encadreurRepository.findEncadreurByPrenomEnc(prenom);
    }

    @Override
    public void deleteEncadreur(Integer id) {
        encadreurRepository.deleteById(id);

    }
}
