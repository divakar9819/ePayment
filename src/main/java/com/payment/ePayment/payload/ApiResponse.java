package com.payment.ePayment.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 09/12/2023 - 11:39 am
 * @mail_to: vermadivakar2022@gmail.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private boolean success;
}
