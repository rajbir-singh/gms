package com.gms.converter;

import com.gms.domain.Account;
import com.gms.domain.Address;
import com.gms.dto.AddressCreateDto;
import com.gms.service.AccountService;
import com.gms.service.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AddressCreateDtoConverter implements DtoConverter<Address, AddressCreateDto> {

    @Autowired
    private AccountService accountService;

    @Override
    public AddressCreateDto convertToDto(Address address) {
        return null;
    }

    @Override
    public Address convertFromDto(AddressCreateDto addressCreateDto) {
        if (Utils.isEmptyObject(addressCreateDto) || Utils.isLongNullOrEmpty(addressCreateDto.getAccountId())) {
            throw new RuntimeException("Either AddressCreateDto or AccountId to which address belongs found null!");
        } else {
            Account account = accountService.findByAccountId(addressCreateDto.getAccountId());
            return Address.Builder.address()
                    .withAddressId(null)//TODO: make sure DB is generating id correctly
                    .withAddressLine1(addressCreateDto.getAddressLine1())
                    .withAddressLine2(addressCreateDto.getAddressLine2())
                    .withAddressLine3(addressCreateDto.getAddressLine3())
                    .withAddressLine4(addressCreateDto.getAddressLine4())
                    .withCity(addressCreateDto.getCity())
                    .withState(addressCreateDto.getState())
                    .withPincode(addressCreateDto.getPincode())
                    .withCountry(addressCreateDto.getCountry())
                    .withAddressType(addressCreateDto.getAddressType())
                    .withAccount(account)
                    .build();
        }
    }


    public List<Address> convertFromDtos(List<AddressCreateDto> addressCreateDtos) {
        if (Utils.isNonEmptyList(addressCreateDtos)) {
            return Collections.emptyList();
        }
        List<Address> addresses = new ArrayList<>();
        addressCreateDtos.forEach(addressCreateDto -> addresses.add(convertFromDto(addressCreateDto)));
        return addresses;
    }
}
