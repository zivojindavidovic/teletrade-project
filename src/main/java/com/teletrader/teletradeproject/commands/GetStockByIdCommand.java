package com.teletrader.teletradeproject.commands;

import com.teletrader.teletradeproject.exceptions.StockNotFoundException;
import com.teletrader.teletradeproject.models.Stock;
import com.teletrader.teletradeproject.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetStockByIdCommand {

    private final StockRepository stockRepository;

    public Stock execute(Long stockId) {
        return stockRepository.findById(stockId)
                .orElseThrow(() -> new StockNotFoundException("Stock not found with ID: " + stockId));
    }
}
