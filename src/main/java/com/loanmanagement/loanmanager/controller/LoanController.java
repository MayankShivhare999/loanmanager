package com.loanmanagement.loanmanager.controller;

import com.loanmanagement.loanmanager.entity.Loan;
import com.loanmanagement.loanmanager.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/")
    public ResponseEntity<Loan> saveLoan(@RequestBody Loan loan) {
        return ResponseEntity.status(201).body(loanService.createLoan(loan));
    }
}
