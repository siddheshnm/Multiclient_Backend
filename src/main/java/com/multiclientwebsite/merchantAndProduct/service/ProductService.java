package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Product;
import com.multiclientwebsite.merchantAndProduct.entity.ProductDTO;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchMerchantExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchProductExistsException;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductDTO productDTO) throws NoSuchMerchantExistsException;

    Product getProductWithMerchant(Long productId) throws NoSuchProductExistsException;

    String updateProduct(Long productId, ProductDTO productDTO) throws NoSuchProductExistsException;

    String deleteProduct(Long productId) throws NoSuchProductExistsException;

    List<Product> getAllProducts();
}
