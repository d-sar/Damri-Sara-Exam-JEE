package sara.damri.examenbackend.Entities;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REMBOURSEMENTS")
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Double montant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeRemboursement type;

    @ManyToOne
    @JoinColumn(name = "CREDIT_ID", nullable = false)
    private Credit credit;

}

