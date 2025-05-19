package sara.damri.examenbackend.Mappers;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sara.damri.examenbackend.DTOs.*;
;
import sara.damri.examenbackend.Entities.*;
import sara.damri.examenbackend.Entities.CreditPersonnel;


@Service
public class CreditMapperImpl {
    public ClientDTO fromClient(Client client){
        ClientDTO clientDTO=new ClientDTO();
        BeanUtils.copyProperties(client,clientDTO);
        return  clientDTO;
    }
    public Client fromClientDTO(ClientDTO clientDTO){
        Client client=new Client();
        BeanUtils.copyProperties(clientDTO,client);
        return  client;
    }

    public CreditPrsoneelDTO fromCreditPersonnel(CreditPersonnel creditPersonnel){
        CreditPrsoneelDTO  creditPersonnelDTO=new CreditPrsoneelDTO ();
        BeanUtils.copyProperties(creditPersonnel,creditPersonnelDTO);
        creditPersonnelDTO.setClient(fromClient(creditPersonnel.getClient()));
        creditPersonnelDTO.setType(creditPersonnel.getClass().getSimpleName());
        return creditPersonnelDTO;
    }

    public CreditPersonnel fromCreditPersonnnelDTO(CreditPrsoneelDTO creditPersonnelDTO){
        CreditPersonnel creditPersonnel=new CreditPersonnel();
        BeanUtils.copyProperties(creditPersonnelDTO,creditPersonnel);
        creditPersonnel.setClient(fromClientDTO(creditPersonnelDTO.getClient()));
        return creditPersonnel;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO creditImmobilierDTO){
        CreditImmobilier creditImmobilier=new CreditImmobilier();
        BeanUtils.copyProperties(creditImmobilierDTO,creditImmobilier);
        creditImmobilier.setClient(fromClientDTO(creditImmobilierDTO.getClient()));
        return creditImmobilier;
    }

    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier creditImmobilier){
        CreditImmobilierDTO creditImmobilierDTO=new CreditImmobilierDTO();
        BeanUtils.copyProperties(creditImmobilier,creditImmobilierDTO);
        creditImmobilierDTO.setClient(fromClient(creditImmobilier.getClient()));
        creditImmobilierDTO.setType(creditImmobilier.getClass().getSimpleName());
        return creditImmobilierDTO;
    }

    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO creditProfessionelDTO){
        CreditProfessionnel creditProfessionel=new CreditProfessionnel();
        BeanUtils.copyProperties(creditProfessionelDTO,creditProfessionel);
        creditProfessionel.setClient(fromClientDTO(creditProfessionelDTO.getClient()));
        return creditProfessionel;
    }

    public CreditProfessionnelDTO fromCreditProfessionel(CreditProfessionnel creditProfessionel){
        CreditProfessionnelDTO creditProfessionelDTO=new CreditProfessionnelDTO();
        BeanUtils.copyProperties(creditProfessionel,creditProfessionelDTO);
        creditProfessionelDTO.setClient(fromClient(creditProfessionel.getClient()));
        creditProfessionelDTO.setType(creditProfessionel.getClass().getSimpleName());
        return creditProfessionelDTO;
    }



    public RemboursementDTO fromRemboursement(Remboursement remboursement){
        RemboursementDTO remboursementDTO=new RemboursementDTO();
        BeanUtils.copyProperties(remboursement,remboursementDTO);
        return remboursementDTO;
    }
    public Remboursement fromRemboursementDTO(RemboursementDTO remboursementDTO){
        Remboursement remboursement = new Remboursement();
        BeanUtils.copyProperties(remboursementDTO, remboursement);
        return remboursement;
    }
}
