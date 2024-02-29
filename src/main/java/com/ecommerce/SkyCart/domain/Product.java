package com.ecommerce.SkyCart.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
@Table(name = "produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduct;
    private String name;
    private String description;
    private BigDecimal price;
    private Date creationDate;


}
