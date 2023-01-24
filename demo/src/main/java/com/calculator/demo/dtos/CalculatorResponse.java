package com.payrollapp.payrollapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorResponse {
    private double firstNumber ;
    private double secondNumber;
    private char operator;
    private double result ;

}
