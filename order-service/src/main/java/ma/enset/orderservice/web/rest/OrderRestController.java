package ma.enset.orderservice.web.rest;

import lombok.AllArgsConstructor;
import ma.enset.orderservice.entity.Order;
import ma.enset.orderservice.model.Customer;
import ma.enset.orderservice.model.Product;
import ma.enset.orderservice.repository.OrderRepository;
import ma.enset.orderservice.repository.ProductItemRepository;
import ma.enset.orderservice.service.CustomerOpenFeingClientService;
import ma.enset.orderservice.service.ProductOpenFeingClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerOpenFeingClientService customerOpenFeingClientService;
    private ProductOpenFeingClientService productOpenFeingClientService;
    @GetMapping("fullOrder/{id}")
    private Order orderById(@PathVariable("id") long id){
        Order order = orderRepository.findById(id).get();
        Customer customer = customerOpenFeingClientService.CustomerById(order.getCustomerId());
        order.setCustomer(customer);

        order.getProductItems().forEach(productItem -> {
            Product product = productOpenFeingClientService.productById(productItem.getId());
            productItem.setProduct(product);
        });


        return order;

    }
    @GetMapping("/orders")
    private List<Order> allOrders(){
        return orderRepository.findAll();
    }
    @PostMapping("/orders")
    private Order saveOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }
    @PutMapping("/orders")
    private Order updateOrder(){
        return null;
    }
    @DeleteMapping("/orders/{id}")
    private void deleteOrder(@PathVariable long id){
        orderRepository.deleteById(id);
    }

}
