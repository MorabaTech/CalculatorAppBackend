package com.payrollapp.payrollapp.dtos;

import lombok.Data;

@Data
public class CalculatorBadResponse {

    private int  statusCode ;

    private String errorMessage;
}
