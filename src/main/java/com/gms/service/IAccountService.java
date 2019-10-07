package com.gms.service;

import com.gms.domain.Account;
import com.gms.domain.Address;
import com.gms.dto.AccountDetailDto;
import com.gms.dto.AccountListItemDto;
import com.gms.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface IAccountService {
//    @Transactional
    List<AccountListItemDto> findAll();
    Account findByAccountId(Long accountId);
    Account saveAccount(Account account);
    AccountDetailDto findOrCreateAccountForGoogleUser(String idTokenString) throws GeneralSecurityException, IOException;
    Account findByEmail1OrEmail2(String email);
    Page<Account> findAll(Specification<Account> specification, Pageable pageable);
}
