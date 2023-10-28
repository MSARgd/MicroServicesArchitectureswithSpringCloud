package ma.enset.orderservice.entity.projection;

import com.fasterxml.jackson.databind.DatabindException;
import ma.enset.orderservice.entity.Order;
import ma.enset.orderservice.entity.ProductItem;
import ma.enset.orderservice.entity.enums.OrderSatus;
import ma.enset.orderservice.model.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name = "fullOrder",types = Order.class)
public interface FullOder {
    Long getId();
    Date getCreatedAt();
    OrderSatus getStatue();
    Long getCustomerId();
    Customer getCustomer();
    List<ProductItem> getProductItems();

}
