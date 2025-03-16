package com.teletrader.teletradeproject.controllers.v1.stock.response;

import com.teletrader.teletradeproject.controllers.v1.order.response.OrderDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class StockOrderBookDTO {
    private Long stockId;
    private List<OrderDTO> orders;
}
