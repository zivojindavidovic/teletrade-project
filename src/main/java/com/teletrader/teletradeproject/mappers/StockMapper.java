package com.teletrader.teletradeproject.mappers;

import com.teletrader.teletradeproject.controllers.v1.stock.response.StockDTO;
import com.teletrader.teletradeproject.models.Stock;

import java.util.List;

public class StockMapper {

    public static List<StockDTO> toStocksResponse(List<Stock> stocks) {
        return stocks.stream()
                .map(stock -> StockDTO.builder()
                        .stockId(stock.getStockId())
                        .symbol(stock.getSymbol())
                        .build()
                ).toList();
    }
}
