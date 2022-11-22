package com.multiclientwebsite.merchantAndProduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @NotNull
    private String productName;
    @NotNull
    private Double productPrice;
    @NotNull
    private Integer productRating;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "merchantId")
    private Merchant merchant;


    public Product(String productName, Double productPrice, Integer productRating, Long merchantId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.merchant = merchant;
    }

    public Product(String productName, Double productPrice, Integer productRating) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRating = productRating;
    }

}
