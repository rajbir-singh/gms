package com.gms.controller;

import com.gms.dto.AccountCreateDto;
import com.gms.dto.AccountListItemDto;
import com.gms.service.AccountService;
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

//    @GetMapping(path = "/add")
//    public @ResponseBody
//    String addNewUser(@RequestParam String name, @RequestParam String email) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        User n = new User();
//        n.setName(name);
//        n.setEmail(email);
//        userRepository.save(n);
//        return "Saved";
//    }

    //TODO : write tests that check attribute level validations
    @PutMapping(path = "add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity addAccount(@Valid @NotNull @RequestBody AccountCreateDto accountCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info("AccountCreateDto is not valid");
            return null;
        }
        return ok(newRestResponse(accountService.addAccount(accountCreateDto)));
    }

    @PostMapping(path = "update/{accountId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity updateAccount(@Valid @NotNull @RequestBody AccountCreateDto accountCreateDto, BindingResult bindingResult, @PathVariable(name = "employeeId") @NotNull @NotEmpty Long accountId) {
        if (bindingResult.hasErrors()) {
            logger.info("AccountCreateDto is not valid");
            return null;
        }
        return ok(accountService.updateAccount(accountId, accountCreateDto));
    }

    @GetMapping(value = "{accountId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<AccountListItemDto>> getAccountId(@PathVariable(name = "accountId") @NotNull @NotEmpty Long accountId) {
        if(Utils.isEmptyObject(accountId)) {
            throw new RuntimeException("Empty account found!");
        }
        return ok(accountService.findByAccountId(accountId));
    }

    //TODO : make this paginated
    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<RestResponse<List<AccountListItemDto>>> getAllAccounts() {
        // This returns a JSON or XML with the users
        return ok(accountService.findAll());
    }
}
