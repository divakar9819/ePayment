package com.payment.ePayment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 5:24 pm
 * @mail_to: vermadivakar2022@gmail.com
 */

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeneficiaryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int walletId;
    private String beneficiaryName;
    private String beneficiaryMobileNumber;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "walletId",referencedColumnName = "walletId")
//    private Wallet wallet;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankAccountNumber",referencedColumnName = "accountNumber")
    private BankAccount bankAccount;

}
