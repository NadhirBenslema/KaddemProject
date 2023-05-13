package tn.esprit.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date ;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L ;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idContrat ;

    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat ;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@Column(nullable = false)
    private Date dateFinContrat ;

    @Enumerated(EnumType.STRING)
    private Specialite specialite ;

    private Boolean archive ;

    private Integer montantContrat ;




    public enum Specialite {
        IA , RESEAUX ,CLOUD,SECURITE
    }

    @JsonIgnore
    @ManyToOne /*(cascade = CascadeType.REMOVE)*/
    Etudiant etudiant ;


}
