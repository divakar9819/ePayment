package com.payment.ePayment.model;

import com.payment.ePayment.payload.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 10:54 am
 * @mail_to: vermadivakar2022@gmail.com
 */

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

    @Id
    private String transactionId;
    private double amount;
    private String transactionType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int walletId;
    private String beneficiaryName;
    private String beneficiaryMobileNumber;
    private String bankName;
    private String accountNumber;
    private String ifscCode;
}
