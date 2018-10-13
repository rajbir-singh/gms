package com.gms.converter;

import com.gms.domain.Account;
import com.gms.dto.AccountDetailDto;
import com.gms.exception.ResourceNotFoundException;
import com.gms.service.AccountService;
import com.gms.service.AddressService;
import com.gms.service.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailDtoConverter implements DtoConverter<Account, AccountDetailDto> {

    @Autowired
    private AddressDetailDtoConverter addressDetailDtoConverter;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AccountService accountService;

    @Override
    public AccountDetailDto convertToDto(Account account) throws ResourceNotFoundException {

        if (Utils.isEmptyObject(account)) {
            return null;
        }

        return AccountDetailDto.Builder.accountCreateDto()
                .withAccountId(account.getAccountId())
                .withName(account.getName())
                .withDob(account.getDob())
                .withFathersName(account.getFathersName())
                .withMothersName(account.getMothersName())
                .withMobile1(account.getMobile1())
                .withMobile2(account.getMobile2())
                .withEmail1(account.getEmail1())
                .withEmail2(account.getEmail2())
                .withHeight(account.getWeight())
                .withWeight(account.getWeight())
                .withQualification(account.getQualification())
                .withOccupation(account.getOccupation())
                .withIncome(account.getIncome())
                .withAddresses(addressDetailDtoConverter.convertToDtos(account.getAddresses()))
                .withOwnHouse(account.getOwnHouse())
                .withOnlyChild(account.getOnlyChild())
                .withDetails(account.getDetails())
                .build();
    }

    //TODO : test how address is saved when it comes along with an accountDetailDto (both have ID yet to be generated!)
    @Override
    public Account convertFromDto(AccountDetailDto accountDetailDto) throws ResourceNotFoundException {
        if (Utils.isEmptyObject(accountDetailDto)) {
            return null;
        }
        return Account.Builder.account()
                .withAccountId(accountDetailDto.getAccountId())
                .withName(accountDetailDto.getName())
                .withDob(accountDetailDto.getDob())
                .withFathersName(accountDetailDto.getFathersName())
                .withMothersName(accountDetailDto.getMothersName())
                .withMobile1(accountDetailDto.getMobile1())
                .withMobile2(accountDetailDto.getMobile2())
                .withEmail1(accountDetailDto.getEmail1())
                .withEmail2(accountDetailDto.getEmail2())
                .withHeight(accountDetailDto.getHeight())
                .withWeight(accountDetailDto.getWeight())
                .withQualification(accountDetailDto.getQualification())
                .withOccupation(accountDetailDto.getOccupation())
                .withIncome(accountDetailDto.getIncome())
                .withAddresses(addressDetailDtoConverter.convertFromDtos(accountDetailDto.getAddresses()))
                .withOwnHouse(accountDetailDto.getOwnHouse())
                .withOnlyChild(accountDetailDto.getOnlyChild())
                .withDetails(accountDetailDto.getDetails())
                .build();
    }
}
