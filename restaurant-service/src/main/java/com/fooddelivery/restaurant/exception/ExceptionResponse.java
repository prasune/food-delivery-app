package com.fooddelivery.restaurant.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private Date timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
