package com.multiclientwebsite.merchantAndProduct.controller;

import com.multiclientwebsite.merchantAndProduct.entity.Merchant;
import com.multiclientwebsite.merchantAndProduct.entity.MerchantDTO;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchMerchantExistsException;
import com.multiclientwebsite.merchantAndProduct.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/merchants")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping("/")
    public Merchant addMerchant(@RequestBody MerchantDTO merchantDTO) {
        return merchantService.addMerchant(merchantDTO);
    }

    @GetMapping("/{merchantId}")
    public Merchant getMerchant(@PathVariable("merchantId") Long merchantId) throws NoSuchMerchantExistsException {
        return merchantService.getMerchant(merchantId);
    }

    @PutMapping("/{merchantId}")
    public String updateMerchant(@PathVariable("merchantId") Long merchantId, @RequestBody MerchantDTO merchantDTO) throws NoSuchMerchantExistsException {
        return merchantService.updateMerchant(merchantId, merchantDTO);
    }

    @DeleteMapping("/{merchantId}")
    public String deleteMerchant(@PathVariable("merchantId") Long merchantId) throws NoSuchMerchantExistsException {
        return merchantService.deleteMerchant(merchantId);
    }

    @GetMapping("/")
    public List<Merchant> getAllMerchants() {
        return merchantService.getAllMerchants();
    }

}
