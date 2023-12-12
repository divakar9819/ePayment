package com.payment.ePayment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 10:39 am
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankAccountDto {
    private String bankName;
    private String accountNumber;
    private String ifscCode;
    private double balance;
}
