package sara.damri.examenbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sara.damri.examenbackend.Entities.CreditImmobilier;
import sara.damri.examenbackend.Entities.TypeBien;

import java.util.List;

@Repository
public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier,Long> {
    // Trouver les crédits immobiliers par type de bien
    List<CreditImmobilier> findByTypeBien(TypeBien typeBien);
}
