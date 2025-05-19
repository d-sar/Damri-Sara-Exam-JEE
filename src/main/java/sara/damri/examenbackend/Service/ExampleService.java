package sara.damri.examenbackend.Service;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sara.damri.examenbackend.DTOs.ExampleDTO;
import sara.damri.examenbackend.Entities.Example;
import sara.damri.examenbackend.Mappers.ExampleMapper;
import sara.damri.examenbackend.Repositories.ExampleRepo;

import java.util.Date;
import java.util.List;
import java.util.UUID;
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
        Example example=exampleMapper.fromExampleDTO(exampleDTO);
        Example saveExample =exampleRepo.save(example);
        return exampleMapper.fromExample(saveExample);
    }
    public List<ExampleDTO> listExample() {
        List<Example> customers = exampleRepo.findAll();
        List<ExampleDTO> customerDTOS = customers.stream()
                .map(customer -> exampleMapper.fromExample(customer))
                .collect(Collectors.toList());
        return customerDTOS;
    }


}
