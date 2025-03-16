package com.teletrader.teletradeproject.repository;

import com.teletrader.teletradeproject.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
