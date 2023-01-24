package com.payrollapp.payrollapp.repositories;

import com.payrollapp.payrollapp.dtos.CalculatorResponse;
import com.payrollapp.payrollapp.entities.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculationRepository  extends JpaRepository<Calculation, Integer> {

    @Query(value = "SELECT * FROM calculations order by id desc limit :limit", nativeQuery = true)
    public List<Calculation> findTop5(@Param("limit") int limit);

}
