package ma.enset.inventoryservice.entity.projection;
import ma.enset.inventoryservice.entity.Product;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "fullProduct",types = Product.class)
public interface FullProduct  {
    public long getId();
    public String getName();
    public double getPrice();
    public long getQuantity();

}