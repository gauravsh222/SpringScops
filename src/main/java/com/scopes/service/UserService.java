package com.scopes.service;

import com.scopes.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {


    private Integer count=0;

//     @Autowired
//     private AccountService accountService;


    public UserService() {
        System.out.println("UserService created using No Args Constructor");
    }

    private Map<String, User> map = new HashMap<>();

    public String saveUserInfo(User user) {
        System.out.println("Count : " + count++);
        System.out.println("User Service HashCode : " +this.hashCode());
        System.out.println(accountService().getAccountInfo("12345"));
        map.put(user.getUserName(), user);
        return "saved";
    }

    public User getUserInfo(String userName) {
        System.out.println("User Service HashCode : " +this.hashCode());
        return map.get(userName);
    }

    @Lookup
    public AccountService accountService() {
        return null;
    }
}
