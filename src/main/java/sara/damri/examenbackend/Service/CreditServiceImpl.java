package sara.damri.examenbackend.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sara.damri.examenbackend.DTOs.*;
import sara.damri.examenbackend.Entities.*;
import sara.damri.examenbackend.Exceptions.ClientNotFoundException;
import sara.damri.examenbackend.Exceptions.CreditNotFoundException;
import sara.damri.examenbackend.Mappers.CreditMapperImpl;
import sara.damri.examenbackend.Repositories.ClientRepository;
import sara.damri.examenbackend.Repositories.CreditRepository;
import sara.damri.examenbackend.Repositories.RemboursementRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CreditServiceImpl {

    private ClientRepository clientRepository;
    private CreditRepository creditRepository;
    private RemboursementRepository remboursementRepository;
    private CreditMapperImpl dtoMapper;

    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }


    public ClientDTO getClient(Long clientId) throws ClientNotFoundException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
        return dtoMapper.fromClient(client);
    }


    public List<ClientDTO> listClients() {
        return clientRepository.findAll()
                .stream()
                .map(dtoMapper::fromClient)
                .collect(Collectors.toList());
    }

    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = dtoMapper.fromClientDTO(clientDTO);
        Client saved = clientRepository.save(client);
        return dtoMapper.fromClient(saved);
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public CreditPrsoneelDTO saveCreditPersonnel( CreditPrsoneelDTO dto) throws ClientNotFoundException {
        Client client = clientRepository.findById(dto.getClient().getId())
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
        CreditPersonnel credit = dtoMapper.fromCreditPersonnnelDTO(dto);
        credit.setClient(client);
        credit.setDateDemande(Date.valueOf(LocalDate.now()).toLocalDate());

        CreditPersonnel saved = creditRepository.save(credit);
        return dtoMapper.fromCreditPersonnel(saved);
    }


    public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO dto) throws ClientNotFoundException {
        Client client = clientRepository.findById(dto.getClient().getId())
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
        CreditImmobilier credit = dtoMapper.fromCreditImmobilierDTO(dto);
        credit.setClient(client);
        credit.setDateDemande(Date.valueOf(LocalDate.now()).toLocalDate());

        CreditImmobilier saved = creditRepository.save(credit);
        return dtoMapper.fromCreditImmobilier(saved);
    }

    public CreditProfessionnelDTO saveCreditProfessionel(CreditProfessionnelDTO  dto) throws ClientNotFoundException {
        Client client = clientRepository.findById(dto.getClient().getId())
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
        CreditProfessionnel credit = dtoMapper.fromCreditProfessionnelDTO(dto);
        credit.setClient(client);
        credit.setDateDemande(Date.valueOf(LocalDate.now()).toLocalDate());

        CreditProfessionnel saved = creditRepository.save(credit);
        return dtoMapper.fromCreditProfessionel(saved);
    }


    public CreditDTO getCredit(Long creditId) throws ClientNotFoundException {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new CreditNotFoundException("Credit not found"));
        if (credit instanceof CreditPersonnel) {
            return dtoMapper.fromCreditPersonnel((CreditPersonnel) credit);
        } else if (credit instanceof CreditImmobilier) {
            return dtoMapper.fromCreditImmobilier((CreditImmobilier) credit);
        } else {
            return dtoMapper.fromCreditProfessionel((CreditProfessionnel) credit);
        }
    }

    public List<CreditDTO> listCreditsByClient(Long clientId) throws ClientNotFoundException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
        List<Credit> credits = creditRepository.findByClientId(clientId);
        return credits.stream().map(credit -> {
            if (credit instanceof CreditPersonnel) {
                return dtoMapper.fromCreditPersonnel((CreditPersonnel) credit);
            } else if (credit instanceof CreditImmobilier) {
                return dtoMapper.fromCreditImmobilier((CreditImmobilier) credit);
            } else {
                return dtoMapper.fromCreditProfessionel((CreditProfessionnel) credit);
            }
        }).collect(Collectors.toList());
    }


    public void updateCreditStatus(Long creditId, String status) throws CreditNotFoundException {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new CreditNotFoundException("Credit not found"));
        credit.setStatut(StatutCredit.valueOf(status));
        if ("Accepté".equalsIgnoreCase(status)) {
            credit.setDateDemande(Date.valueOf(LocalDate.now()).toLocalDate());

        }
        creditRepository.save(credit);
    }

    public void deleteCredit(Long creditId) {
        creditRepository.deleteById(creditId);
    }

    public RemboursementDTO addRemboursement(Long creditId, RemboursementDTO remboursementDTO) throws CreditNotFoundException {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new CreditNotFoundException("Credit not found"));
        Remboursement remboursement = new Remboursement();
        remboursement.setCredit(credit);
        credit.setDateDemande(Date.valueOf(LocalDate.now()).toLocalDate());

        remboursement.setMontant(remboursementDTO.getMontant());
        remboursement.setType(remboursementDTO.getType());
        Remboursement saved = remboursementRepository.save(remboursement);
        return dtoMapper.fromRemboursement(saved);
    }

    public List<RemboursementDTO> getRemboursementsByCredit(Long creditId) throws CreditNotFoundException {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new CreditNotFoundException("Credit not found"));
        return remboursementRepository.findById(creditId)
                .stream()
                .map(dtoMapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    public List<ClientDTO> searchClients(String keyword) {
        return clientRepository.findByNameContains(keyword)
                .stream()
                .map(dtoMapper::fromClient)
                .collect(Collectors.toList());
    }


    public List<CreditDTO> listCredits() {
        List<Credit> credits = creditRepository.findAll();
        List<CreditDTO> creditDTOS = credits.stream().map(credit -> {
            if (credit instanceof CreditPersonnel) {
                CreditPersonnel creditPersonnel = (CreditPersonnel) credit;
                return dtoMapper.fromCreditPersonnel(creditPersonnel);
            }else if (credit instanceof CreditImmobilier) {
                CreditImmobilier creditImmobilier = (CreditImmobilier) credit;
                return dtoMapper.fromCreditImmobilier(creditImmobilier);
            } else if (credit instanceof CreditProfessionnel) {
                CreditProfessionnel creditProfessionel = (CreditProfessionnel) credit;
                return dtoMapper.fromCreditProfessionel(creditProfessionel);
            }
            return null;
        }).collect(Collectors.toList());
        return creditDTOS;
    }
}


