package sara.damri.examenbackend.Mappers;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sara.damri.examenbackend.DTOs.ClientDTO;
import sara.damri.examenbackend.Entities.Client;

@Service
public class ExampleMapper {
    public ClientDTO fromExample(Client client) {
        ClientDTO example1 = new ClientDTO();
        BeanUtils.copyProperties(client, example1);
        return example1;
    }
    public Client fromExampleDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(client, client);
        return client;
    }
}
