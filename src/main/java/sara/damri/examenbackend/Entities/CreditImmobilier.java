package sara.damri.examenbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("IMMOBILIER")
public class CreditImmobilier extends Credit {
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_BIEN")
    private TypeBien typeBien;

    public void setTypeBien(TypeBien typeBien) {
    }

    public String getTypeBien() {
        return null;
    }
}
