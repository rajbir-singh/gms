package com.gms.controller;

import com.gms.dto.AccountDetailDto;
import com.gms.dto.AccountListItemDto;
import com.gms.exception.ResourceNotFoundException;
import com.gms.service.AccountService;
import com.gms.service.AddressService;
import com.gms.service.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping(path = "/api/account")
public class AccountController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    //TODO : write tests that check attribute level validations
    @PutMapping(path = "add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity addAccount(@Valid @NotNull @RequestBody AccountDetailDto accountDetailDto, BindingResult bindingResult) throws ResourceNotFoundException {
        if (bindingResult.hasErrors()) {
            logger.info("AccountDetailDto is not valid");
            return null;
        }
        return ok(newRestResponse(accountService.addAccount(accountDetailDto)));
    }

    @PostMapping(path = "/update/{accountId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<AccountDetailDto>> updateAccount(@Valid @NotNull @RequestBody AccountDetailDto accountDetailDto, BindingResult bindingResult, @PathVariable(name = "accountId") @NotNull @NotEmpty Long accountId) throws ResourceNotFoundException {
        if (bindingResult.hasErrors()) {
            logger.info("AccountDetailDto is not valid");
            return null;
        }
        return ok(accountService.updateAccount(accountId, accountDetailDto));
    }

    @GetMapping(value = "{accountId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<AccountDetailDto>> getAccountId(@PathVariable(name = "accountId") @NotNull @NotEmpty Long accountId) throws ResourceNotFoundException {
        if (Utils.isEmptyObject(accountId)) {
            throw new RuntimeException("Empty accountId found!");
        }
        return ok(accountService.getAccountDetailDtoByAccountId(accountId));
    }

    /********************* PASSED PHASE ONE ***************************/

    //TODO : make this paginated
    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<RestResponse<List<AccountListItemDto>>> getAllAccounts() {
        // This returns a JSON or XML with the users
        return ok(accountService.findAll());
    }

}
