package sara.damri.examenbackend.Service;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sara.damri.examenbackend.DTOs.ClientDTO;
import sara.damri.examenbackend.Entities.Client;
import sara.damri.examenbackend.Mappers.ExampleMapper;
import sara.damri.examenbackend.Repositories.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ExampleService {
    private ClientRepository exampleRepo;
    private ExampleMapper exampleMapper;

    public ClientDTO saveCustomer(ClientDTO clientDTO) {
        log.info("Saving new Customer");
        Client client =exampleMapper.fromExampleDTO(clientDTO);
        Client saveClient =exampleRepo.save(client);
        return exampleMapper.fromExample(saveClient);
    }
    public List<ClientDTO> listExample() {
        List<Client> customers = exampleRepo.findAll();
        List<ClientDTO> customerDTOS = customers.stream()
                .map(customer -> exampleMapper.fromExample(customer))
                .collect(Collectors.toList());
        return customerDTOS;
    }


}
