package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
public class VacationController {


    @GetMapping("/calculate")
    BigDecimal getVacation(@RequestParam BigDecimal avgSalary, @RequestParam BigDecimal days) {
        return avgSalary
                .divide(new BigDecimal("29.3"), RoundingMode.HALF_EVEN)
                .multiply(days);
    }

}
