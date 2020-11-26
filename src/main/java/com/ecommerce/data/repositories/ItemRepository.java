package com.ecommerce.data.repositories;

import com.ecommerce.data.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<CartItem,Integer> {
}
