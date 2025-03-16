package com.teletrader.teletradeproject.handlers;

import com.teletrader.teletradeproject.controllers.v1.stock.response.StockOrderBookDTO;
import com.teletrader.teletradeproject.services.StockOrderBookRetriever;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderBookChangesHandler {

    private final SimpMessagingTemplate messagingTemplate;
    private final StockOrderBookRetriever stockOrderBookRetriever;

    public void handleOrderBookChanges(Long stockId) {
        StockOrderBookDTO orderBook = stockOrderBookRetriever.getOrderBookByStockId(stockId);

        messagingTemplate.convertAndSend("/topic/" + stockId + "/order-book", orderBook);
    }
}
