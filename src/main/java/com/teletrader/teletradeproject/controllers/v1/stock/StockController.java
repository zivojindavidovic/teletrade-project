package com.teletrader.teletradeproject.controllers.v1.stock;

import com.teletrader.teletradeproject.controllers.v1.response.Response;
import com.teletrader.teletradeproject.controllers.v1.stock.response.StockDTO;
import com.teletrader.teletradeproject.controllers.v1.stock.response.StockOrderBookDTO;
import com.teletrader.teletradeproject.services.StockOrderBookRetriever;
import com.teletrader.teletradeproject.services.StockRetriever;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
@AllArgsConstructor
public class StockController {

    private final StockRetriever stockRetriever;
    private final StockOrderBookRetriever stockOrderBookRetriever;

    @GetMapping
    public ResponseEntity<Response<List<StockDTO>>> getAllStocks() {
        List<StockDTO> result = stockRetriever.getAllStocks();

        return ResponseEntity.ok(
                Response.<List<StockDTO>>builder()
                        .success(true)
                        .errors(List.of())
                        .data(result)
                        .build()
        );
    }

    @GetMapping("/{stockId}")
    public ResponseEntity<Response<StockDTO>> getStockById(@PathVariable Long stockId) {
        StockDTO result = stockRetriever.getById(stockId);

        return ResponseEntity.ok(
            Response.<StockDTO>builder()
                    .success(true)
                    .errors(List.of())
                    .data(result)
                    .build()
        );
    }

    @MessageMapping("/{stockId}/order-book")
    @SendTo("/topic/{stockId}/order-book")
    public ResponseEntity<StockOrderBookDTO> getOrderBookByStockId(@DestinationVariable Long stockId) {
        StockOrderBookDTO result = stockOrderBookRetriever.getOrderBookByStockId(stockId);

        return ResponseEntity.ok(result);
    }
}
