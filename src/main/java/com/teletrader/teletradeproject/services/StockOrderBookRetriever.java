package com.teletrader.teletradeproject.services;

import com.teletrader.teletradeproject.controllers.v1.stock.response.StockOrderBookDTO;

public interface StockOrderBookRetriever {

    StockOrderBookDTO getOrderBookByStockId(Long stockId);
}
