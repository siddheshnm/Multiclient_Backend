package com.multiclientwebsite.merchantAndProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String customerName;
    private String customerAddress;
    private Long customerPhoneNumber;

    private String customerEmail;

    @OneToOne
    private Payment payment;

    @OneToOne
    private Cart cart;

    public CustomerDTO(String customerName, String customerAddress, Long customerPhoneNumber) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
