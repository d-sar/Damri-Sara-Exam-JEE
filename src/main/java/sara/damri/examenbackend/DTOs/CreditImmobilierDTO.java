package sara.damri.examenbackend.DTOs;

import lombok.Data;
import sara.damri.examenbackend.Entities.StatutCredit;
import sara.damri.examenbackend.Entities.TypeBien;

import java.sql.Date;

@Data
public class CreditImmobilierDTO extends CreditDTO {
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private Date dateAcception;
    private Double montant;
    private int dureeRemboursement;
    private float tauxInteret;
    private TypeBien bienType;
    private ClientDTO client;
}
