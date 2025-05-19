package sara.damri.examenbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
@DiscriminatorValue("PROFESSIONNEL")
public class CreditProfessionnel extends Credit {
    @Column(nullable = false)
    private String motif;

    @Column(name = "RAISON_SOCIALE", nullable = false)
    private String raisonSociale;


}