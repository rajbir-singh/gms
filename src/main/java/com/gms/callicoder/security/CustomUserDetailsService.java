package com.gms.callicoder.security;

import com.gms.domain.Account;
import com.gms.exception.ResourceNotFoundException;
import com.gms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail1(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Account not found with email : " + email)
                );

        return AccountPrincipal.create(account);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Account with AccountId" + id)
        );

        return AccountPrincipal.create(account);
    }
}