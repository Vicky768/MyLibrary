package com.library.sroy.LibraryProject.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class DateCalculationService {

    public LocalDate getExpectedReturnDate(LocalDate localDate){
        LocalDate expectedDate = localDate.plusMonths(1);

        return expectedDate;
    }

    public int getDifferenceDays(LocalDate currentDate, LocalDate expectedReturnDate)
    {
        Period period = Period.between(expectedReturnDate,currentDate);
        int diffDays = period.getDays();
        int diffMonths = period.getMonths();
        int diffYears = period.getYears();

        int diff = diffYears*365 + diffMonths*30 + diffDays;
        return diff;
    }
}
