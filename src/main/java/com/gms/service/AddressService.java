package com.gms.service;

import com.gms.domain.Address;
import com.gms.exception.ResourceNotFoundException;
import com.gms.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.gms.service.Utils;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        List<Address> addressList = new ArrayList<>();
        Iterable<Address> addresses = addressRepository.findAll();
        if (addresses.iterator().hasNext()) {
            addresses.forEach(address -> addressList.add(address));
        }
        return addressList;
    }

    @Override
    public Address findByAddressId(Long addressId) throws ResourceNotFoundException {
        if (!addressRepository.existsById(addressId)) {
            throw new ResourceNotFoundException("AddressId: " + addressId + " not found!");
        }
        return addressRepository.findByAddressId(addressId);
    }

    @Override
    public Address saveAddress(Address address) {
        if (Utils.isEmptyObject(address)) {
            throw new IllegalArgumentException("Null Address found!");
        } else return addressRepository.save(address);
    }

}
