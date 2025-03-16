package com.teletrader.teletradeproject.commands;

import com.teletrader.teletradeproject.controllers.v1.order.request.OrderSaveDTO;
import com.teletrader.teletradeproject.enums.OrderType;
import com.teletrader.teletradeproject.exceptions.StockNotFoundException;
import com.teletrader.teletradeproject.exceptions.UserNotFoundException;
import com.teletrader.teletradeproject.models.Order;
import com.teletrader.teletradeproject.models.Stock;
import com.teletrader.teletradeproject.models.User;
import com.teletrader.teletradeproject.repository.OrderRepository;
import com.teletrader.teletradeproject.repository.StockRepository;
import com.teletrader.teletradeproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveOrderCommand {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final StockRepository stockRepository;

    public Order execute(OrderSaveDTO orderSaveDTO) {
        User user = userRepository.findById(orderSaveDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + orderSaveDTO.getUserId()));

        Stock stock = stockRepository.findById(orderSaveDTO.getStockId())
                .orElseThrow(() -> new StockNotFoundException("Stock not found with ID: " + orderSaveDTO.getStockId()));

        Order order = Order.builder()
                .user(user)
                .stock(stock)
                .quantity(orderSaveDTO.getQuantity())
                .price(orderSaveDTO.getPrice())
                .type(OrderType.valueOf(orderSaveDTO.getType()))
                .build();

        return orderRepository.save(order);
    }
}
