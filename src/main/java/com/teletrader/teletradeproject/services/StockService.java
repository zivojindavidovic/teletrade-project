package com.teletrader.teletradeproject.services;

import com.teletrader.teletradeproject.commands.GetAllStocksCommand;
import com.teletrader.teletradeproject.commands.GetOrderBookByStockIdCommand;
import com.teletrader.teletradeproject.commands.GetStockByIdCommand;
import com.teletrader.teletradeproject.controllers.v1.stock.response.StockDTO;
import com.teletrader.teletradeproject.controllers.v1.stock.response.StockOrderBookDTO;
import com.teletrader.teletradeproject.mappers.OrderMapper;
import com.teletrader.teletradeproject.mappers.StockMapper;
import com.teletrader.teletradeproject.models.Order;
import com.teletrader.teletradeproject.models.Stock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockService implements StockRetriever, StockOrderBookRetriever{

    private final GetAllStocksCommand getAllStocksCommand;
    private final GetStockByIdCommand getStockByIdCommand;
    private final GetOrderBookByStockIdCommand getOrderBookByStockIdCommand;

    @Override
    public List<StockDTO> getAllStocks() {
        List<Stock> stocks = getAllStocksCommand.execute();

        return StockMapper.toStocksResponse(stocks);
    }

    @Override
    public StockDTO getById(Long stockId) {
        Stock stock = getStockByIdCommand.execute(stockId);

        return StockMapper.toStockResponse(stock);
    }

    @Override
    public StockOrderBookDTO getOrderBookByStockId(Long stockId) {
        List<Order> orders = getOrderBookByStockIdCommand.execute(stockId);

        return OrderMapper.toOrderBookResponse(stockId, orders);
    }
}
