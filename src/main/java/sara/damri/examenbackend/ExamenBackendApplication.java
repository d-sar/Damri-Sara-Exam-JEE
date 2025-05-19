package sara.damri.examenbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sara.damri.examenbackend.DTOs.ExampleDTO;
import sara.damri.examenbackend.Entities.Example;
import sara.damri.examenbackend.Repositories.ExampleRepo;
import sara.damri.examenbackend.Service.ExampleService;

@SpringBootApplication
public class ExamenBackendApplication  implements CommandLineRunner{
@Autowired
private ExampleRepo exampleRepo;
    public static void main(String[] args) {
        SpringApplication.run(ExamenBackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Example example = new Example();
        example.setName("Example");
        exampleRepo.save(example);

        System.out.println("-------------");
    }
}
