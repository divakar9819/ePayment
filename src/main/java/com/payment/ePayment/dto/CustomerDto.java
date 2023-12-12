package com.payment.ePayment.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 3:01 pm
 * @mail_to: vermadivakar2022@gmail.com
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {

    private int custID;
    private int walletId;
    private String name;
    private String email;
    private String mobileNumber;
    private String password;
    private String address;
    private String state = "kyc";
    private String status = "pending";
    private boolean isKycCompleted;

}
