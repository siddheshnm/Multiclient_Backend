package com.multiclientwebsite.merchantAndProduct.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long merchantId;

    @NotNull
    private String merchantName;

    @JsonManagedReference
    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> product;

    public Merchant(String merchantName) {
        this.merchantName = merchantName;
    }

}
