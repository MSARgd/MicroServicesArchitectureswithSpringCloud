package ma.enset.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.orderservice.model.Product;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String name;
    private double price;
    private long quantity; // quantity of order # quantity of product
    private double discount;
    @ManyToOne
    @JoinColumn(name = "Order_Id")
    private Order order;
    @Transient
    private Product product;

}