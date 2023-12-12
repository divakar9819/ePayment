package com.payment.ePayment.serviceImpl;

import com.payment.ePayment.dto.TransactionDto;
import com.payment.ePayment.exception.InsufficiantWalletBalanceException;
import com.payment.ePayment.exception.InvalidTransactionTypeException;
import com.payment.ePayment.exception.ResourceNotFoundException;
import com.payment.ePayment.exception.WalletNotFoundException;
import com.payment.ePayment.model.*;
import com.payment.ePayment.payload.TransactionType;
import com.payment.ePayment.repository.BeneficiaryDetailRepository;
import com.payment.ePayment.repository.CustomerRepository;
import com.payment.ePayment.repository.TransactionRepository;
import com.payment.ePayment.repository.WalletRepository;
import com.payment.ePayment.service.BeneficiaryDetailService;
import com.payment.ePayment.service.TransactionService;
import com.payment.ePayment.service.WalletService;
import com.payment.ePayment.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.payment.ePayment.utils.Helper.getLocalDateTime;
import static com.payment.ePayment.utils.Helper.getUUID;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 11:07 am
 * @mail_to: vermadivakar2022@gmail.com
 */
@Service
public class TransactionServiceimpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BeneficiaryDetailRepository beneficiaryDetailRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletService walletService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public TransactionDto pay(TransactionDto transactionDto) {
        Customer customer = customerRepository.findByWallet_WalletId(transactionDto.getWalletId());
        if(customer==null){
            throw new ResourceNotFoundException("Customer","walletId",String.valueOf(transactionDto.getWalletId()));
        }
        else if(!customer.isKycCompleted()){
            throw new WalletNotFoundException("Wallet not active of this customer");
        }
        transactionDto.setTransactionId(getUUID());
        transactionDto.setCreatedAt(getLocalDateTime());
        transactionDto.setUpdatedAt(getLocalDateTime());
        Transaction createdTransaction = null;
        if (transactionDto.getTransactionType().equalsIgnoreCase(TransactionType.WALLET_TO_BANK.toString())) {
            BeneficiaryDetail beneficiaryDetail = beneficiaryDetailRepository.findByBankAccount_AccountNumber(transactionDto.getAccountNumber());
            if (beneficiaryDetail == null) {
                throw new ResourceNotFoundException("Beneficiary", "Bank account number", transactionDto.getAccountNumber());
            }
            if (!beneficiaryDetail.getBankAccount().getIfscCode().equalsIgnoreCase(transactionDto.getIfscCode())) {
                throw new ResourceNotFoundException("Beneficiary", "ifscCode", transactionDto.getIfscCode());
            }
            if (!beneficiaryDetail.getBankAccount().getBankName().equalsIgnoreCase(transactionDto.getBankName())) {
                throw new ResourceNotFoundException("Beneficiary", "Bank name", transactionDto.getBankName());
            }

            Wallet wallet = walletRepository.findById(transactionDto.getWalletId()).orElseThrow(() -> new ResourceNotFoundException("Wallet", "WalletId", String.valueOf(transactionDto.getWalletId())));

            double walletBalance = wallet.getBalance();
            if (transactionDto.getAmount() > walletBalance) {
                throw new InsufficiantWalletBalanceException("Insufficient wallet balance");
            }

            wallet.setBalance(wallet.getBalance() - transactionDto.getAmount());
            walletService.updateWallet(wallet);
            BankAccount bankAccount = beneficiaryDetail.getBankAccount();
            bankAccount.setBalance(bankAccount.getBalance() + transactionDto.getAmount());
            beneficiaryDetail.setBankAccount(bankAccount);
            BeneficiaryDetail beneficiaryDetail1 = beneficiaryDetailRepository.save(beneficiaryDetail);
            System.out.println(beneficiaryDetail1);

            System.out.println(transactionDto);
            Transaction transaction = transactionDtoToTransaction(transactionDto);
            createdTransaction = transactionRepository.save(transaction);


        } else if (transactionDto.getTransactionType().equalsIgnoreCase(TransactionType.WALLET_TO_WALLET.toString())) {
            Customer customer1 = customerRepository.findByMobileNumber(transactionDto.getBeneficiaryMobileNumber());
            if(customer1==null){
                throw new ResourceNotFoundException("Customer","mobileNumber",transactionDto.getBeneficiaryMobileNumber());
            }
            else if(!customer1.isKycCompleted()){
                throw new WalletNotFoundException("Wallet not active of this customer");
            }

            Wallet senderWallet = walletRepository.findById(transactionDto.getWalletId()).orElseThrow(() -> new ResourceNotFoundException("Wallet", "WalletId", String.valueOf(transactionDto.getWalletId())));
            double senderWalletBalance = senderWallet.getBalance();
            if(transactionDto.getAmount()> senderWalletBalance){
                throw new InsufficiantWalletBalanceException("Insufficiant wallet balance");
            }
            Wallet receiverWallet = walletRepository.findById(customer1.getWallet().getWalletId()).orElseThrow(() -> new ResourceNotFoundException("Wallet", "WalletId", String.valueOf(customer1.getWallet().getWalletId())));
            double receiverWalletBalance = receiverWallet.getBalance();
            senderWallet.setBalance(senderWalletBalance-transactionDto.getAmount());
            receiverWallet.setBalance(receiverWalletBalance+transactionDto.getAmount());
            walletService.updateWallet(senderWallet);
            walletService.updateWallet(receiverWallet);
            Transaction transaction = transactionDtoToTransaction(transactionDto);
            createdTransaction = transactionRepository.save(transaction);

        } else {
            throw new InvalidTransactionTypeException("Invalid transaction type");
        }
        return transactionToTransactionDto(createdTransaction);
    }

    @Override
    public List<TransactionDto> getAllTransaction() {
        List<Transaction> transactions = transactionRepository.findAll();
        Collections.sort(transactions,Comparator.comparing(Transaction::getCreatedAt).reversed());
        List<TransactionDto> transactionDtos = transactions.stream().map(this::transactionToTransactionDto).toList();
        return transactionDtos;
    }

    public Transaction transactionDtoToTransaction(TransactionDto transactionDto) {
        return this.modelMapper.map(transactionDto, Transaction.class);
    }

    public TransactionDto transactionToTransactionDto(Transaction transaction) {
        return this.modelMapper.map(transaction, TransactionDto.class);
    }
}
