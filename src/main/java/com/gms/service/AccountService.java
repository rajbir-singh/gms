package com.gms.service;

import com.gms.converter.AccountCreateDtoConverter;
import com.gms.converter.AccountListItemConverter;
import com.gms.domain.Account;
import com.gms.domain.Address;
import com.gms.dto.AccountCreateDto;
import com.gms.dto.AccountListItemDto;
import com.gms.exception.ResourceNotFoundException;
import com.gms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountListItemConverter accountListItemConverter;

    @Autowired
    private AccountCreateDtoConverter accountCreateDtoConverter;

    @Autowired
    private AddressService addressService;


    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public boolean existsById(Long accountId) throws ResourceNotFoundException {
        if(!accountRepository.existsById(accountId)) {
            throw new ResourceNotFoundException("AccountId: " + accountId + " not found");
        }
        return true;
    }

    @Override
    public List<AccountListItemDto> findAll() {
        Iterable<Account> accounts = accountRepository.findAll();
//        if (Utils.isEmptyList(accounts)) {
//            return Collections.emptyList();
//        }
        return getAccountListItemDtosFromAccountsList(accounts);
    }

    @Override
    public Account saveAccount(Account account) {
        //TODO : throw better exception here
        if(Utils.isEmptyObject(account)) {
            throw new RuntimeException("Null AccountCreateDto found!");
        }
        return accountRepository.save(account);
    }

    public Account addAccount(AccountCreateDto accountCreateDto) throws ResourceNotFoundException {
        if(Utils.isEmptyObject(accountCreateDto)) {
            throw new RuntimeException("Null AccountCreateDto found!");
        }
        Account account = accountCreateDtoConverter.convertFromDto(accountCreateDto);
        account = this.saveAccount(account);
        List<Address> addresses = account.getAddresses();
        for(Address address: addresses) {
            address.setAccount(account);
            addressService.saveAddress(address);
        }
        return account;
    }

    public Account updateAccount(Long accountId, AccountCreateDto accountCreateDto) throws ResourceNotFoundException {
        //TODO : throw better exception here
        if(Utils.isEmptyObject(accountCreateDto)) {
            throw new RuntimeException("Null AccountCreateDto found!");
        }

        Account account = accountRepository.findByAccountId(accountId);
        accountCreateDto.setAccountId(account.getAccountId());
        account = accountCreateDtoConverter.convertFromDto(accountCreateDto);
        return accountRepository.save(account);
    }

    //TODO : trying changing Exception being thrown in existsById() to checked rather than checked (Runtime exc currently) and see if it helps in backtracking the function calls
    @Override
    public Account findByAccountId(Long accountId) throws ResourceNotFoundException {
        if(existsById(accountId)) {
            return accountRepository.findByAccountId(accountId);
        }
        return null;
    }

    public List<AccountListItemDto> getAccountListItemDtosFromAccountsList(Iterable<Account> accounts) {
        //TODO: add empty list check for iterable
//        if (Utils.isNonEmptyList(accounts)) {
//            return Collections.emptyList();
//        }
        List<AccountListItemDto> accountListItemDtos = new ArrayList<>();
        accounts.forEach(user -> accountListItemDtos.add(accountListItemConverter.convertToDto(user)));
        return accountListItemDtos;

//        @Autowired
//        private ArticleRepository articleRepository;
//        @Override
//        public Article getArticleById(long articleId) {
//            Article obj = articleRepository.findById(articleId).get();
//            return obj;
//        }
//        @Override
//        public List<Article> getAllArticles(){
//            List<Article> list = new ArrayList<>();
//            articleRepository.findAll().forEach(e -> list.add(e));
//            return list;
//        }
//        @Override
//        public synchronized boolean addArticle(Article article){
//            List<Article> list = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory());
//            if (list.size() > 0) {
//                return false;
//            } else {
//                articleRepository.save(article);
//                return true;
//            }
//        }
//        @Override
//        public void updateArticle(Article article) {
//            articleRepository.save(article);
//        }
//        @Override
//        public void deleteArticle(int articleId) {
//            articleRepository.delete(getArticleById(articleId));
//        }
    }
}
