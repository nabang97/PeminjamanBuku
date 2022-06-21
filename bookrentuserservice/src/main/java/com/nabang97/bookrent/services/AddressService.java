package com.nabang97.bookrent.services;

import com.nabang97.bookrent.model.Address;
import com.nabang97.bookrent.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 20:46
 */
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }

    public Address findOneAddress(String id){
        Optional<Address> address = addressRepository.findById(id);
        if (!address.isPresent()){
            return null;
        }
        return address.get();
    }
}
