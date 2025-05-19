package sara.damri.examenbackend.Web;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import sara.damri.examenbackend.DTOs.ExampleDTO;
import sara.damri.examenbackend.Service.ExampleService;

import java.util.List;
import java.util.concurrent.ExecutorService;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/example")
public class EmployeeController {
    private ExampleService exampleService;

    @GetMapping
    public List<ExampleDTO> getAllEmployees() {
        return exampleService.listExample();
    }


    @PostMapping
    public ExampleDTO saveEmployee(@RequestBody ExampleDTO employeeDTO) {
        return exampleService.saveCustomer(employeeDTO);
    }




// les rpo
    //private  EmployeeRepository employeeRepository;
//    @GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        List<Employee> employees = executorService.findAll();
//        return ResponseEntity.ok(employees);
//    }




}