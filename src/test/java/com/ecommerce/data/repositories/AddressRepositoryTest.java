package com.ecommerce.data.repositories;

import com.ecommerce.data.models.Address;
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
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    Address address;

    @BeforeEach
    void setUp() {
        address = new Address();
    }

    @Test
    void testThatWeCanSaveAnAddress(){
        address.setState("Lagos");
        address.setCity("Yaba");
        address.setCountry("Nigeria");
        address.setAddressLineOne("7,Herbert Macauley");
        address.setZipcode("23456");

        log.info("Address object before saving --> {}", address);

        addressRepository.save(address);
        assertThat(address).isNotNull();

        log.info("Address object after saving --> {}", address);
    }

    @Test
    void testThatWeCanUpdateAddress(){
        Address anAddress = addressRepository.findById(5).orElse(null);
        anAddress.setCity("Lekki");

        addressRepository.save(anAddress);

        assertThat(anAddress.getCity()).isEqualTo("Lekki");
    }

    @Test
    void testThatWeCanDeleteAddress(){
        Address address1 = new Address();
        address1.setState("Edo");
        address1.setCity("Mushin");
        address1.setCountry("Nigeria");
        address1.setAddressLineOne("10,la la land");
        address.setZipcode("11011");

        log.info("address object before saving --> {}", address1);
        addressRepository.save(address1);

        log.info("address after saving --> {}", address1);

        assertThat(addressRepository.existsById(4)).isTrue();

        addressRepository.deleteById(4);

        assertThat(addressRepository.existsById(4)).isFalse();
    }

}