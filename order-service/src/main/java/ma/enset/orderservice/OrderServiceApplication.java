package ma.enset.orderservice;

import lombok.AllArgsConstructor;
import ma.enset.orderservice.entity.Order;
import ma.enset.orderservice.entity.ProductItem;
import ma.enset.orderservice.entity.enums.OrderSatus;
import ma.enset.orderservice.model.Customer;
import ma.enset.orderservice.model.Product;
import ma.enset.orderservice.repository.OrderRepository;
import ma.enset.orderservice.repository.ProductItemRepository;
import ma.enset.orderservice.service.CustomerOpenFeingClientService;
import ma.enset.orderservice.service.ProductOpenFeingClientService;
import org.bouncycastle.asn1.cmp.Challenge;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceApplication  {


	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
			CustomerOpenFeingClientService customerOpenFeingClientService,
			ProductOpenFeingClientService productOpenFeingClientService

						){
		return  args -> {
			List<Customer> customers = customerOpenFeingClientService.allCustomers().getContent().stream().toList();
			List<Product> products = productOpenFeingClientService.allProducts().getContent().stream().toList();
			Random random = new Random();
			customers.forEach(customer -> {

				Order order = Order.builder()
						.id(null)
						.customerId(customer.getId())
						.createdAt(new Date())
						.statue(OrderSatus.values()[random.nextInt(OrderSatus.values().length)])
						.build();
				Order savedOder = orderRepository.save(order);
				for (int i=0;i<products.size();i++) {
					if (Math.random()>0.50) {
						ProductItem productItem = ProductItem.builder()
								.order(savedOder)
								.productId(products.get(i).getId())
								.price(Math.random() * 1000)
								.quantity(random.nextInt(11))
								.discount(Math.random())
								.build();
						productItemRepository.save(productItem);
					}
				}


			});


		};
	}

}
