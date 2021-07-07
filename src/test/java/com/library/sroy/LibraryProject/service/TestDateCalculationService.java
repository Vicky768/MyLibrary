package com.library.sroy.LibraryProject.service;


import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestDateCalculationService {

    DateCalculationService dateCalculationService = null;

    @Before
    public void setDateCalculationService(){dateCalculationService = new DateCalculationService();}

    @Test
    public void testExpectedReturnDate(){
        LocalDate localDate = LocalDate.now();
        LocalDate expectedDate = dateCalculationService.getExpectedReturnDate(localDate);
        assertEquals(localDate,expectedDate);
    }

    @Test
    public void testDifferenceInDays(){
        LocalDate expectedReturnDate = LocalDate.now();
        LocalDate currentReturnDate = expectedReturnDate.plusDays(20);
        int diff = dateCalculationService.getDifferenceDays(expectedReturnDate,currentReturnDate);
        assertEquals(10,diff);
    }

}