package sara.damri.examenbackend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("PERSONNEL")
public class CreditPersonnel extends Credit{

    private String motif;

    public CreditPersonnel(Object o, LocalDate localDate, StatutCredit statutCredit, LocalDate localDate1, double v, int i, double v1, Client client1, Object o1, String achatVoiture) {
    }
}
