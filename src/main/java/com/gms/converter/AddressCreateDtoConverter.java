package com.gms.converter;

import com.gms.domain.Address;
import com.gms.dto.AddressCreateDto;
import com.gms.service.Utils;
import org.springframework.stereotype.Component;

@Component
public class AddressCreateDtoConverter implements DtoConverter<Address, AddressCreateDto> {
    @Override
    public AddressCreateDto convertToDto(Address address) {
        return null;
    }

    @Override
    public Address convertFromDto(AddressCreateDto addressCreateDto) {
        if (Utils.isEmptyObject(addressCreateDto)) {
            return null;
        } else return Address.Builder.address()
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
                .build();
    }
}
