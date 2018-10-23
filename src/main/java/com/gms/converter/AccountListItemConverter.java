package com.gms.converter;

import com.gms.domain.Account;
import com.gms.domain.Address;
import com.gms.dto.AccountListItemDto;
import com.gms.enums.State;
import com.gms.service.Utils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountListItemConverter implements DtoConverter<Account, AccountListItemDto> {
    @Override
    public AccountListItemDto convertToDto(Account account) {
        if (Utils.isEmptyObject(account)) {
            return null;
        } else {
            List<Address> addressList = account.getAddresses();
            State state = null;
            String city = null;
            if (!Utils.isEmptyList(addressList)) {
                Optional<Address> firstAddress = addressList.stream().findFirst();
                if (firstAddress.isPresent()) {
                    state = firstAddress.get().getState();
                    city = firstAddress.get().getCity();
                }
            }

            return AccountListItemDto.Builder.accountListItemDto()
                    .withAccountId(account.getAccountId())
                    .withName(account.getName())
                    .withDob(account.getDob())
                    .withFathersName(account.getFathersName())
                    .withMothersName(account.getMothersName())
                    .withMobile1(account.getMobile1())
                    .withEmail1(account.getEmail1())
                    .withHeight(account.getHeight())
                    .withWeight(account.getWeight())
                    .withQualification(account.getQualification())
                    .withIncome(account.getIncome())
                    .withState(state)
                    .withCity(city)
                    .build();
        }
    }


    @Override
    public Account convertFromDto(AccountListItemDto accountListItemDto) {
        //not required yet
        return null;
    }
}
