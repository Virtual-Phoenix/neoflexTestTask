package com.example.demo.services;


import com.example.demo.utilities.VacationUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class VacationDaysService {


    public BigDecimal calcVacationPay(BigDecimal avgSalary, BigDecimal days) {
        return avgSalary
                .divide(new BigDecimal("29.3"), RoundingMode.HALF_EVEN)
                .multiply(days);
    }

    public BigDecimal calcVacationPayForSpecificDays(BigDecimal avgSalary, LocalDate startDate, LocalDate endDate) {
        BigDecimal vacationDays = new BigDecimal(calcVacationDays(startDate, endDate));
        return calcVacationPay(avgSalary, vacationDays);

    }


    public boolean isNotHoliday(LocalDate date) {
        for (int i = 0; i < VacationUtil.dates.length; i++) {
            if (date.getDayOfMonth() == VacationUtil.dates[i].getDayOfMonth() &&
                    date.getMonth() == VacationUtil.dates[i].getMonth()) {
                return false;
            }
        }
        return true;
    }

    public int calcVacationDays(LocalDate startDate, LocalDate endDate) {
        int vacationDays = 0;

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (date.getDayOfWeek() != DayOfWeek.SATURDAY &&
                    date.getDayOfWeek() != DayOfWeek.SUNDAY &&
                    isNotHoliday(date)) {

                vacationDays++;
            }

        }

        return vacationDays;
    }

}
