package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Cart;
import com.multiclientwebsite.merchantAndProduct.entity.Customer;
import com.multiclientwebsite.merchantAndProduct.entity.CustomerDTO;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCustomerExistsException;
import com.multiclientwebsite.merchantAndProduct.repository.CartRepository;
import com.multiclientwebsite.merchantAndProduct.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {
    public static void main(String args[]) {

    }

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CartRepository cartRepository;


    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerPhoneNumber()
        );
        customerRepository.save(customer);
        Cart cart = new Cart(0.00);
        cartRepository.save(cart);
        return "cartId = " + cart.getCartId() + " and customerId = " + customer.getCustomerId();
    }


    @Override
    public Customer getCustomer(Long customerId) throws NoSuchCustomerExistsException {
        Optional<Customer> foundCustomer = customerRepository.findById(customerId);
        if (foundCustomer.isPresent())
            return foundCustomer.get();
        else
            throw new NoSuchCustomerExistsException("Merchant with id " + customerId + " does not exist.");
    }

    @Override
    public String updateCustomer(Long customerId, CustomerDTO customerDTO) throws NoSuchCustomerExistsException {
        try {
            Optional<Customer> foundCustomer = customerRepository.findById(customerId);
            if (foundCustomer.isPresent()) {
                foundCustomer.get().setCustomerName(customerDTO.getCustomerName());
                foundCustomer.get().setCustomerAddress(customerDTO.getCustomerAddress());
                foundCustomer.get().setCustomerPhoneNumber(customerDTO.getCustomerPhoneNumber());
                customerRepository.save(foundCustomer.get());
            } else
                throw new NoSuchCustomerExistsException("Customer with id " + customerId + " does not exist.");
        } catch (NoSuchCustomerExistsException e) {
            return e.getMessage();
        }
        return "Customer with id " + customerId + " has been updated.";
    }

    @Override
    public String deleteCustomer(Long customerId) throws NoSuchCustomerExistsException {
        Optional<Customer> foundCustomer = customerRepository.findById(customerId);
        try {
            if (foundCustomer.isPresent()) {
                this.customerRepository.delete(foundCustomer.get());
            } else {
                throw new NoSuchCustomerExistsException("Customer with id " + customerId + " not found");
            }
        } catch (NoSuchCustomerExistsException e) {
            return e.getMessage();
        }
        return "Customer with id " + customerId + " has been deleted";
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
//class trial{
//
//    public String addCustomer(Customer customer) {
//        Cart cart = new Cart(0.00);
//        cartRepository.save(cart);
//
//        return customerRepository.save(customer);
//    }
//}