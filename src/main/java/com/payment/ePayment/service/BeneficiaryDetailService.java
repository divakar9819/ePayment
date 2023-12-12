package com.payment.ePayment.service;

import com.payment.ePayment.dto.BeneficiaryDetailDto;
import com.payment.ePayment.model.BeneficiaryDetail;

/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 5:30 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface BeneficiaryDetailService {
    public BeneficiaryDetailDto createBeneficiary(BeneficiaryDetailDto beneficiaryDetailDto);
    public BeneficiaryDetailDto getBeneficiaryByAccountNumber(String accountNumber);

    public BeneficiaryDetailDto updateBeneficiary(BeneficiaryDetailDto beneficiaryDetailDto);


}
