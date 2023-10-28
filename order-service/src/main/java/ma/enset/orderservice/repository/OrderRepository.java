package ma.enset.orderservice.repository;

import ma.enset.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderRepository  extends JpaRepository<Order,Long> {
    @RestResource(path = "ByCustomerId")
    List<Order> findByCustomerId(@Param("CustomerId") Long customerId);
}
