package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Merchant;
import com.multiclientwebsite.merchantAndProduct.entity.MerchantDTO;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchMerchantExistsException;

import java.util.List;


public interface MerchantService {
    Merchant addMerchant(MerchantDTO merchantDTO);

    Merchant getMerchant(Long merchantId) throws NoSuchMerchantExistsException;

    String updateMerchant(Long merchantId, MerchantDTO merchantDTO) throws NoSuchMerchantExistsException;

    String deleteMerchant(Long merchantId) throws NoSuchMerchantExistsException;

    List<Merchant> getAllMerchants();
}
