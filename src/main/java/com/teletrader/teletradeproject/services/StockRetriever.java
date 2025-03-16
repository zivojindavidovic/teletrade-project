package com.teletrader.teletradeproject.services;

import com.teletrader.teletradeproject.controllers.v1.stock.response.StockDTO;

import java.util.List;

public interface StockRetriever {

    List<StockDTO> getAllStocks();
}
