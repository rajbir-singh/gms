package com.gms.controller;

import com.gms.dto.AccountCreateDto;
import com.gms.dto.AccountListItemDto;
import com.gms.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping(path = "/account")
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
    @PostMapping(path = "add", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity addAccount(@Valid @RequestParam AccountCreateDto accountCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info("AccountCreateDto is not valid");
            return null;
        }
        return ok(newRestResponse(accountService.saveAccount(accountCreateDto)));
    }

    @PostMapping(path = "update", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity updateAccount(@Valid @RequestParam AccountCreateDto accountCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info("AccountCreateDto is not valid");
            return null;
        }
        return ok(newRestResponse(accountService.saveAccount(accountCreateDto)));
    }

    //TODO : make this paginated
    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<AccountListItemDto> getAllAccounts() {
        // This returns a JSON or XML with the users
        return accountService.findAll();
    }
}
