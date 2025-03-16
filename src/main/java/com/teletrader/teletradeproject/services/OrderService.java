package com.teletrader.teletradeproject.services;

import com.teletrader.teletradeproject.commands.SaveOrderCommand;
import com.teletrader.teletradeproject.controllers.v1.order.request.OrderSaveDTO;
import com.teletrader.teletradeproject.controllers.v1.order.response.OrderSaveResultDTO;
import com.teletrader.teletradeproject.handlers.OrderBookChangesHandler;
import com.teletrader.teletradeproject.mappers.OrderMapper;
import com.teletrader.teletradeproject.models.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService implements OrderPersistence{

    private final SaveOrderCommand saveOrderCommand;
    private final OrderBookChangesHandler orderBookChangesHandler;

    @Override
    public OrderSaveResultDTO saveOrderAndEmmitChanges(OrderSaveDTO orderSaveDTO) {
        Order order = saveOrderCommand.execute(orderSaveDTO);
        orderBookChangesHandler.handleOrderBookChanges(orderSaveDTO.getStockId());

        return OrderMapper.toOrderSaveResponse(order);
    }
}
