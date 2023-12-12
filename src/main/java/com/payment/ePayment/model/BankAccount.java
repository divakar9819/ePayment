package com.payment.ePayment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 10:33 am
 * @mail_to: vermadivakar2022@gmail.com
 */

@Entity
@Table(name="bankAccounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankAccount {

    @Id
    private String accountNumber;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    private String bankName;
    private String ifscCode;
    private double balance;
}
