package com.teletrader.teletradeproject.mappers;

import com.teletrader.teletradeproject.controllers.v1.order.response.OrderDTO;
import com.teletrader.teletradeproject.controllers.v1.order.response.OrderSaveResultDTO;
import com.teletrader.teletradeproject.controllers.v1.stock.response.StockOrderBookDTO;
import com.teletrader.teletradeproject.models.Order;

import java.util.List;

public class OrderMapper {

    public static OrderSaveResultDTO toOrderSaveResponse(Order order) {
        return OrderSaveResultDTO.builder()
                .orderId(order.getOrderId())
                .price(order.getPrice())
                .quantity(order.getQuantity())
                .type(order.getType().toString())
                .build();
    }

    public static List<OrderDTO> toOrdersResponse(List<Order> orders) {
        return orders.stream()
                .map(order -> OrderDTO.builder()
                        .orderId(order.getOrderId())
                        .price(order.getPrice())
                        .quantity(order.getQuantity())
                        .type(order.getType().toString())
                        .build())
                .toList();
    }

    public static StockOrderBookDTO toOrderBookResponse(Long stockId, List<Order> orders) {
        return StockOrderBookDTO.builder()
                .stockId(stockId)
                .orders(toOrdersResponse(orders))
                .build();
    }
}
