package com.payment.ePayment.service;

import com.payment.ePayment.dto.TransactionDto;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 11:07 am
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface TransactionService {

    public TransactionDto pay(TransactionDto transactionDto);

    public List<TransactionDto> getAllTransaction();
}
