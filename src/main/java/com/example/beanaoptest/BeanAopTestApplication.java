package com.example.beanaoptest;

import com.example.beanaoptest.service.AccountService;
import com.example.beanaoptest.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BeanAopTestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(BeanAopTestApplication.class, args);
		int beanDefinitionCount = run.getBeanDefinitionCount();
		System.err.println("beanDefinitionCount:"+beanDefinitionCount);

		UserService userService = run.getBean(UserService.class);
		userService.sayHello("tom");

		AccountService accountService = (AccountService)run.getBean("accountService1");
		accountService.sayHello("tom1");
		System.out.println(accountService.getClass());
		AccountService accountService2 = (AccountService)run.getBean("accountService2");
		accountService2.sayHello("tom2");
		System.out.println(accountService2.getClass());
	}

}
