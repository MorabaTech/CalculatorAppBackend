package com.payrollapp.payrollapp.services;

import com.payrollapp.payrollapp.dtos.CalculationsRequest;
import com.payrollapp.payrollapp.dtos.CalculatorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalculatorService {


    ResponseEntity<CalculatorResponse> performCalculations(CalculationsRequest request);

    ResponseEntity<List<CalculatorResponse>> getCalculations();
}
