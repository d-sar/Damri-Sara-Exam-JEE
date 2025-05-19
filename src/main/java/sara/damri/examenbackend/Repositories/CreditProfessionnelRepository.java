package sara.damri.examenbackend.Repositories;

import jakarta.validation.constraints.DecimalMax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sara.damri.examenbackend.Entities.CreditProfessionnel;

import java.util.List;

@Repository
public interface CreditProfessionnelRepository extends JpaRepository <CreditProfessionnel,Long>{

}
