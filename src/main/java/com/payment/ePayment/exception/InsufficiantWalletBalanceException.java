package com.payment.ePayment.exception;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 11:01 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class InsufficiantWalletBalanceException extends RuntimeException {

    public InsufficiantWalletBalanceException(String error){
        super(error);
    }
}
