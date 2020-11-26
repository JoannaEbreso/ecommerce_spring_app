package com.ecommerce.data.repositories;

import com.ecommerce.data.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderModelInterface extends JpaRepository<OrderModel, Integer> {

}
