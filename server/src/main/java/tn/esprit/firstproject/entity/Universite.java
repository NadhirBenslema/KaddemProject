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
public class Universite implements Serializable {
    private static final long serialVersionUID = 1L ;

    @Id()
    @GeneratedValue
    private Integer idUniv;

    @Column(nullable = false)
    private String nomUniv;


    @JsonIgnore
    @OneToMany(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name="idUniversite")
    private Set<Departement> departements ;


}
