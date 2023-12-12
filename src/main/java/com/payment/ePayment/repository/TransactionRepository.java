package com.payment.ePayment.repository;

import com.payment.ePayment.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 11:00 am
 * @mail_to: vermadivakar2022@gmail.com
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
