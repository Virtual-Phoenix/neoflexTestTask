package com.example.demo.controllers;


import com.example.demo.models.VacationDate;
import com.example.demo.services.VacationDaysService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class VacationController {

    private VacationDaysService vacationDaysService;


    @GetMapping("/calculate")
    BigDecimal getVacationPay(@RequestParam BigDecimal avgSalary, @RequestParam BigDecimal days) {
        return vacationDaysService.calcVacationPay(avgSalary, days);
    }

    @GetMapping("/calculate/specific-dates")
    BigDecimal getSpecificVacationPay(@RequestBody VacationDate vacationDate) {
        return vacationDaysService.calcVacationPayForSpecificDays(vacationDate.avgSalary,
                vacationDate.startDate,
                vacationDate.endDate);
    }


}
