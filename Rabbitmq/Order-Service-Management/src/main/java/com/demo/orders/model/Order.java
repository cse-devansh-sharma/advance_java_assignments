package com.demo.orders.model;



import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;



@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
 
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
 
    private String productName;
    private int quantity;
    private double price;
    private String customerEmail;
 
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
 
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
 
    public enum OrderStatus {
        PLACED, 
        PROCESSING,
        COMPLETED,
        FAILED
    }
}