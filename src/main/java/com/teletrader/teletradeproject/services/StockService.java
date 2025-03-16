package com.teletrader.teletradeproject.services;

import com.teletrader.teletradeproject.commands.GetAllStocksCommand;
import com.teletrader.teletradeproject.controllers.v1.stock.response.StockDTO;
import com.teletrader.teletradeproject.mappers.StockMapper;
import com.teletrader.teletradeproject.models.Stock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockService implements StockRetriever{

    private final GetAllStocksCommand getAllStocksCommand;

    @Override
    public List<StockDTO> getAllStocks() {
        List<Stock> stocks = getAllStocksCommand.execute();

        return StockMapper.toStocksResponse(stocks);
    }
}
