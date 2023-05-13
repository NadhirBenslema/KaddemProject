package tn.esprit.firstproject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.Repository.IContratRepository;
import tn.esprit.firstproject.Repository.IEtudiantRepository;
import tn.esprit.firstproject.entity.Contrat;
import tn.esprit.firstproject.entity.Etudiant;



import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ContratServiceImpl implements ContratService{
    @Autowired
    private IContratRepository contratRepository;
    @Autowired
    private IEtudiantRepository etudiantRepository;

    @Override
    public Contrat saveContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public List<Contrat> findContartById(Integer id) {
        return contratRepository.findContratByIdContrat(id);
    }

    @Override
    public List<Contrat> findContartBySpecialiteS(Contrat.Specialite specialite) {
        return contratRepository.findContratBySpecialite(specialite);
    }

    @Override
    public List<Contrat> findContratByDateDebut(Date date) {
        return contratRepository.findContratsByDateDebutContrat(date);
    }

    @Override
    public List<Contrat> findContratByDateFin(Date date) {
        return contratRepository.findContratsByDateFinContrat(date);
    }

    @Override
    public List<Contrat> findContratByArchive(Boolean archive) {
        if(archive){
            return contratRepository.findContratsByArchiveIsTrue();
        }
        else {
            return contratRepository.findContratsByArchiveIsFalse();
        }
    }

    @Override
    public List<Contrat> findContratByMontant(Integer montant) {
        return contratRepository.findContratsByMontantContrat(montant);
    }

    @Override
    public void deleteContratById(Integer id) {
        contratRepository.deleteById(id);

    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepository.findEtudiantByPrenomEAndAndNomE(prenomE,nomE);
        List<Contrat> contratList=contratRepository.findContratsByEtudiant(e);
        if (contratList.size()>=5){
            return null;

        }
        ce.setEtudiant(e);
        etudiantRepository.save(e);

        return contratRepository.save(ce);

    }

    @Override
    public Contrat secondWayAffectation(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepository.rechercheEtudiantParNomEtPrenom(nomE,prenomE);
        Integer nbrC=contratRepository.countByArchiveIsFalseAndEtudiant(e);
        if(nbrC < 5 ) {
            ce.setEtudiant(e);
            contratRepository.save(ce);
        }
        return ce;

    }


    @Override
    public String getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contratList=contratRepository.findContratsByArchiveIsFalseAndDateDebutContratBetween(startDate,endDate);
        float cl=0;
        float ia=0;
        float sec=0;
        float res=0;
        for(Contrat c : contratList ){
            if(c.getSpecialite().toString().equals("CLOUD")){
                cl+=c.getMontantContrat();
            }
            if(c.getSpecialite().toString().equals("IA")){
                ia+=c.getMontantContrat();
            }
            if(c.getSpecialite().toString().equals("SECURITE")){
                sec+=c.getMontantContrat();
            }
            if(c.getSpecialite().toString().equals("RESEAUX")){
                res+=c.getMontantContrat();
            }

        }
       /* System.out.println("cloud : "+cl);
        System.out.println("IA : "+ia);
        System.out.println("Securite : "+sec);
        System.out.println("reseaux : "+res); */
        return ("cloud : "+cl+"\n"+"IA :" +ia+"\n"+"Securite : "+sec+"\n"+"reseaux : "+res);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {

       return contratRepository.findContratsByArchiveIsFalseAndDateDebutContratBetween(startDate,endDate).size();
   }


    @Scheduled(cron = "0 0 22 * * *")
    @Override
    public void retrieveAndUpdateStatusContrat() {
        //SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String msg="";
        Date d1=new Date();
        long v=d1.getTime();
        //System.out.println("*********************** :"+v);
        List<Contrat> contratList=contratRepository.findAll();
        long val;
        for(Contrat c : contratList ){

            Date d=c.getDateFinContrat();
            long v2=d.getTime();
          //  System.out.println(d);

            long val1 =v2-v;
            //System.out.println("la diff :"+val1);

            long days=(val1/(1000*60*60*24));

            System.out.println("nbr de jours:"+days);

           /* if(days<0){
                msg+=("le contrat :"+c.getIdContrat()+ "a achevé" );
            }*/
            if((days>=0)&&(days<=15)) {
                //msg+=("le contrat de l'id :"+c.getIdContrat()+"est à :"+days+"de se désactiver \n");
                msg=c.toString();

            }
            if(days==0){
                c.setArchive(true);
            }
        }

        log.info("scheduled :" + msg);



    }

    @Override
    public Contrat updateContrat(Integer id, Contrat contrat) {
        contrat.setIdContrat(id);
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> listAll() {
        return contratRepository.findAll(Sort.by("IdContrat").ascending());


    }
}
