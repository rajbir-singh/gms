package com.gms.service;

import com.gms.converter.AccountCreateDtoConverter;
import com.gms.converter.AccountListItemConverter;
import com.gms.domain.Account;
import com.gms.dto.AccountCreateDto;
import com.gms.dto.AccountListItemDto;
import com.gms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountListItemConverter accountListItemConverter;

    @Autowired
    private AccountCreateDtoConverter accountCreateDtoConverter;

    public List<AccountListItemDto> findAll() {
        Iterable<Account> accounts = accountRepository.findAll();
//        if (Utils.isEmptyList(accounts)) {
//            return Collections.emptyList();
//        }
        return getAccountListItemDtosFromAccountsList(accounts);
    }

    public Account findByUserId(String accountId) {
        return accountRepository.findByAccountId(accountId);
    }

//    public Account updateUser(UserDto userDto) {
//        if (Utils.isEmptyObject(userDto) || Utils.isEmptyObject(userDto.getUserId())) {
//            return null;
//        }
//        return userRepository.save(userDtoConverter.convertFromDto(userDto));
//    }

//    public Account createUser(AccountCreateDto accountCreateDto) {
//        if (Utils.isEmptyObject(accountCreateDto)) {
//            return null;
//        }
//        Account account = accountCreateDtoConverter.convert(accountCreateDto);
//        return accountRepository.save(account);
//    }

//    public List<User> searchByNameOrMobileOrEmail(String query) {
//        return userRepository.findByNameContainingOrMobileContainingOrEmailContaining(query, query, query);
//    }

    public List<AccountListItemDto> getAccountListItemDtosFromAccountsList(Iterable<Account> accounts) {
        //TODO: add empty list check for iterable
//        if (Utils.isNonEmptyList(accounts)) {
//            return Collections.emptyList();
//        }
        List<AccountListItemDto> accountListItemDtos = new ArrayList<>();
        accounts.forEach(user -> accountListItemDtos.add(accountListItemConverter.convertToDto(user)));
        return accountListItemDtos;
    }
}
