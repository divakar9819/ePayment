package com.payment.ePayment.utils;

import com.payment.ePayment.dto.TransactionDto;
import com.payment.ePayment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Divakar Verma
 * @created_at : 11/12/2023 - 10:42 am
 * @mail_to: vermadivakar2022@gmail.com
 */
public class Helper {

    @Autowired
    private CustomerRepository customerRepository;

    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid);
    }

    public static LocalDateTime getLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }

    public TransactionDto walletToWallet(TransactionDto transactionDto){
        return null;
    }
}
