package ma.enset.orderservice.service;

import ma.enset.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerOpenFeingClientService {
    @GetMapping("/customers/{id}?projection=fullCustomer")
    public Customer CustomerById(@PathVariable("id") long id);
    @GetMapping("/customers?projection=fullCustomer")
    public PagedModel<Customer> allCustomers();
}
