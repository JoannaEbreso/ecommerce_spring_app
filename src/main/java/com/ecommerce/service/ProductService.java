package com.ecommerce.service;

import com.ecommerce.data.models.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product updateProductDetails(Product product);
    List<Product> findAllProducts();
    void deleteById(Integer id);
}
