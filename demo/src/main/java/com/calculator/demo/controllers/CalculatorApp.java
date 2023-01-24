package com.payrollapp.payrollapp.apis;

import com.payrollapp.payrollapp.dtos.CalculationsRequest;
import com.payrollapp.payrollapp.dtos.CalculatorResponse;
import com.payrollapp.payrollapp.services.CalculatorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/performCalculations")
    public ResponseEntity<CalculatorResponse> performCalculations(@RequestBody CalculationsRequest request){
        return calculatorService.performCalculations(request);
    }

    @GetMapping("/getCalculations")
    public ResponseEntity<List<CalculatorResponse>> getCalculations(){
        return calculatorService.getCalculations();
    }


}
