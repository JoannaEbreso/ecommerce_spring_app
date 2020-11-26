package com.ecommerce.data.repositories;

import com.ecommerce.data.models.Address;
import com.ecommerce.data.models.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
//@Sql(scripts = {"classpath:db/insert.sql"})
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    Customer customer1;

    @BeforeEach
    void setUp() {
        customer1 = new Customer();
    }

    @Test
    void whenCustomerIsSaved_returnCustomerId(){
        customer1.setFirstName("Tricia");
        customer1.setLastName("Davis");
        customer1.setEmail("tritri@gmail.com");
        customer1.setPhoneNumber("23456884873");
        customer1.setPassword("jojo2020");


        log.info("Customer object before saving --> {}", customer1);

        customerRepository.save(customer1);
        log.info("Customer object after saving --> {}", customer1);

    }

    @Test
    void mapAddressToCustomer(){
        Address address = new Address();

        address.setState("Delta");
        address.setCity("oyigbo");
        address.setCountry("Nigeria");
        address.setAddressLineOne("10,ebenezer road");
        address.setZipcode("75473");

        customer1.setFirstName("Drey");
        customer1.setLastName("Davis");
        customer1.setEmail("dreya@gmail.com");
        customer1.setPhoneNumber("jriuwr");
        customer1.setPassword("jojo2120");
        customer1.setAddress(address);

        log.info("Customer object before saving --> {}",customer1);
        customerRepository.save(customer1);
        log.info("Customer object after saving --> {}",customer1);

        assertThat(customer1.getAddressList()).isNotNull();
    }

    @Test
    void testThatOneCustomerCanHaveMultipleAddresses(){
        customer1 = customerRepository.findById(4).orElse(null);
        Address address = new Address();
        address.setState("Yobe");
        address.setCity("Lome");
        address.setCountry("Togo");
        address.setAddressLineOne("2,sss street");
        address.setZipcode("345281");

        Address address1 = new Address();
        address1.setState("Edo");
        address1.setCity("siri");
        address1.setCountry("Nigeria");
        address1.setAddressLineOne("2,sbbb street");
        address1.setZipcode("12282");

        addressRepository.save(address);
        addressRepository.save(address1);

        customer1.setAddress(address);
        customer1.setAddress(address1);
        log.info("Customer address --> {}", customer1.getAddressList());
        customerRepository.save(customer1);

        Set<Address> addressList = customer1.getAddressList();
        Integer numberOfAddress = addressList.size();

        assertThat(numberOfAddress>1).isTrue();

    }

    @Test
    void testThatWeCanFetchAllCustomerAddress(){
        customer1 = customerRepository.findById(4).orElse(null);

        Set<Address> addressList = customer1.getAddressList();
        log.info("the list of addresses for customer1 --> {}", addressList);

        assertThat(addressList.size()).isEqualTo(3);
    }

    @Test
    void testThatWeCanUpdateCustomerDetails(){
        customer1 = customerRepository.findById(3).orElse(null);
        log.info("Customer name before update --> {}",customer1.getFirstName());

        customer1.setFirstName("Lucy");
        customerRepository.save(customer1);
        log.info("Customer name after update --> {}",customer1.getFirstName());
        assertThat(customer1.getFirstName()).isEqualTo("Lucy");
    }

    @Test
    void testThatTwoCustomersCanShareOneAddress(){
        customer1 = customerRepository.findById(2).orElse(null);
        Address address = addressRepository.findById(8).orElse(null);

        customer1.setAddress(address);
        customerRepository.save(customer1);

        assertThat(customer1.getAddressList()).contains(address);
    }

}