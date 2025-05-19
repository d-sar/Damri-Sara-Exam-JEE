package sara.damri.examenbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sara.damri.examenbackend.Entities.Credit;
import sara.damri.examenbackend.Entities.StatutCredit;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository <Credit,Long>{
    // Trouver tous les crédits d'un client
    List<Credit> findByClientId(Long clientId);
    // Trouver les crédits par statut
    List<Credit> findByStatut(StatutCredit statut);
}
