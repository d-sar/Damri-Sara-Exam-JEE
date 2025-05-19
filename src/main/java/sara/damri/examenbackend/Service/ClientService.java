package sara.damri.examenbackend.Service;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sara.damri.examenbackend.DTOs.ClientDTO;
import sara.damri.examenbackend.DTOs.CreditDTO;
import sara.damri.examenbackend.Entities.Client;

import sara.damri.examenbackend.Entities.Credit;
import sara.damri.examenbackend.Exceptions.ClientNotFoundException;
import sara.damri.examenbackend.Mappers.CreditMapperImpl;
import sara.damri.examenbackend.Repositories.ClientRepository;
import sara.damri.examenbackend.Repositories.CreditRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ClientService  {

    private final ClientRepository clientRepository;
    private final CreditMapperImpl clientMapper;
    private final CreditRepository creditRepository;


    public ClientDTO createClient(ClientDTO clientDTO) {
        log.info("Création d'un nouveau client : {}", clientDTO.getNom());
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.fromClient(savedClient);
    }


    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé avec l'ID : " + id));
        return clientMapper.fromClient(client);
    }

    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::fromClient)
                .collect(Collectors.toList());
    }



    public void deleteClient(Long id) {
        log.info("Suppression du client ID : {}", id);
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException("Client non trouvé");
        }
        clientRepository.deleteById(id);
    }

}