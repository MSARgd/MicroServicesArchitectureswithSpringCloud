package ma.enset.customerservice.entity.projection;
import ma.enset.customerservice.entity.Customer;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "fullCustomer",types = Customer.class)
public interface FullCustomer {
    public long getId();
    public String getName();
    public String getEmail();

}