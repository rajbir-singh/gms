package com.gms.service;

import com.gms.domain.Address;
import com.gms.exception.ResourceNotFoundException;

import java.util.List;

public interface IAddressService {
    List<Address> findAll();
    Address findByAddressId(Long addressId) throws ResourceNotFoundException;
    Address saveAddress(Address address);
}
