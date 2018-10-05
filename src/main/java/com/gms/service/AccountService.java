package com.gms.service;

import com.gms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserDtoConverter userDtoConverter;

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        if (Utils.isEmptyObject(users) || users.isEmpty()) {
            return Collections.emptyList();
        }
        return getUserDtosFromUsersList(users);
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public User updateUser(UserDto userDto) {
        if (Utils.isEmptyObject(userDto) || Utils.isEmptyObject(userDto.getUserId())) {
            return null;
        }
        return userRepository.save(userDtoConverter.convertFromDto(userDto));
    }

    public User createUser(User user) {
        if (Utils.isEmptyObject(user)) {
            return null;
        }
        return userRepository.save(user);
    }

    public List<User> searchByNameOrMobileOrEmail(String query) {
        return userRepository.findByNameContainingOrMobileContainingOrEmailContaining(query, query, query);
    }

    public List<UserDto> getUserDtosFromUsersList(List<User> users) {
        if (users == null || users.isEmpty()) {
            return Collections.emptyList();
        }
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> userDtos.add(userDtoConverter.convertToDto(user)));
        return userDtos;
    }
}
