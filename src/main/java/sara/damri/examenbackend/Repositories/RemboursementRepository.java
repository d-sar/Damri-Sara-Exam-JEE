package sara.damri.examenbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import sara.damri.examenbackend.Entities.Remboursement;
import sara.damri.examenbackend.Secirity.SecurityConfig;

import java.util.List;

@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement,Long> {
    // Trouver tous les remboursements d'un crédit
    List<Remboursement> findByCreditId(Long creditId);

    // Trouver les remboursements par type
    List<Remboursement> findByType(SecurityConfig.TypeRemboursement type);
}
