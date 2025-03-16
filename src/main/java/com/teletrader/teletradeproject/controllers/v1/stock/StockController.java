package com.teletrader.teletradeproject.controllers.v1.stock;

import com.teletrader.teletradeproject.controllers.v1.response.Response;
import com.teletrader.teletradeproject.controllers.v1.stock.response.StockDTO;
import com.teletrader.teletradeproject.services.StockRetriever;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
@AllArgsConstructor
public class StockController {

    private final StockRetriever stockRetriever;

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
}
