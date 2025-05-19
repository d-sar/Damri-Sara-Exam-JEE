package sara.damri.examenbackend.DTOs;

import java.time.LocalDate;

public class CreditDTO
{
    private Long id;
    private LocalDate dateDemande;
    private String statut;
    private LocalDate dateAcceptation;
    private Double montant;
    private Integer dureeMois;
    private Double tauxInteret;
    private Long clientId;
}
