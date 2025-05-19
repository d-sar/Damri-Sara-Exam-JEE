package sara.damri.examenbackend.DTOs;

import lombok.Data;
import sara.damri.examenbackend.Secirity.SecurityConfig;

import java.sql.Date;

@Data
public class RemboursementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private SecurityConfig.TypeRemboursement type;
    private CreditDTO credit;
}
