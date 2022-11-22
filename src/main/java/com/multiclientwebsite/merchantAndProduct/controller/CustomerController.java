package com.multiclientwebsite.merchantAndProduct.controller;

import com.multiclientwebsite.merchantAndProduct.entity.Customer;
import com.multiclientwebsite.merchantAndProduct.entity.CustomerDTO;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCustomerExistsException;
import com.multiclientwebsite.merchantAndProduct.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200")

public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public String addCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long customerId) throws NoSuchCustomerExistsException {
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public String updateCustomer(@PathVariable("customerId") Long customerId, @RequestBody CustomerDTO customerDTO) throws NoSuchCustomerExistsException {
        return customerService.updateCustomer(customerId, customerDTO);
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Long customerId) throws NoSuchCustomerExistsException {
        return customerService.deleteCustomer(customerId);
    }

    @GetMapping("/")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }
    /*
    @GetMapping("/{merchantId}")
    public Merchant getMerchant(@PathVariable ("merchantId") Long merchantId) throws NoSuchMerchantExistsException {
        return merchantService.getMerchant(merchantId);
    }
     */
}
