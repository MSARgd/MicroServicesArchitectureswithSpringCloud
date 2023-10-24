package ma.enset.orderservice.service;

import ma.enset.orderservice.model.Customer;
import ma.enset.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface ProductOpenFeingClientService {
    @GetMapping("/products/{id}?projection=fullProduct")
    public Product productById(@PathVariable("id") long id);

    @GetMapping("/products?projection=fullProduct")
    public PagedModel<Product> allProducts();


}
