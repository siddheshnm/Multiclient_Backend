package com.multiclientwebsite.merchantAndProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    private Double sumTotal;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Payment payment;

    @OneToMany
    @JoinColumn(name = "cart_item_cart_item_id")
    private List<CartItem> cartItem;

    public Cart(Double sumTotal) {
        this.sumTotal = sumTotal;
    }
}
