package sara.damri.examenbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sara.damri.examenbackend.Entities.Example;

import java.util.List;

public interface ExampleRepo extends JpaRepository<Example,Long> {
    List<Example>  findByNameContains(String Keyword);
}
