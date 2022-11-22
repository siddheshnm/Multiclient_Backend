package com.multiclientwebsite.merchantAndProduct;

import com.multiclientwebsite.merchantAndProduct.entity.Merchant;
import com.multiclientwebsite.merchantAndProduct.entity.Product;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchMerchantExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchProductExistsException;
import com.multiclientwebsite.merchantAndProduct.repository.MerchantRepository;
import com.multiclientwebsite.merchantAndProduct.repository.ProductRepository;
import com.multiclientwebsite.merchantAndProduct.service.MerchantService;
import com.multiclientwebsite.merchantAndProduct.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MerchantAndProductApplicationTests {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private MerchantRepository merchantRepository;
	public
	Product product = new Product("Dummy product 1", 500.0, 9);

	Merchant merchant = new Merchant("Dummy Merchant");

	@Test
	void contextLoads() {
	}


	@Test
	void testAddMerchant() throws NoSuchMerchantExistsException{
		merchantRepository.save(merchant);
		Merchant expected = merchantRepository.save(merchant);
		Merchant actual = merchantService.getMerchant(expected.getMerchantId());

		// Asserts that the supplied condition is trues
		assertEquals(expected.getMerchantName(), actual.getMerchantName());
	}

	@Test
	void testAddProduct() throws NoSuchProductExistsException {
		productRepository.save(product);
		Product expected = productRepository.save(product);
		Product actual = productService.getProductWithMerchant(expected.getProductId());

		// Asserts that the supplied condition is trues
		assertEquals(expected.getProductName(), actual.getProductName());
		assertEquals(expected.getProductPrice(), actual.getProductPrice());
		assertEquals(expected.getProductRating(), actual.getProductRating());
	}

	@Test
	void testDeleteMerchant() throws NoSuchMerchantExistsException{
		merchantRepository.save(merchant);
		String expected = merchantService.deleteMerchant(merchant.getMerchantId());

		// Asserts that the supplied condition is true
		assertEquals("Merchant with id " + merchant.getMerchantId() + " has been deleted", expected);
	}

	@Test
	void testDeleteProduct() throws NoSuchProductExistsException{

		productRepository.save(product);
		String expected = productService.deleteProduct(product.getProductId());

		// Asserts that the supplied condition is true
		assertEquals("Product with id " + product.getProductId() + " has been deleted", expected);

	}

	@Test
	void testGetMerchant() throws NoSuchMerchantExistsException{
		Merchant actual = merchantRepository.save(merchant);
		Merchant expected = merchantService.getMerchant(merchant.getMerchantId());
		assertEquals(expected.getMerchantName(), actual.getMerchantName());
	}

	@Test
	void testGetProductWithMerchant() throws NoSuchProductExistsException{
		Product actual = productRepository.save(product);
		Product expected = productService.getProductWithMerchant(product.getProductId());
		assertEquals(expected.getProductName(), actual.getProductName());
		assertEquals(expected.getProductPrice(), actual.getProductPrice());
		assertEquals(expected.getProductRating(), actual.getProductRating());
	}

	@Test
	void testGetAllMerchants() {

		merchantRepository.save(merchant);
		List<Merchant> expected = merchantRepository.findAll();
		List<Merchant> actual = merchantService.getAllMerchants();

		assertEquals(expected.size(), actual.size());
		assertEquals(expected.get(0).getMerchantName(), actual.get(0).getMerchantName());
	}

	@Test
	void testGetAllProducts() {
		productRepository.save(product);
		List<Product> expected = productRepository.findAll();
		List<Product> actual = productService.getAllProducts();

		assertEquals(expected.size(), actual.size());
		assertEquals(expected.get(0).getProductName(), actual.get(0).getProductName());
		assertEquals(expected.get(0).getProductPrice(), actual.get(0).getProductPrice());
		assertEquals(expected.get(0).getProductRating(), actual.get(0).getProductRating());
	}


}
