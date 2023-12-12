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
public class Wallet {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    private int walletId;
    private double balance;
}
