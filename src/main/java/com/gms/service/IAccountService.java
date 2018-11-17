package com.gms.service;

import com.gms.domain.Account;
import com.gms.domain.Address;
import com.gms.dto.AccountListItemDto;
import com.gms.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.transaction.Transactional;
import java.util.List;

public interface IAccountService {
//    @Transactional
    List<AccountListItemDto> findAll();
    Account findByAccountId(Long accountId);
    Account saveAccount(Account account);
    Page<Account> findAll(Specification<Account> specification, Pageable pageable);
}
