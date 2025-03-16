package com.teletrader.teletradeproject.commands;

import com.teletrader.teletradeproject.enums.OrderType;
import com.teletrader.teletradeproject.models.Order;
import com.teletrader.teletradeproject.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetOrderBookByStockIdCommand {

    private final OrderRepository orderRepository;

    private List<Order> orderBook;

    public List<Order> execute(Long stockId) {
        orderBook.clear();

        orderBook.addAll(orderRepository.findTop10ByTypeAndStock_StockIdOrderByPriceDesc(OrderType.BUY, stockId));
        orderBook.addAll(orderRepository.findTop10ByTypeAndStock_StockIdOrderByPrice(OrderType.SELL, stockId));

        return orderBook;
    }
}
