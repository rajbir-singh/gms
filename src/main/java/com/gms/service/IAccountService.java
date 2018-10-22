package com.gms.service;

import com.gms.domain.Account;
import com.gms.domain.Address;
import com.gms.dto.AccountListItemDto;
import com.gms.exception.ResourceNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

public interface IAccountService {
//    @Transactional
    List<AccountListItemDto> findAll();
    Account findByAccountId(Long accountId);
    Account saveAccount(Account account);
}
