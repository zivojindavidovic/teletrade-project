package com.teletrader.teletradeproject.controllers.v1.order;

import com.teletrader.teletradeproject.controllers.v1.order.request.OrderSaveDTO;
import com.teletrader.teletradeproject.controllers.v1.order.request.OrderSaveResultDTO;
import com.teletrader.teletradeproject.controllers.v1.response.Response;
import com.teletrader.teletradeproject.services.OrderPersistence;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderPersistence orderPersistence;

    @PostMapping
    public ResponseEntity<Response<OrderSaveResultDTO>> saveOrder(@RequestBody @Valid OrderSaveDTO orderSaveDTO) {
        OrderSaveResultDTO result = orderPersistence.saveOrderAndEmmitChanges(orderSaveDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Response.<OrderSaveResultDTO>builder()
                        .success(true)
                        .errors(List.of())
                        .data(result)
                        .build()
                );
    }
}
