package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Customer;
import com.multiclientwebsite.merchantAndProduct.entity.CustomerDTO;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCustomerExistsException;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerDTO customerDTO);

    Customer getCustomer(Long customerId) throws NoSuchCustomerExistsException;

    String updateCustomer(Long customerId, CustomerDTO customerDTO) throws NoSuchCustomerExistsException;

    String deleteCustomer(Long customerId) throws NoSuchCustomerExistsException;

    List<Customer> getAllCustomer();
}
