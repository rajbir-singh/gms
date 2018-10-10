package com.gms.service;

import com.gms.domain.Account;
import com.gms.dto.AccountListItemDto;

import java.util.List;

public interface IAccountService {
    List<AccountListItemDto> findAll();
    Account findByAccountId(Long accountId);
}
