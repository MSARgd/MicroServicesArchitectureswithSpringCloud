package ma.enset.inventoryservice.web.rest;

import lombok.AllArgsConstructor;
import ma.enset.inventoryservice.entity.Product;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.EventListenerProxy;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inventory")
public class InventoryRestCcontroller {
    private ProductRepository productRepository;
    @GetMapping("/products{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productRepository.findById(id).get();
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
//    @PutMapping("/products/{id}")
//    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
//
//    }
}
