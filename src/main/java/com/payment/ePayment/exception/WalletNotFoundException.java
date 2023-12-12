package com.payment.ePayment.exception;

/**
 * @author Divakar Verma
 * @created_at : 12/12/2023 - 10:46 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class WalletNotFoundException extends RuntimeException{

    public WalletNotFoundException(String error){
        super(error);
    }
}
