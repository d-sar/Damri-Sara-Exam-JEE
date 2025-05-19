package sara.damri.examenbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Table(name = "CREDITS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CREDIT", discriminatorType = DiscriminatorType.STRING)
public class Credit {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "DATE_DEMANDE")
        private LocalDate dateDemande;

        @Enumerated(EnumType.STRING)

        private StatutCredit statut;

        @Column(name = "DATE_ACCEPTATION")
        private LocalDate dateAcceptation;


        private Double montant;

        @Column(name = "DUREE_MOIS")
        private Integer dureeMois;

        @Column(name = "TAUX_INTERET")
        private Double tauxInteret;

        @ManyToOne
        @JoinColumn(name = "CLIENT_ID")
        private Client client;

        @OneToMany(mappedBy = "credit", fetch=FetchType.EAGER, orphanRemoval = true)
        private List<Remboursement> remboursements = new ArrayList<>();


    }

