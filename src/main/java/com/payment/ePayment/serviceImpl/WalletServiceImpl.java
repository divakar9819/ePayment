package com.payment.ePayment.serviceImpl;

import com.payment.ePayment.model.Wallet;
import com.payment.ePayment.repository.WalletRepository;
import com.payment.ePayment.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 11:10 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;
    @Override
    public Wallet updateWallet(Wallet wallet) {
        Wallet updatedWallet = walletRepository.save(wallet);
        return wallet;
    }
}
