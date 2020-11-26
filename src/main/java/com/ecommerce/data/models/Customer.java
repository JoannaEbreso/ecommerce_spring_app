package com.ecommerce.data.models;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private String email;

    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Address> addressList;

    public void setAddress(Address address){
        if(addressList == null){
            addressList = new HashSet<>();
        }
        addressList.add(address);
    }

    @Column(nullable = false)
    private String password;
}
