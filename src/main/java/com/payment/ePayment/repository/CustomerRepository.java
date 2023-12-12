package com.payment.ePayment.repository;

import com.payment.ePayment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer findByName(String name);
    public Customer findByWallet_WalletId(Integer walletId);
    public Customer findByMobileNumber(String mobileNumber);
}
