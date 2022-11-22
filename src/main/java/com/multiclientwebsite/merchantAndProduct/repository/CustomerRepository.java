package com.multiclientwebsite.merchantAndProduct.repository;

import com.multiclientwebsite.merchantAndProduct.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}