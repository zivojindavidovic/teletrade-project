package com.teletrader.teletradeproject.handlers;

import com.teletrader.teletradeproject.controllers.v1.response.ErrorResponse;
import com.teletrader.teletradeproject.controllers.v1.response.Response;
import com.teletrader.teletradeproject.exceptions.StockNotFoundException;
import com.teletrader.teletradeproject.exceptions.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<Response<Void>> handleStockNotFoundException(StockNotFoundException ex) {
        List<ErrorResponse> errorInfos = List.of(new ErrorResponse("stockId", ex.getMessage()));

        Response<Void> body = Response.<Void>builder()
                .success(false)
                .errors(errorInfos)
                .data(null)
                .build();

        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response<Void>> handleStockNotFoundException(UserNotFoundException ex) {
        List<ErrorResponse> errorInfos = List.of(new ErrorResponse("userId", ex.getMessage()));

        Response<Void> body = Response.<Void>builder()
                .success(false)
                .errors(errorInfos)
                .data(null)
                .build();

        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        List<ErrorResponse> errorInfos = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError fieldError) {
                errorInfos.add(new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()));
            } else {
                errorInfos.add(new ErrorResponse(error.getObjectName(), error.getDefaultMessage()));
            }
        });

        Response<Void> body = Response.<Void>builder()
                .success(false)
                .errors(errorInfos)
                .data(null)
                .build();

        return new ResponseEntity<>(body, headers, status);
    }
}
