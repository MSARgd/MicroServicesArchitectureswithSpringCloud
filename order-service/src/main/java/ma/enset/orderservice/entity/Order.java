package ma.enset.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.enset.orderservice.entity.enums.OrderSatus;
import ma.enset.orderservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    private OrderSatus statue;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProductItem> productItems;




}

