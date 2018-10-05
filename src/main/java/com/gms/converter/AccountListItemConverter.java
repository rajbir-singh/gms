package com.gms.converter;

import com.gms.domain.Account;
import com.gms.dto.AccountListItemDto;
import com.gms.service.Utils;
import org.springframework.stereotype.Component;

@Component
public class AccountListItemConverter implements DtoConverter<Account, AccountListItemDto> {
    @Override
    public AccountListItemDto convertToDto(Account account) {
        if (Utils.isEmptyObject(account)) {
            return null;
        } else
            return AccountListItemDto.Builder.accountListItemDto()
                    .withAccountId(account.getAccountId())
                    .withName(account.getName())
                    .withDob(account.getDob())
                    .withFathersName(account.getFathersName())
                    .withMothersName(account.getMothersName())
                    .withMobile1(account.getMobile1())
                    .withEmail1(account.getEmail1())
                    .withHeight(account.getWeight())
                    .withWeight(account.getWeight())
                    .withQualification(account.getQualification())
                    .withIncome(account.getIncome())
                    .build();
    }

    @Override
    public Account convertFromDto(AccountListItemDto accountListItemDto) {
        return null;
    }
}
