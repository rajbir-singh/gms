package com.gms.converter;

import com.gms.domain.Account;
import com.gms.domain.Address;
import com.gms.dto.AddressDetailDto;
import com.gms.exception.ResourceNotFoundException;
import com.gms.service.AccountService;
import com.gms.service.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AddressDetailDtoConverter implements DtoConverter<Address, AddressDetailDto> {

    @Autowired
    private AccountService accountService;

    @Override
    public AddressDetailDto convertToDto(Address address) {
        if (Utils.isEmptyObject(address)) {
            return null;
        }
        Long accountId = null;
        Account account = address.getAccount();
        if (!Utils.isEmptyObject(account)) {
            accountId = account.getAccountId();
        }
        return AddressDetailDto.Builder.addressDetailDto()
                .withAddressId(address.getAddressId())
                .withAddressLine1(address.getAddressLine1())
                .withAddressLine2(address.getAddressLine2())
                .withAddressLine3(address.getAddressLine3())
                .withAddressLine4(address.getAddressLine4())
                .withCity(address.getCity())
                .withState(address.getState())
                .withPincode(address.getPincode())
                .withCountry(address.getCountry())
                .withAddressType(address.getAddressType())
                .withAccountId(accountId)
                .build();
    }

    @Override
    public Address convertFromDto(AddressDetailDto addressDetailDto) {
        if (Utils.isEmptyObject(addressDetailDto)) {
            return null;
        } else {
            Account account = null;
            if (!Utils.isLongNullOrEmpty(addressDetailDto.getAccountId())) {
                account = accountService.findByAccountId(addressDetailDto.getAccountId());
            }
            return Address.Builder.address()
                    .withAddressId(addressDetailDto.getAddressId())//TODO: make sure DB is generating id correctly
                    .withAddressLine1(addressDetailDto.getAddressLine1())
                    .withAddressLine2(addressDetailDto.getAddressLine2())
                    .withAddressLine3(addressDetailDto.getAddressLine3())
                    .withAddressLine4(addressDetailDto.getAddressLine4())
                    .withCity(addressDetailDto.getCity())
                    .withState(addressDetailDto.getState())
                    .withPincode(addressDetailDto.getPincode())
                    .withCountry(addressDetailDto.getCountry())
                    .withAddressType(addressDetailDto.getAddressType())
                    .withAccount(account)
                    .build();
        }
    }

    public List<Address> convertFromDtos(List<AddressDetailDto> addressDetailDtos) {
        if (Utils.isEmptyList(addressDetailDtos)) {
            return Collections.emptyList();
        }
        List<Address> addresses = new ArrayList<>();
        for (AddressDetailDto addressDetailDto : addressDetailDtos) {
            addresses.add(convertFromDto(addressDetailDto));
        }
        return addresses;
    }

    public List<AddressDetailDto> convertToDtos(List<Address> addresses) {
        if (Utils.isEmptyList(addresses)) {
            return Collections.emptyList();
        }
        List<AddressDetailDto> addressDetailDtos = new ArrayList<>();
        for (Address address : addresses) {
            addressDetailDtos.add(convertToDto(address));
        }
        return addressDetailDtos;
    }
}
