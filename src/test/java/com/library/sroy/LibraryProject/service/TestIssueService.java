package com.library.sroy.LibraryProject.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIssueService {

    IssueService issueService = null;

    @Before
    public void setIssueService(){issueService = new IssueService();}

    @Test
    public void TestCalculateFine(){
//        LocalDate localDate = LocalDate.now();
//        LocalDate expectedReturn = localDate.plusDays(60);
//
//        DateCalculationService dateCalculationService = new DateCalculationService();
//        int diff = dateCalculationService.getDifferenceDays(localDate,expectedReturn);
//        diff++;
//        double fine = diff * 0.50;
//        assertEquals(30.0,fine,0);

        double fine = issueService.calculateFineRate(2);
        assertEquals(2.0,fine,0.0);

    }
}
