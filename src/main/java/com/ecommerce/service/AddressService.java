package com.ecommerce.service;

import com.ecommerce.data.models.Address;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);
    Address updateAddress(Address address);
    Address findAddressById(Integer Id);
    List<Address> findAllAddresses();
    List<Address> findAllAddressesForACustomer(Integer customerId);
    void deleteById(Integer id);
}
