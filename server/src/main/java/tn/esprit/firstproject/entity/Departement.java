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

public class Departement implements Serializable {
    private static final long serialVersionUID = 1L ;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepart ;

    //@Column(nullable = false)
    private String nomDepart ;

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private Set<Etudiant> etudiant ;

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private Set<Encadreur> encadreur;





}
