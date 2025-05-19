package sara.damri.examenbackend.Entities;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "REMBOURSEMENTS")
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double montant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeRemboursement type;

    @ManyToOne
    @JoinColumn(name = "CREDIT_ID", nullable = false)
    private Credit credit;

    // Constructeurs, getters et setters
}

