package com.gms.converter;

import com.gms.domain.Account;
import com.gms.dto.AccountCreateDto;
import com.gms.service.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCreateDtoConverter implements DtoConverter<Account, AccountCreateDto> {

    @Autowired
    private AddressCreateDtoConverter addressCreateDtoConverter;

    @Override
    public AccountCreateDto convertToDto(Account account) {
        return null;
    }

    @Override
    public Account convertFromDto(AccountCreateDto accountCreateDto) {
        if (Utils.isEmptyObject(accountCreateDto)) {
            return null;
        }
        return Account.Builder.account()
                .withName(accountCreateDto.getName())
                .withDob(accountCreateDto.getDob())
                .withFathersName(accountCreateDto.getFathersName())
                .withMothersName(accountCreateDto.getMothersName())
                .withMobile1(accountCreateDto.getMobile1())
                .withMobile2(accountCreateDto.getMobile2())
                .withEmail1(accountCreateDto.getEmail1())
                .withEmail2(accountCreateDto.getEmail2())
                .withHeight(accountCreateDto.getHeight())
                .withWeight(accountCreateDto.getWeight())
                .withQualification(accountCreateDto.getQualification())
                .withOccupation(accountCreateDto.getOccupation())
                .withIncome(accountCreateDto.getIncome())
                .withResidenceAddress(addressCreateDtoConverter.convertFromDto(accountCreateDto.getResidenceAddress()))
                .withCorrespondenceAddress(addressCreateDtoConverter.convertFromDto(accountCreateDto.getCorrespondenceAddress()))
                .withOwnHouse(accountCreateDto.isOwnHouse())
                .withOnlyChild(accountCreateDto.isOnlyChild())
                .withDetails(accountCreateDto.getDetails())
                .build();
    }
}
