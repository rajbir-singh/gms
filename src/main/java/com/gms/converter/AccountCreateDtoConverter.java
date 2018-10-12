package com.gms.converter;

import com.gms.domain.Account;
import com.gms.dto.AccountCreateDto;
import com.gms.exception.ResourceNotFoundException;
import com.gms.service.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCreateDtoConverter implements DtoConverter<Account, AccountCreateDto> {

    @Autowired
    private AddressCreateDtoConverter addressCreateDtoConverter;

    @Override
    public AccountCreateDto convertToDto(Account account) {

        if (Utils.isEmptyObject(account)) {
            return null;
        }

        return null;
    }

    //TODO : test how address is saved when it comes along with an accountCreateDto (both have ID yet to be generated!)
    @Override
    public Account convertFromDto(AccountCreateDto accountCreateDto) throws ResourceNotFoundException {
        if (Utils.isEmptyObject(accountCreateDto)) {
            return null;
        }
        return Account.Builder.account()
                .withAccountId(accountCreateDto.getAccountId())
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
                .withAddresses(addressCreateDtoConverter.convertFromDtos(accountCreateDto.getAddresses()))
                .withOwnHouse(accountCreateDto.getOwnHouse())
                .withOnlyChild(accountCreateDto.getOnlyChild())
                .withDetails(accountCreateDto.getDetails())
                .build();
    }
}
