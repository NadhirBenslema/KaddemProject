package tn.esprit.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailEquipe implements Serializable {
    private static final long serialVersionUID = 1L ;

    @Id()
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idDetailEquipe;


    private Integer salle ;

    @Column(nullable = false)
    private String thematique ;


    @JsonIgnore
    @OneToOne(mappedBy = "detailEquipe" , cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Equipe equipes ;


}
