package com.payrollapp.payrollapp.services;

import com.payrollapp.payrollapp.dtos.CalculationsRequest;
import com.payrollapp.payrollapp.dtos.CalculatorBadResponse;
import com.payrollapp.payrollapp.dtos.CalculatorResponse;
import com.payrollapp.payrollapp.entities.Calculation;
import com.payrollapp.payrollapp.repositories.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorServiceImpl implements  CalculatorService{

    @Autowired
    private CalculationRepository calculationRepository;
    @Override
    public ResponseEntity<CalculatorResponse> performCalculations(CalculationsRequest request) {

        char operator = request.getOperator();

        double result = 0.00;

        try {
            switch (operator) {
                case '+':
                    result = request.getFirstNumber() + request.getSecondNumber();
                case '-':
                    result = request.getFirstNumber() - request.getSecondNumber();
                case '*':
                    result = request.getFirstNumber() * request.getSecondNumber();
                case '/':
                    result = request.getFirstNumber() / request.getSecondNumber();
                case '%':
                    result = request.getFirstNumber() % request.getSecondNumber();
            }

            var calculation = Calculation.builder()
                    .firstNumber(request.getFirstNumber())
                    .secondNumber(request.getSecondNumber())
                    .operator(request.getOperator())
                    .result(result)
                    .build();

            Calculation calculationSaved =   calculationRepository.save(calculation);
            CalculatorResponse response = new CalculatorResponse();
            response.setFirstNumber(calculationSaved.getFirstNumber());
            response.setSecondNumber(calculationSaved.getSecondNumber());
            response.setOperator(calculationSaved.getOperator());
            response.setResult(calculationSaved.getResult());
            return ResponseEntity.ok(response);
        }
        catch(Exception e){
            CalculatorBadResponse calculatorBadResponse = new CalculatorBadResponse();
            return (ResponseEntity<CalculatorResponse>) ResponseEntity.badRequest();
        }
    }

    @Override
    public ResponseEntity<List<CalculatorResponse>> getCalculations() {

        return (ResponseEntity<List<CalculatorResponse>>) calculationRepository.findTop5(5);
    }
}
