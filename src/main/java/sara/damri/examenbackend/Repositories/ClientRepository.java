package sara.damri.examenbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sara.damri.examenbackend.Entities.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client>  findByNameContains(String Keyword);
}
