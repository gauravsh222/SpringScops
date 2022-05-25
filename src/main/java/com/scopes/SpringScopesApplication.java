package com.scopes;

import com.scopes.service.AccountService;
import com.scopes.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringScopesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringScopesApplication.class, args);
	}


}
