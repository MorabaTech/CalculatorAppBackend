package com.payrollapp.payrollapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="calculations")
public class Calculation {
    @Id
    @GeneratedValue
    private Integer id;
    private double firstNumber;
    private double secondNumber;
    private char operator ;
    private double result;
}
