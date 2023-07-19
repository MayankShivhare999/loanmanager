package com.loanmanagement.loanmanager.service;

import com.loanmanagement.loanmanager.entity.Loan;
import org.springframework.stereotype.Service;

@Service
public interface LoanService {

    public Loan createLoan(Loan loan);
}
