package com.gms.converter;

import com.gms.domain.Account;
import com.gms.dto.AccountListItemDto;

public class AccountListItemConverter implements DtoConverter<Account, AccountListItemDto> {
    @Override
    public AccountListItemDto convertToDto(Account account) {
        return null;
    }

    @Override
    public Account convertFromDto(AccountListItemDto accountListItemDto) {
        return null;
    }
}
