package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

@SpringBootApplication//(exclude = {AopAutoConfiguration.class})//By this we can exclude classes that we do not want to create bean by spring. And it doesn't create bean for that classes automatically.
public class CydeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CydeoApplication.class, args);
	}

}
