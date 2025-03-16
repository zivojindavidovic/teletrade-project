package com.teletrader.teletradeproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teletrader.teletradeproject.enums.OrderType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@ToString(exclude = {"user", "stock"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    private Double price;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private OrderType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    @JsonBackReference
    private Stock stock;
}
