package com.gms.service;

import com.gms.domain.Account;
import com.gms.domain.Address;
import com.gms.dto.AccountListItemDto;
import com.gms.exception.ResourceNotFoundException;

import java.util.List;

public interface IAccountService {
    List<AccountListItemDto> findAll();
    Account findByAccountId(Long accountId) throws ResourceNotFoundException;
    Account saveAccount(Account account);
}
