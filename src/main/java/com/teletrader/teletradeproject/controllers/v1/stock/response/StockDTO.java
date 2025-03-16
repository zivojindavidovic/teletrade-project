package com.teletrader.teletradeproject.controllers.v1.stock.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDTO {
    private Long stockId;
    private String symbol;
}
