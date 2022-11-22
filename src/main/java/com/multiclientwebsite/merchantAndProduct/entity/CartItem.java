package com.multiclientwebsite.merchantAndProduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private String itemName;
    private Double itemPrice;
    private Integer itemRating;
    private Integer itemQuantity;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    public void add(CartItem cartItem) {
    }
}
