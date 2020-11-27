package com.ecommerce.data.repositories;

import com.ecommerce.data.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderModelRepository extends JpaRepository<OrderModel, Integer> {

}
