package com.example.demo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;


@ExtendWith(MockitoExtension.class)
class VacationDaysServiceTest {

    @InjectMocks
    VacationDaysService vacationDaysService;

    @Test
    void testCalcVacationPayEquals() {
        BigDecimal val = vacationDaysService.calcVacationPay(
                new BigDecimal("100000"),
                new BigDecimal("30"));

        Assertions.assertEquals(new BigDecimal("102390"), val);
    }

    @Test
    void testCalcVacationPayNotEquals() {
        BigDecimal val = vacationDaysService.calcVacationPay(
                new BigDecimal("100000"),
                new BigDecimal("30"));

        Assertions.assertNotEquals(new BigDecimal("10000"), val);
    }

    @Test
    void isNotHoliday() {
        LocalDate date1 = LocalDate.of(2024, 9, 17);
        LocalDate date2 = LocalDate.of(2024, 1, 1);
        LocalDate date3 = LocalDate.of(2024, 1, 8);
        LocalDate date4 = LocalDate.of(2024, 11, 4);
        LocalDate date5 = LocalDate.of(2024, 5, 9);
        LocalDate date6 = LocalDate.of(2024, 6, 15);

        boolean ans1 = vacationDaysService.isNotHoliday(date1);
        boolean ans2 = vacationDaysService.isNotHoliday(date2);
        boolean ans3 = vacationDaysService.isNotHoliday(date3);
        boolean ans4 = vacationDaysService.isNotHoliday(date4);
        boolean ans5 = vacationDaysService.isNotHoliday(date5);
        boolean ans6 = vacationDaysService.isNotHoliday(date6);

        Assertions.assertTrue(ans1);
        Assertions.assertFalse(ans2);
        Assertions.assertFalse(ans3);
        Assertions.assertFalse(ans4);
        Assertions.assertFalse(ans5);
        Assertions.assertTrue(ans6);
    }


    @Test
    void calcVacationDays() {
        int vacationDays1 = vacationDaysService.calcVacationDays(
                LocalDate.of(2024, 9, 9),
                LocalDate.of(2024, 9, 15)
        );
        int vacationDays2 = vacationDaysService.calcVacationDays(
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 31)
        );


        Assertions.assertEquals(5, vacationDays1);
        Assertions.assertEquals(17, vacationDays2);
    }

    @Test
    void calcVacationPayForSpecificDays(){
        BigDecimal val = vacationDaysService.calcVacationPayForSpecificDays(
                new BigDecimal(100000),
                LocalDate.of(2024, 7, 1),
                LocalDate.of(2024, 7, 31));

        Assertions.assertEquals(new BigDecimal("78499"), val);

    }


}