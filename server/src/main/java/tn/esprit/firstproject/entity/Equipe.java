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
@ToString
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L ;
    @Id()
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idEquipe ;

    @Column(nullable = false)
    private String nomEquipe;

    @Enumerated(EnumType.STRING)
    private Niveau niveau ;




    public enum Niveau {
        JUNIOR, SENIOR ,EXPERT
    }

    @JsonIgnore
    @ManyToMany(mappedBy ="equipes",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<Etudiant> etudiants ;

    @JsonIgnore
    @OneToOne
    private DetailEquipe detailEquipe ;

    @JsonIgnore
    @ManyToOne
    private Encadreur encadreur;


}
