package com.payment.ePayment.controller;

import com.payment.ePayment.dto.CustomerDto;
import com.payment.ePayment.payload.ApiResponse;
import com.payment.ePayment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 3:37 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/home")
    public String home(){
        return "customer home";
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customerDto1 = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerDto1, HttpStatus.CREATED);
    }

    @GetMapping("/getCustomerByName")
    public ResponseEntity<CustomerDto> getCustomerByName(@RequestParam String name){
        CustomerDto customerDto = customerService.getCustomerByName(name);
        return new ResponseEntity<>(customerDto,HttpStatus.OK);
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer id){
        CustomerDto customerDto = customerService.getCustomerByCustomerId(id);
        return new ResponseEntity<>(customerDto,HttpStatus.OK);
    }

    @PostMapping("/kyc/{id}")
    public ResponseEntity<ApiResponse> doKyc( @PathVariable Integer id,@RequestBody CustomerDto customerDto){
        ApiResponse apiResponse = customerService.doOkyc(id,customerDto);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }
}
