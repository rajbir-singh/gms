package com.gms.service;

import com.gms.converter.AccountCreateDtoConverter;
import com.gms.converter.AccountListItemConverter;
import com.gms.domain.Account;
import com.gms.dto.AccountCreateDto;
import com.gms.dto.AccountListItemDto;
import com.gms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountListItemConverter accountListItemConverter;

    @Autowired
    private AccountCreateDtoConverter accountCreateDtoConverter;

//    public Account findName() {
//        return accountRepository.findName();
//    }

    @Override
    public List<AccountListItemDto> findAll() {
        Iterable<Account> accounts = accountRepository.findAll();
//        if (Utils.isEmptyList(accounts)) {
//            return Collections.emptyList();
//        }
        return getAccountListItemDtosFromAccountsList(accounts);
    }

    public Account saveAccount(AccountCreateDto accountCreateDto) {
        //TODO : throw better exception here
        if(Utils.isEmptyObject(accountCreateDto)) {
            throw new RuntimeException("Null AccountCreateDto found!");
        }
        Account account = accountCreateDtoConverter.convertFromDto(accountCreateDto);
        return accountRepository.save(account);
    }

    @Override
    public Account findByUserId(String accountId) {
        return accountRepository.findByAccountId(accountId);
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
