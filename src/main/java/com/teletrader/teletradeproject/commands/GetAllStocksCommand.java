package com.teletrader.teletradeproject.commands;

import com.teletrader.teletradeproject.models.Stock;
import com.teletrader.teletradeproject.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllStocksCommand {

    private final StockRepository stockRepository;

    public List<Stock> execute() {
        return stockRepository.findAll();
    }
}
