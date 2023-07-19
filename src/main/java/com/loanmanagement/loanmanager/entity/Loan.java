package com.loanmanagement.loanmanager.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "loans")
public class Loan {
    @Id
    private String id;

    private String loanId;

    private String customerId;

    private String lenderId;

    private Double amount;

    private Double remainingAmount;

    private Date paymentDate;

    private Double interestPerDay;

    private Date dueDate;

    private Double penaltyPerDay;

    private Boolean canceled;
}
