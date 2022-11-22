package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Cart;
import com.multiclientwebsite.merchantAndProduct.entity.CartItem;
import com.multiclientwebsite.merchantAndProduct.entity.Product;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCartExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCustomerExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchProductExistsException;
import com.multiclientwebsite.merchantAndProduct.repository.CartRepository;
import com.multiclientwebsite.merchantAndProduct.repository.CustomerRepository;
import com.multiclientwebsite.merchantAndProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Cart addProductToCart(Long cartId, Long productId) throws NoSuchProductExistsException, NoSuchCustomerExistsException {
        return null;
    }

    @Override
    public String removeProductFromCart(Long cartId, Long productId) throws NoSuchProductExistsException {
        return null;
    }

    @Override
    public Cart showAllProductsInCart(Long cartId) throws NoSuchCartExistsException {
        return null;
    }

    @Override
    public String clearCart(Long cartId) {
        return null;
    }

    @Override
    public Cart getCart(Long customerId) {
        return null;
    }
//
//    @Override
//    public Cart addProductToCart(Long customerId, Long productId) throws NoSuchProductExistsException, NoSuchCustomerExistsException {
//        Cart cart;
//        try {
//            cart = cartRepository.findById((customerRepository.findById(customerId)).get().getCart().getCartId()).get();
//        } catch (Exception e) {
//            throw new NoSuchCustomerExistsException("Cart id does not exists");
//        }
//        Product product = productRepository.findById(productId).get();
//        List<CartItem> cartItemList = cart.getCartItem();
//        try {
//            for (CartItem cI : cartItemList) {
//                if (cI.getItemName().equals(product.getProductName())) {
//                    cI.setItemQuantity(cI.getItemQuantity() + 1);
//                    cart.setCartItem(cartItemList);
//                    cart.setSumTotal(cart.getSumTotal() + cI.getItemPrice());
//                    return cartRepository.save(cart);
//                }
//            }
//            CartItem cartItem = new CartItem();
//            cartItem.setItemName(product.getProductName());
//            cartItem.setItemPrice(product.getProductPrice());
//            cartItem.setItemRating(product.getProductRating());
//            cartItem.setItemQuantity(1);
//            cartItem.setCart(cart);
//            cartItem.add(cartItem);
//            cart.setCartItem(cartItemList);
//            cart.setSumTotal(cart.getSumTotal() + cartItem.getItemPrice());
//            return cartRepository.save(cart);
//        } catch (Exception e) {
//            throw new NoSuchProductExistsException("Enter correct cart item data");
//        }
//
//    }
//
//    @Override
//    public String removeProductFromCart(Long cartId, Long productId) throws NoSuchProductExistsException {
//        Optional<Cart> foundCart = cartRepository.findById(cartId);
//        return null;
//    }
//
//    @Override
//    public Cart showAllProductsInCart(Long cartId) throws NoSuchCartExistsException {
//        Optional<Cart> foundCart = cartRepository.findById(cartId);
//        if (foundCart.isPresent()) {
//            return foundCart.get();
//        } else throw new NoSuchCartExistsException("Cart with id " + cartId + " not found.");
//    }
//
//    @Override
//    public String clearCart(Long cartId) {
//        Optional<Cart> foundCart = cartRepository.findById(cartId);
//        List<CartItem> emptyList = new ArrayList<CartItem>();
//        foundCart.get().setCartItem(emptyList);
//        return "The cart with id " + cartId + " has been cleared.";
//    }
//
//    @Override
//    public Cart getCart(Long customerId) {
//        Cart foundCart = customerRepository.findById(customerId).get().getCart();
//        return foundCart;
//    }
}
