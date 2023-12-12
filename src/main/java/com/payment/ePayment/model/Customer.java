package com.payment.ePayment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 2:53 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custID;
    private String name;
    private String email;
    private String mobileNumber;
    private String password;
    private String address;
    private String state = "kyc";
    private String status = "pending";
    private boolean isKycCompleted = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
