package com.payment.ePayment.repository;

import com.payment.ePayment.model.BeneficiaryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 5:29 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Repository
public interface BeneficiaryDetailRepository extends JpaRepository<BeneficiaryDetail,Integer> {

    public BeneficiaryDetail findByBankAccount_AccountNumber(String accountNumber);

}
