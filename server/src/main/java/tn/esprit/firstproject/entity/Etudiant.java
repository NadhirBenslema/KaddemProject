package tn.esprit.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L ;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idEtudiant;

    @Column(nullable = false)
    private String prenomE;

    @Column(nullable = false)
    private String nomE;

/*
    @Column(nullable = false , name ="option")
    @Enumerated(EnumType.STRING)
    private Option option;



    public enum Option {
        GAMIX,SIM,CLOUD,TWIN,SE
    } */


    @JsonIgnore
    @OneToMany(mappedBy ="etudiant",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Contrat> contrats;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    Departement departement;

    @JsonIgnore
    @ManyToMany //(cascade = CascadeType.ALL)
    private Set <Equipe> equipes;

}


