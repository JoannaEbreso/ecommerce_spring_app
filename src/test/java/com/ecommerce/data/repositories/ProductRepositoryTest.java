package com.ecommerce.data.repositories;

import com.ecommerce.data.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    @Rollback(value = false)
    void whenProductIsSaved_ReturnProductId(){
        product.setName("round neck blouse");
        product.setPrice(250.00);
        product.setProductDescription("A blouse with a round neck, perfect for a casual occasion");

        assertThat(product.getId()).isNull();

        log.info("Product object before saving --> {}", product);

        productRepository.save(product);

        log.info("Product object after saving --> {}", product);

        assertThat(product.getId()).isNotNull();
    }

    @Test
    void updateProductTest(){
        product = productRepository.findById(1).orElse(null);
        assertThat(product.getName()).isEqualTo("round neck blouse");

        product.setName("V neck blouse");
        assertThat(product.getName()).isEqualTo("V neck blouse");
    }

    @Test
    void deleteProductTest(){
        product = productRepository.findById(1).orElse(null);
        productRepository.deleteById(1);

        assertThat(productRepository.existsById(1)).isFalse();

    }
}