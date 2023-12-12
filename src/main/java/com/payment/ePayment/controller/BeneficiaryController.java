package com.payment.ePayment.controller;

import com.payment.ePayment.dto.BeneficiaryDetailDto;
import com.payment.ePayment.service.BeneficiaryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Divakar Verma
 * @created_at : 10/12/2023 - 8:50 am
 * @mail_to: vermadivakar2022@gmail.com
 */

@RestController
@RequestMapping("api/v1/beneficiary")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryDetailService beneficiaryDetailService;

    @GetMapping("/home")
    public String home(){
        return "Beneficiary home";
    }

    @PostMapping("/createBeneficiary")
    public ResponseEntity<BeneficiaryDetailDto> createBeneficiary(@RequestBody BeneficiaryDetailDto beneficiaryDetailDto){
        BeneficiaryDetailDto createdBeneficiary = beneficiaryDetailService.createBeneficiary(beneficiaryDetailDto);
        return new ResponseEntity<>(createdBeneficiary, HttpStatus.CREATED);
    }

    @GetMapping("/accountNumber/{accountNumber}")
    public ResponseEntity<BeneficiaryDetailDto> getBeneficiaryByAccountNumber(@PathVariable String accountNumber){
        BeneficiaryDetailDto beneficiaryDetailDto = beneficiaryDetailService.getBeneficiaryByAccountNumber(accountNumber);
        return new ResponseEntity<>(beneficiaryDetailDto,HttpStatus.OK);
    }

}
