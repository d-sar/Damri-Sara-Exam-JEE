package sara.damri.examenbackend.Web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sara.damri.examenbackend.DTOs.*;
import sara.damri.examenbackend.Exceptions.ClientNotFoundException;
import sara.damri.examenbackend.Exceptions.CreditNotFoundException;
import sara.damri.examenbackend.Service.CreditServiceImpl;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/credits")
@CrossOrigin("*")
public class CreditController {
    private final CreditServiceImpl bankCreditService;

    public CreditController (CreditServiceImpl bankCreditService) {
        this.bankCreditService = bankCreditService;
    }

    @GetMapping("/{creditId}")
    public CreditDTO getCredit(@PathVariable Long creditId) throws CreditNotFoundException {
        return bankCreditService.getCredit(creditId);
    }

    @GetMapping
    public List<CreditDTO> listCredits() {
        return bankCreditService.listCredits();
    }

    @GetMapping("/client/{clientId}")
    public List<CreditDTO> getClientCredits(@PathVariable Long clientId) throws ClientNotFoundException {
        return bankCreditService.listCreditsByClient(clientId);
    }

    @GetMapping("/{creditId}/repayments")
    public List<RemboursementDTO> getCreditRepayments(@PathVariable Long creditId) throws CreditNotFoundException {
        return bankCreditService.getRemboursementsByCredit(creditId);
    }

    @PostMapping("/personal")
    public CreditPrsoneelDTO createPersonalCredit(@RequestBody CreditPrsoneelDTO creditDTO) throws ClientNotFoundException {
        return bankCreditService.saveCreditPersonnel(creditDTO);
    }

    @PostMapping("/mortgage")
    public CreditImmobilierDTO createMortgageCredit(@RequestBody CreditImmobilierDTO creditDTO) throws ClientNotFoundException {
        return bankCreditService.saveCreditImmobilier(creditDTO);
    }

    @PostMapping("/business")
    public CreditProfessionnelDTO createBusinessCredit(@RequestBody CreditProfessionnelDTO creditDTO) throws ClientNotFoundException {
        return bankCreditService.saveCreditProfessionel(creditDTO);
    }

    @PostMapping("/{creditId}/repayments")
    public RemboursementDTO addRepayment(@PathVariable Long creditId, @RequestBody RemboursementDTO repaymentDTO) throws CreditNotFoundException {
        return bankCreditService.addRemboursement(creditId, repaymentDTO);
    }

    @PutMapping("/{creditId}/status")
    public void updateStatus(@PathVariable Long creditId, @RequestParam String status) throws CreditNotFoundException {
        bankCreditService.updateCreditStatus(creditId, status);
    }

    @DeleteMapping("/{creditId}")
    public void deleteCredit(@PathVariable Long creditId) {
        bankCreditService.deleteCredit(creditId);
    }
}
