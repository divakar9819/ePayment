package com.payment.ePayment.service;

import com.payment.ePayment.dto.CustomerDto;
import com.payment.ePayment.payload.ApiResponse;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 3:00 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface CustomerService {

    public CustomerDto createCustomer(CustomerDto customerDto);
    public ApiResponse doOkyc(int id,CustomerDto kycDetail);
    public CustomerDto getCustomerByName(String name);
    public CustomerDto getCustomerByCustomerId(int id);
}
