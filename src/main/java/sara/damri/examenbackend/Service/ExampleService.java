package sara.damri.examenbackend.Service;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sara.damri.examenbackend.DTOs.ExampleDTO;
import sara.damri.examenbackend.Entities.Client;
import sara.damri.examenbackend.Mappers.ExampleMapper;
import sara.damri.examenbackend.Repositories.ExampleRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ExampleService {
    private ExampleRepo exampleRepo;
    private ExampleMapper exampleMapper;

    public ExampleDTO saveCustomer(ExampleDTO  exampleDTO) {
        log.info("Saving new Customer");
        Client client =exampleMapper.fromExampleDTO(exampleDTO);
        Client saveClient =exampleRepo.save(client);
        return exampleMapper.fromExample(saveClient);
    }
    public List<ExampleDTO> listExample() {
        List<Client> customers = exampleRepo.findAll();
        List<ExampleDTO> customerDTOS = customers.stream()
                .map(customer -> exampleMapper.fromExample(customer))
                .collect(Collectors.toList());
        return customerDTOS;
    }


}
