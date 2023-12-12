package com.payment.ePayment.controller;

import com.payment.ePayment.dto.TransactionDto;
import com.payment.ePayment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 11/12/2023 - 10:24 am
 * @mail_to: vermadivakar2022@gmail.com
 */

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/home")
    public String home(){
        return "transaction home";
    }

    @PostMapping("/pay")
    public ResponseEntity<TransactionDto> doTransaction(@RequestBody TransactionDto transactionDto){
        TransactionDto transactionDto1 = transactionService.pay(transactionDto);
        return new ResponseEntity<>(transactionDto, HttpStatus.CREATED);
    }

    @GetMapping("/history")
    public ResponseEntity<List<TransactionDto>> findAllTransaction(){
        List<TransactionDto> transactionDtos = transactionService.getAllTransaction();
        return new ResponseEntity<>(transactionDtos,HttpStatus.OK);
    }
}
