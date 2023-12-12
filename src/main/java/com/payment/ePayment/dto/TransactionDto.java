package com.payment.ePayment.dto;

import com.payment.ePayment.payload.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 11:02 am
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDto {
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
