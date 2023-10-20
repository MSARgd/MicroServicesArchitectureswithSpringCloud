package ma.enset.customerservice;

import lombok.AllArgsConstructor;
import ma.enset.customerservice.entity.Customer;
import ma.enset.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class CustomerServiceApplication  implements CommandLineRunner {
	private CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i=0;i<10;i++){
			Customer customer = Customer.builder()
					.id(null)
					.name(UUID.randomUUID().toString().substring(0,10).replaceAll("[^a-z]",""))
					.email(UUID.randomUUID().toString().substring(0,10).replaceAll("[^a-z]","")+"@gmail.com")
					.build();
			customerRepository.save(customer);
		}
	}
}
