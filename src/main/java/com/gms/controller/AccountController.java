package com.gms.controller;

import com.gms.domain.Account;
import com.gms.dto.AccountDetailDto;
import com.gms.dto.AccountListItemDto;
import com.gms.exception.BindingErrorException;
import com.gms.exception.ResourceNotFoundException;
import com.gms.service.AccountService;
import com.gms.service.AddressService;
import com.gms.service.Utils;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/account")
public class AccountController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    //TODO : write tests that check attribute level validations
    @PostMapping(path = "add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity addAccount(@Valid @NotNull @RequestBody AccountDetailDto accountDetailDto, BindingResult bindingResult) throws ResourceNotFoundException, BindingErrorException {
        if (bindingResult.hasErrors()) {
            logger.info("AccountDetailDto is not valid");
            throw new BindingErrorException(bindingResult);
        }
        return ok(newRestResponse(accountService.addAccount(accountDetailDto)));
    }

    @PutMapping(path = "/update/{accountId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<AccountDetailDto>> updateAccount(@Valid @NotNull @RequestBody AccountDetailDto accountDetailDto, BindingResult bindingResult, @PathVariable(name = "accountId") @NotNull @NotEmpty Long accountId) throws ResourceNotFoundException {
        if (bindingResult.hasErrors()) {
            logger.info("AccountDetailDto is not valid");
            return null;
        }
        return ok(newRestResponse(accountService.updateAccount(accountId, accountDetailDto), true, "updated Account with accountId: " + accountId));
    }

    @GetMapping(value = "{accountId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<AccountDetailDto>> getAccountId(@PathVariable(name = "accountId") @NotNull @NotEmpty Long accountId) throws ResourceNotFoundException {
        if (Utils.isEmptyObject(accountId)) {
            throw new IllegalArgumentException("Empty accountId found!");
        }
            return ok(newRestResponse(accountService.getAccountDetailDtoByAccountId(accountId), true, "found account with accountId: " + accountId));
    }

    @GetMapping(value = "/googleLogin/{idTokenString}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RestResponse<AccountDetailDto>> googleLogin(@PathVariable(name = "idTokenString") @NotNull @NotEmpty String idTokenString) throws GeneralSecurityException, IOException {
        if (Utils.isStrNullOrEmpty(idTokenString)) {
            throw new IllegalArgumentException("Empty idTokeString found!");
        }
        return ok(newRestResponse(accountService.findOrCreateAccountForGoogleUser(idTokenString), true, "verrified google user with idTokenString: " + idTokenString));
    }

    /********************* PASSED PHASE ONE ***************************/

    @GetMapping(path = "/all", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RestResponse<List<AccountListItemDto>>> getAllAccounts(
//            @Join(path = "addresses", alias = "a", type = JoinType.LEFT)
            @Or({
                    @Spec(path = "accountId", params = "query", spec = Equal.class),
                    @Spec(path = "name", params = "query", spec = Like.class),
                    @Spec(path = "mobile1", params = "query", spec = Like.class),
                    @Spec(path = "mobile2", params = "query", spec = Like.class),
                    @Spec(path = "email1", params = "query", spec = Like.class),
                    @Spec(path = "email2", params = "query", spec = Like.class),
                    @Spec(path = "qualification", params = "query", spec = Like.class)
//            @Spec(path = "a.state", params = "query", spec = In.class)
            }) Specification<Account> accountSpec, Pageable pageable) {

        Page<Account> accountPage = accountService.findAll(accountSpec, pageable);
        return ok(newRestResponse(accountService.findAll(accountSpec, pageable), true, "accounts search results"));
    }

}
