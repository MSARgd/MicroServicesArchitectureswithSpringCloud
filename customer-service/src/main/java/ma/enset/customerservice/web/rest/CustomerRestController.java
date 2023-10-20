package ma.enset.customerservice.web.rest;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import ma.enset.customerservice.entity.Customer;
import ma.enset.customerservice.helper.CustomerHelper;
import ma.enset.customerservice.repository.CustomerRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Consumer;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
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
    private Customer updateCustomer(@RequestBody Customer customer,@PathVariable long id){
        return customerRepository.findById(id)
                .map(c -> {
                    customerHelper.updateIfNotNull(c::setName, customer.getName());
                    customerHelper.updateIfNotNull(c::setEmail,customer.getEmail());
                    return customerRepository.save(c);
                }).orElseThrow(() -> new IllegalArgumentException("Invalide Id"));
    }
}