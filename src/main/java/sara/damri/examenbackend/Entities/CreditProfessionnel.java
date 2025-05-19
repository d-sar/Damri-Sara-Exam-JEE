package sara.damri.examenbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("PROFESSIONNEL")
public class CreditProfessionnel extends Credit {

    private String motif;


    public void setMotif(String expansionEntreprise) {
    }


}