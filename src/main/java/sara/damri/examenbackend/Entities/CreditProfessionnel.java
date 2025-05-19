package sara.damri.examenbackend.Entities;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue("CPR")
public class CreditProfessionnel extends Credit{
    private String motif;

}