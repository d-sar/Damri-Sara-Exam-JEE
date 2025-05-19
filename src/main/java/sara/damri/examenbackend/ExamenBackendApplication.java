package sara.damri.examenbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sara.damri.examenbackend.Entities.Client;
import sara.damri.examenbackend.Repositories.ExampleRepo;

@SpringBootApplication
public class ExamenBackendApplication  implements CommandLineRunner{
@Autowired
private ExampleRepo exampleRepo;
    public static void main(String[] args) {
        SpringApplication.run(ExamenBackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Client client = new Client();
        client.setName("Client");
        exampleRepo.save(client);

        System.out.println("-------------");
    }
}
