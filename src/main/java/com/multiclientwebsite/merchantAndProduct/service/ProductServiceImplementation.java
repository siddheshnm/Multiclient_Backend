package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Product;
import com.multiclientwebsite.merchantAndProduct.entity.ProductDTO;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchMerchantExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchProductExistsException;
import com.multiclientwebsite.merchantAndProduct.repository.MerchantRepository;
import com.multiclientwebsite.merchantAndProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Product addProduct(ProductDTO productDTO) throws NoSuchMerchantExistsException {
        Product product = new Product(
                productDTO.getProductName(),
                productDTO.getProductPrice(),
                productDTO.getProductRating()
        );
        return productRepository.save(product);
    }

    @Override
    public Product getProductWithMerchant(Long productId) throws NoSuchProductExistsException {
        Optional<Product> foundProduct = productRepository.findById(productId);
        if (foundProduct.isPresent())
            return foundProduct.get();
        else
            throw new NoSuchProductExistsException("Product with id " + productId + " does not exist.");
    }

    @Override
    public String updateProduct(Long productId, ProductDTO productDTO) throws NoSuchProductExistsException {
        Optional<Product> foundProduct = productRepository.findById(productId);
        try {
            if (foundProduct.isPresent()) {
                foundProduct.get().setProductName(productDTO.getProductName());
                foundProduct.get().setProductPrice(productDTO.getProductPrice());
                foundProduct.get().setProductRating(productDTO.getProductRating());
                productRepository.save(foundProduct.get());
            } else
                throw new NoSuchProductExistsException("Product with id " + productId + " not found.");
        } catch (NoSuchProductExistsException e) {
            return e.getMessage();
        }
        return "Product with id " + productId + " has been updated.";
    }

    @Override
    public String deleteProduct(Long productId) throws NoSuchProductExistsException {
        Optional<Product> foundProduct = productRepository.findById(productId);
        try {
            if (foundProduct.isPresent()) {
                this.productRepository.delete(foundProduct.get());
            } else {
                throw new NoSuchProductExistsException("Product with id " + productId + " not found");
            }
        } catch (NoSuchProductExistsException e) {
            return e.getMessage();
        }
        return "Product with id " + productId + " has been deleted";
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
