package ma.enset.customerservice.web.rest;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import ma.enset.customerservice.entity.Customer;
import ma.enset.customerservice.helper.CustomerHelper;
import ma.enset.customerservice.repository.CustomerRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Consumer;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerRestController {
    private CustomerRepository customerRepository;
    private CustomerHelper customerHelper; //should be a component

    @GetMapping("/customers/{id}")
    private Customer getCustomer(@PathVariable long id){
        return customerRepository.findById(id).get();

    }
    @GetMapping("/customers")
    private List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @PostMapping("/customers")
    private Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PutMapping("/customers/{id}")
    private Customer updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable long id) {
        System.out.println("llllllllllllllllllll");
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    // Check each field and update it only if it's not null in the request.
                    if (updatedCustomer.getName() != null) {
                        existingCustomer.setName(updatedCustomer.getName());
                    }
                    if (updatedCustomer.getEmail() != null) {
                        existingCustomer.setEmail(updatedCustomer.getEmail());
                    }
                    // Add more fields as needed.

                    return customerRepository.save(existingCustomer);
                }).orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
    }


}