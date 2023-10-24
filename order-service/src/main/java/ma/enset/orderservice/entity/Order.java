package ma.enset.orderservice.entity;

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
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;



}

