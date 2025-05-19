package sara.damri.examenbackend.DTOs;

import java.time.LocalDate;

public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private Double montant;
    private String type; //
    private Long creditId;
}
