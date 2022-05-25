package com.scopes.controller;

import com.scopes.dto.Account;
import com.scopes.dto.User;
import com.scopes.service.AccountService;
import com.scopes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    public AccountController() {
        System.out.println("AccountController Initialized");
    }

    @PostMapping("/account")
    public ResponseEntity<String> saveAccountInfo(@RequestBody Account account) {
        System.out.println("Controller : " + this.hashCode());
        accountService.saveAccountInfo(account);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/account")
    public ResponseEntity<Account> getAccountInfo(@RequestParam("accountHolder") String accountHolder) {
        System.out.println("Controller : " + this.hashCode());
        Account accountInfo = accountService.getAccountInfo(accountHolder);
        return new ResponseEntity<>(accountInfo, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveUserInfo(@RequestBody User user) {
        userService.saveUserInfo(user);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserInfo(@RequestParam("userName") String userName) {
        User userInfo = userService.getUserInfo(userName);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }


}
