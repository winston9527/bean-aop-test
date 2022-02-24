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


		/**
		 *
		 * CustomBeanDefinitionPostProcessor...postProcessBeanDefinitionRegistry
		 * CustomBeanDefinitionPostProcessor...postProcessBeanFactory
		 * init....
		 * init....
		 * beanDefinitionCount:42
		 * aop in ...tom
		 * 2022-02-24 12:59:08.314  INFO 14519 --- [           main] c.e.beanaoptest.BeanAopTestApplication   : Started BeanAopTestApplication in 15.508 seconds (JVM running for 15.796)
		 * hi---tom
		 * hi---tom1
		 * class com.example.beanaoptest.service.AccountService$$EnhancerBySpringCGLIB$$55a29959
		 * hi---tom2
		 * class com.example.beanaoptest.service.AccountService
		 */

		// according to log above ,we can see that a bean register by beanFactory.registerSingleton will not generate aop proxy
	}

}
