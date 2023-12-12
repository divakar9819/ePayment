package com.payment.ePayment.repository;

import com.payment.ePayment.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 10:38 am
 * @mail_to: vermadivakar2022@gmail.com
 */

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {

}
