package com.multiclientwebsite.merchantAndProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private Long customerPhoneNumber;

    private String customerEmail;

    @OneToOne
    private Payment payment;

    @OneToOne
    private Cart cart;

    public Customer(String customerName, String customerAddress, Long customerPhoneNumber) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
