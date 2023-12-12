package com.payment.ePayment.serviceImpl;

import com.payment.ePayment.dto.CustomerDto;
import com.payment.ePayment.exception.ResourceNotFoundException;
import com.payment.ePayment.model.Customer;
import com.payment.ePayment.model.Wallet;
import com.payment.ePayment.payload.ApiResponse;
import com.payment.ePayment.repository.CustomerRepository;
import com.payment.ePayment.repository.WalletRepository;
import com.payment.ePayment.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 3:03 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerDtoToCustomer(customerDto);
        System.out.println(customerDto);
        Wallet wallet = new Wallet();
        wallet.setBalance(0.0);
        wallet.setWalletId(getRandomWalletId());
        //walletRepository.save(wallet);
        customer.setWallet(wallet);
        System.out.println(customer);
        Customer createdCustomer = customerRepository.save(customer);
        return customerToCustomerDto(createdCustomer);
    }

    @Override
    public ApiResponse doOkyc(int id,CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","customerId",String.valueOf(id)));
        customer.setKycCompleted(true);
        customer.setState("active");
        customer.setStatus("completed");
        customer.setAddress(customerDto.getAddress());
        Customer createdCustomer = customerRepository.save(customer);
        ApiResponse apiResponse = new ApiResponse("User kyc done successfully",true);
        return apiResponse;
    }

    @Override
    public CustomerDto getCustomerByName(String name) {
        Customer customer = customerRepository.findByName(name);
        if(customer == null){
            throw new ResourceNotFoundException("Customer","CustomerName",name);
        }
        else {
            return customerToCustomerDto(customer);
        }

    }

    @Override
    public CustomerDto getCustomerByCustomerId(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","customerId",String.valueOf(id)));
        return this.customerToCustomerDto(customer);
    }

    public Customer customerDtoToCustomer(CustomerDto customerDto){
        return this.modelMapper.map(customerDto,Customer.class);
    }

    public CustomerDto customerToCustomerDto(Customer customer) {
        return this.modelMapper.map(customer, CustomerDto.class);
    }

    public static int getRandomWalletId(){
        int min = 100000000;
        int max = 999999999;
        Random random = new Random();
        int walletId = random.nextInt(max-min)+min;
        return walletId;
    }

}
