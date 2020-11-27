package com.ecommerce.service;

import com.ecommerce.data.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer registerCustomer(Customer customer);
    Customer updateCustomerDetails(Customer customer);
    Customer findByEmail(String Email);
    List<Customer> findAllCustomers();
    void deleteById(Integer id);
}
