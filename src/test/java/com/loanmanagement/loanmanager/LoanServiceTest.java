package com.loanmanagement.loanmanager;

import com.loanmanagement.loanmanager.entity.Loan;
import com.loanmanagement.loanmanager.repository.LoanRepository;
import com.loanmanagement.loanmanager.service.LoanService;
import com.loanmanagement.loanmanager.service.LoanServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanServiceImpl loanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLoanValidPaymentDate() {
        Loan loan = createSampleLoan();
        Mockito.when(loanRepository.save(loan)).thenReturn(loan);

        Loan savedLoan = loanService.createLoan(loan);
        Assertions.assertEquals(loan, savedLoan);
    }

    @Test
    void testCreateLoanInvalidPaymentDate() {
        Loan loan = createSampleLoan();
        loan.setPaymentDate(new Date(2023, 8, 5)); // Setting a payment date greater than the due date.

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(loan);
        });
    }

    // Utility method to create a sample Loan
    private Loan createSampleLoan() {
        Loan loan = new Loan();
        loan.setLoanId("L1");
        loan.setCustomerId("C1");
        loan.setLenderId("LEN1");
        loan.setAmount(10000d);
        loan.setRemainingAmount(10000d);
        loan.setPaymentDate(new Date(2023, 6, 5));
        loan.setInterestPerDay(0.01);
        loan.setDueDate(new Date(2023, 7, 5));
        loan.setPenaltyPerDay(0.01);
        loan.setCanceled(false);
        return loan;
    }
}
