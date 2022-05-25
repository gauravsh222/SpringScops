package com.scopes.service;

import com.scopes.dto.Account;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AccountService {

    private Integer count=0;

    public AccountService() {
        System.out.println("AccountService created using No Args Constructor");
    }

    private Map<String, Account> map = new HashMap<>();

    public String saveAccountInfo(Account account) {
        System.out.println("Count : " + count++);
        System.out.println("Account Service HashCode : " +this.hashCode());
        map.put(account.getAccountHolder(), account);
        return "saved";
    }

    public Account getAccountInfo(String accountHolder) {
        System.out.println("Account Service HashCode : " +this.hashCode());
        return map.get(accountHolder);
    }
}
