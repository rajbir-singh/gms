package com.gms.service;

import com.gms.converter.AccountDetailDtoConverter;
import com.gms.converter.AccountListItemConverter;
import com.gms.converter.AddressDetailDtoConverter;
import com.gms.domain.Account;
import com.gms.domain.Address;
import com.gms.dto.AccountDetailDto;
import com.gms.dto.AccountListItemDto;
import com.gms.dto.AddressDetailDto;
import com.gms.exception.ResourceNotFoundException;
import com.gms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    private AccountDetailDtoConverter accountDetailDtoConverter;

    @Autowired
    private AddressDetailDtoConverter addressDetailDtoConverter;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AccountService accountService;

    @Transactional
    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public boolean existsById(Long accountId) throws ResourceNotFoundException {
        if (!accountRepository.existsById(accountId)) {
            throw new ResourceNotFoundException("AccountId: " + accountId + " not found");
        }
        return true;
    }

    @Transactional
    @Override
    public List<AccountListItemDto> findAll() {
        List<Account> accounts = accountRepository.findAll();
        if (Utils.isEmptyList(accounts)) {
            return Collections.emptyList();
        }
        return getAccountListItemDtosFromAccountsList(accounts);
    }

    @Override
    public Account saveAccount(Account account) {
        //TODO : throw better exception here
        if (Utils.isEmptyObject(account)) {
            throw new RuntimeException("Null Account object found!");
        }
        return accountRepository.save(account);
    }

    public AccountDetailDto addAccount(AccountDetailDto accountDetailDto) throws ResourceNotFoundException {
        if (Utils.isEmptyObject(accountDetailDto)) {
            throw new RuntimeException("Null AccountDetailDto found!");
        }

        //using a converter below to get an account object having values as obtained from add request object
        Account account = accountDetailDtoConverter.convertFromDto(accountDetailDto);

        //persist account object in DB, this saves account and addresses, hence generating thier IDs, which are further used to updating the OneToMany mapping
        account = this.saveAccount(account);

        //fetch addresses from account to update the OneToMany mapping
        List<Address> addresses = account.getAddresses();
        for (Address address : addresses) {
            //update mapping
            address.setAccount(account);
            addressService.saveAddress(address);
        }
        return accountDetailDtoConverter.convertToDto(account);
    }

    @Transactional
    public AccountDetailDto updateAccount(Long accountId, AccountDetailDto accountDetailDto) throws ResourceNotFoundException {
        //TODO : throw better exception here
        if (Utils.isEmptyObject(accountDetailDto)) {
            throw new RuntimeException("Null AccountDetailDto found!");
        }

        //first of all save child entities, so that we have them ready (along with their DB generated ID) to be set into parent entity
        List<AddressDetailDto> addressDetailDtos = accountDetailDto.getAddresses();
        List<Address> addresses = new ArrayList<>();
        for (AddressDetailDto addressDetailDto : addressDetailDtos) {
            addresses.add(addressService.saveAddress(addressDetailDtoConverter.convertFromDto(addressDetailDto)));
        }

        //fetch parent entity from hibernate so that it becomes managed
        Account account = accountService.findByAccountId(accountId);

        //set accountId in accountDetailDto as it is further used to modify the managed account entity
        accountDetailDto.setAccountId(account.getAccountId());

        //modify account object according to the details in accountDetailDto (which is the update request object)
        //TODO : do check if this is the right way, should'nt I be calling setters on the managed account object (MOB) directly rather than setting properties on another account object and setting the MOB's reference to the new account object
        account = accountDetailDtoConverter.convertFromDto(accountDetailDto);

        //we don't care what addresses are set on MOB from above converter, as the above converter does apt conversions, but it does'nt persist addresses
        //so we need to set addresses which are saved in DB and have an ID (child entities saved above)
        //CAREFULL : this removes all previous addresses linked to the account whose addressId is not present in addresses list of accountDetailDto take some to think why, HiNT : line 95
        account.setAddresses(addresses);

        //Now account object is complete, and can be sent to DB
        account = saveAccount(account);

        //At this point both entities have been persisted to DB
        //time to link them by updating the OneToMany mapping
        for (Address address : addresses) {
            address.setAccount(account);
            addressService.saveAddress(address);
        }

        return accountDetailDtoConverter.convertToDto(account);
    }

    @Override
    public Account findByAccountId(Long accountId) throws ResourceNotFoundException {
        if (existsById(accountId)) {
            return accountRepository.findByAccountId(accountId);
        } else
            throw new ResourceNotFoundException("Account with accountId : " + accountId + " not found");
    }

    public AccountDetailDto getAccountDetailDtoByAccountId(Long accountId) throws ResourceNotFoundException {
        if (!accountRepository.existsById(accountId)) {
            throw new ResourceNotFoundException("Account with accountId : " + accountId + " not found");
        }
        Account account = findByAccountId(accountId);
        return accountDetailDtoConverter.convertToDto(account);
    }

    public List<AccountListItemDto> getAccountListItemDtosFromAccountsList(Iterable<Account> accounts) {
        //TODO: add empty list check for iterable
//        if (Utils.isNonEmptyList(accounts)) {
//            return Collections.emptyList();
//        }
        List<AccountListItemDto> accountListItemDtos = new ArrayList<>();
        accounts.forEach(account -> accountListItemDtos.add(accountListItemConverter.convertToDto(account)));
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
