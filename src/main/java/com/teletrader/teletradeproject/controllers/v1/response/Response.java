package com.teletrader.teletradeproject.controllers.v1.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T> {
    private boolean success;
    private List<ErrorResponse> errors;
    private T data;
}
