package com.multiclientwebsite.merchantAndProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private String productName;

    private Double productPrice;

    private Integer productRating;

    private Long merchantId;

    public ProductDTO(String productName, Double productPrice, Integer productRating) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRating = productRating;
    }
}
