package com.ecommerce.SkyCart.utils;

import com.ecommerce.SkyCart.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StartPersistence {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager =  entityManagerFactory.createEntityManager();

        Product product = entityManager.find(Product.class, 1);
        System.out.println(product);

        entityManager.close();
        entityManagerFactory.close();
    }
}
