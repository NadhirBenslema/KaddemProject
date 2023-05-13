package tn.esprit.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Encadreur implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idEncadreur;

   // @Column(nullable = false)
    private String prenomEnc;

  //  @Column(nullable = false)
    private String nomEnc;

    @Enumerated(EnumType.STRING)
    private Encadreur.Specialite specialite ;

    public enum Specialite {
        IA , RESEAUX ,CLOUD,SECURITE
    }

    @JsonIgnore
    @OneToMany
    private Set<Equipe> equipes;

    @JsonIgnore
    @ManyToOne
    private Departement departement;




}
