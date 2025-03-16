package com.teletrader.teletradeproject.services;

import com.teletrader.teletradeproject.controllers.v1.order.request.OrderSaveDTO;
import com.teletrader.teletradeproject.controllers.v1.order.request.OrderSaveResultDTO;

public interface OrderPersistence {

    OrderSaveResultDTO saveOrderAndEmmitChanges(OrderSaveDTO orderSaveDTO);
}
