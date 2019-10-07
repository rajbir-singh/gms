package com.gms.callicoder.controller;

import com.gms.callicoder.security.CurrentUser;
import com.gms.domain.Account;
import com.gms.exception.ResourceNotFoundException;
import com.gms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public Account getCurrentUser(@CurrentUser Account userPrincipal) {
        return accountRepository.findById(userPrincipal.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("User id: " +  userPrincipal.getAccountId()));
    }
}
