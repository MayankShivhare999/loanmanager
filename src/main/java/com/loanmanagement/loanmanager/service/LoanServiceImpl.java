package com.loanmanagement.loanmanager.service;

import com.loanmanagement.loanmanager.entity.Loan;
import com.loanmanagement.loanmanager.repository.LoanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    private LoanRepository loanRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);


    public Loan createLoan(Loan loan) {
        if (loan.getPaymentDate().after(loan.getDueDate())) {
            logger.warn("ALERT: Loan ID " + loan.getLoanId() + " has crossed the due date.");
            throw new IllegalArgumentException("Payment date can't be greater than the due date.");
        }
        return loanRepository.save(loan);
    }
}
