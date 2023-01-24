package com.payrollapp.payrollapp.dtos;

import lombok.Data;

@Data
public class CalculationsRequest {

    private double firstNumber ;
    private double secondNumber;
    private char operator;
}
