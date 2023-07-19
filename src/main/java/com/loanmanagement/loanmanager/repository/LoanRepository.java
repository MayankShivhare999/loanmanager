package com.loanmanagement.loanmanager.repository;

import com.loanmanagement.loanmanager.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, String> {
}
