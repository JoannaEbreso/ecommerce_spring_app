package com.ecommerce.data.repositories;

import com.ecommerce.data.models.CartItem;
import com.ecommerce.data.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class CartItemRepositoryTest {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;

    CartItem cartItem;

    @BeforeEach
    void setUp() {
        cartItem = new CartItem();
    }

    @Test
    void whenCartItemIsSaved_returnCartItemId(){
       Product product = productRepository.findById(3).orElse(null);
       cartItem.setProduct(product);
       cartItem.setQuantity(10);
       cartItem.setPrice(product,cartItem.getQuantity());

       assertThat(cartItem.getId()).isNull();
       cartItemRepository.save(cartItem);

       assertThat(cartItem.getId()).isNotNull();
    }

    @Test
    void updateCartItemTest(){
        cartItem = cartItemRepository.findById(1).orElse(null);
        cartItem.setPrice(35000.00);
        cartItemRepository.save(cartItem);

        assertThat(cartItem.getPrice()).isEqualTo(35000.00);
    }

    @Test
    void deleteCartItemTest(){
        cartItemRepository.deleteById(2);

        assertThat(cartItemRepository.existsById(2)).isFalse();
    }
}