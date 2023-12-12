package com.payment.ePayment.repository;

import com.payment.ePayment.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 4:20 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet,Integer> {
}
