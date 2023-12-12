package com.payment.ePayment.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 5:50 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFoundException(String resourceName,String fieldName,String fieldValue){
        super(String.format("%s is not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
