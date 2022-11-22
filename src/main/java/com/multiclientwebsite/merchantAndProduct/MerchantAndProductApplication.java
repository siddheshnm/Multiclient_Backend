package com.multiclientwebsite.merchantAndProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MerchantAndProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MerchantAndProductApplication.class, args);
    }

}
