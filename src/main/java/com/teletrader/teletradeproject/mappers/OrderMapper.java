package com.teletrader.teletradeproject.mappers;

import com.teletrader.teletradeproject.controllers.v1.order.response.OrderSaveResultDTO;
import com.teletrader.teletradeproject.models.Order;

public class OrderMapper {

    public static OrderSaveResultDTO toOrderSaveResponse(Order order) {
        return OrderSaveResultDTO.builder()
                .orderId(order.getOrderId())
                .price(order.getPrice())
                .quantity(order.getQuantity())
                .type(order.getType().toString())
                .build();
    }
}
