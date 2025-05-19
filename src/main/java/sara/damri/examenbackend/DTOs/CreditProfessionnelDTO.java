package sara.damri.examenbackend.DTOs;

import jdk.jfr.DataAmount;
import lombok.Data;
import sara.damri.examenbackend.Entities.StatutCredit;

import java.sql.Date;
@Data
public class CreditProfessionnelDTO extends CreditDTO{
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private Date dateAcception;
    private Double montant;
    private int dureeRemboursement;
    private float tauxInteret;
    private String motif;
    private String raisonSociale;
    private ClientDTO client;

}
