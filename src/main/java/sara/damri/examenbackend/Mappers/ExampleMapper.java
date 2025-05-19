package sara.damri.examenbackend.Mappers;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sara.damri.examenbackend.DTOs.ExampleDTO;
import sara.damri.examenbackend.Entities.Client;

@Service
public class ExampleMapper {
    public ExampleDTO fromExample(Client client) {
        ExampleDTO example1 = new ExampleDTO();
        BeanUtils.copyProperties(client, example1);
        return example1;
    }
    public Client fromExampleDTO(ExampleDTO exampleDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(client, client);
        return client;
    }
}
