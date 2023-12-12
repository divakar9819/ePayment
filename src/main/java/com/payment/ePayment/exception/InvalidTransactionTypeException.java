package com.payment.ePayment.exception;

/**
 * @author Divakar Verma
 * @created_at : 12/12/2023 - 11:23 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class InvalidTransactionTypeException extends RuntimeException{
    public InvalidTransactionTypeException(String exception){
        super(exception);
    }
}
