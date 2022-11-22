package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Cart;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCartExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCustomerExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchProductExistsException;

public interface CartService {

    public Cart addProductToCart(Long cartId, Long productId) throws NoSuchProductExistsException, NoSuchCustomerExistsException;

    public String removeProductFromCart(Long cartId, Long productId) throws NoSuchProductExistsException;

    public Cart showAllProductsInCart(Long cartId) throws NoSuchCartExistsException;

    public String clearCart(Long cartId);

    Cart getCart(Long customerId);
}

