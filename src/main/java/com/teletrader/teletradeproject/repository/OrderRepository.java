package com.teletrader.teletradeproject.repository;

import com.teletrader.teletradeproject.enums.OrderType;
import com.teletrader.teletradeproject.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findTop10ByTypeAndStock_StockIdOrderByPrice(OrderType type, Long stockId);

    List<Order> findTop10ByTypeAndStock_StockIdOrderByPriceDesc(OrderType type, Long stockId);
}
