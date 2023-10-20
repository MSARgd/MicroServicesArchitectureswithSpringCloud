package ma.enset.inventoryservice;

import lombok.AllArgsConstructor;
import ma.enset.inventoryservice.entity.Product;
import ma.enset.inventoryservice.entity.enums.TypeProduct;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class InventoryServiceApplication implements CommandLineRunner {
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0;i<10;i++){
			Product product = Product.builder()
					.id(null)
					.name(String.valueOf(TypeProduct.values()[new Random().nextInt(TypeProduct.values().length)]))
					.price(Math.random() *100)
					.quantity(new Random().nextInt(100))
					.build();
			productRepository.save(product);


		}
		productRepository.findAll().forEach(System.out::println);

	}

}