package com.teletrader.teletradeproject.controllers.v1.order.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {
    private Long orderId;
    private Double price;
    private Integer quantity;
    private String type;
}
