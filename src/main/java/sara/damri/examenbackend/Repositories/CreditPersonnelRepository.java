package sara.damri.examenbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sara.damri.examenbackend.Entities.CreditPersonnel;

import java.util.List;

@Repository
public interface CreditPersonnelRepository extends JpaRepository <CreditPersonnel,Long>{
    // Trouver les crédits personnels par motif
    List<CreditPersonnel> findByMotifContainingIgnoreCase(String motif);
}
