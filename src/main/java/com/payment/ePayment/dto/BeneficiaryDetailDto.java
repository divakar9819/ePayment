package com.payment.ePayment.dto;

import com.payment.ePayment.model.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 5:35 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeneficiaryDetailDto {
    private int walletId;
    private String beneficiaryName;
    private String beneficiaryMobileNumber;
    private BankAccount bankAccount;
}
