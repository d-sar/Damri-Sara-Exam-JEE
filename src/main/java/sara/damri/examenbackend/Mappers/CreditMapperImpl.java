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
        CreditPrsoneelDTO creditPersonnelDTO=new CreditPrsoneelDTO();
        BeanUtils.copyProperties(creditPersonnel,creditPersonnelDTO);

        return creditPersonnelDTO;
    }

    public CreditPersonnel fromCreditPersonnnelDTO(CreditPrsoneelDTO creditPersonnelDTO){
        CreditPersonnel creditPersonnel=new CreditPersonnel();
        BeanUtils.copyProperties(creditPersonnelDTO,creditPersonnel);

        return creditPersonnel;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO creditImmobilierDTO){
        CreditImmobilier creditImmobilier=new CreditImmobilier();
        BeanUtils.copyProperties(creditImmobilierDTO,creditImmobilier);

        return creditImmobilier;
    }

    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier creditImmobilier){
        CreditImmobilierDTO creditImmobilierDTO=new CreditImmobilierDTO();
        BeanUtils.copyProperties(creditImmobilier,creditImmobilierDTO);

        return creditImmobilierDTO;
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
