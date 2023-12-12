package com.payment.ePayment.serviceImpl;

import com.payment.ePayment.dto.BeneficiaryDetailDto;
import com.payment.ePayment.exception.ResourceNotFoundException;
import com.payment.ePayment.model.BeneficiaryDetail;
import com.payment.ePayment.model.Wallet;
import com.payment.ePayment.repository.BeneficiaryDetailRepository;
import com.payment.ePayment.repository.WalletRepository;
import com.payment.ePayment.service.BeneficiaryDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Divakar Verma
 * @created_at : 08/12/2023 - 5:37 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Service
public class BeneficiaryDetailServiceImpl implements BeneficiaryDetailService {

    @Autowired
    private BeneficiaryDetailRepository beneficiaryDetailRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public BeneficiaryDetailDto createBeneficiary(BeneficiaryDetailDto beneficiaryDetailDto) {
        int walletId = beneficiaryDetailDto.getWalletId();
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(()-> new ResourceNotFoundException("Wallet","WalletId",Integer.toString(walletId)));
        BeneficiaryDetail beneficiaryDetail = beneficiaryDtoToBeneficiaryDetail(beneficiaryDetailDto);
        BeneficiaryDetail createdBeneficiary = beneficiaryDetailRepository.save(beneficiaryDetail);
        return beneficiaryToBeneficiaryDto(createdBeneficiary);
    }

    @Override
    public BeneficiaryDetailDto getBeneficiaryByAccountNumber(String accountNumber) {
        BeneficiaryDetail beneficiaryDetail = beneficiaryDetailRepository.findByBankAccount_AccountNumber(accountNumber);
        if(beneficiaryDetail==null){
            throw new ResourceNotFoundException("Beneficiary","accountNumber",accountNumber);
        }

        return this.beneficiaryToBeneficiaryDto(beneficiaryDetail);
    }

    @Override
    public BeneficiaryDetailDto updateBeneficiary(BeneficiaryDetailDto beneficiaryDetailDto) {
        BeneficiaryDetail beneficiaryDetail = beneficiaryDtoToBeneficiaryDetail(beneficiaryDetailDto);
        BeneficiaryDetail updatedBeneficiary = beneficiaryDetailRepository.save(beneficiaryDetail);
        return beneficiaryToBeneficiaryDto(updatedBeneficiary);
    }

    public BeneficiaryDetail beneficiaryDtoToBeneficiaryDetail(BeneficiaryDetailDto beneficiaryDetailDto){
        return this.modelMapper.map(beneficiaryDetailDto,BeneficiaryDetail.class);
    }

    public BeneficiaryDetailDto beneficiaryToBeneficiaryDto(BeneficiaryDetail beneficiaryDetail){
        return this.modelMapper.map(beneficiaryDetail,BeneficiaryDetailDto.class);
    }
}
