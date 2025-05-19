package sara.damri.examenbackend.Web;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import sara.damri.examenbackend.DTOs.ClientDTO;
import sara.damri.examenbackend.Service.ClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/client")
public class EmployeeController {
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClient() {
        return clientService.getAllClients();
    }


    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO employeeDTO) {
        return clientService.createClient(employeeDTO);
    }







}