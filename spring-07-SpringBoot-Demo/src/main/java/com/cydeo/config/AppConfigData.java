package com.cydeo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration//Normally we must use @Component but @Configuration cover @Component too. And because this is a Config process developers generally choose to use @Configuration.
public class AppConfigData {

    //When we are retrieving data from application.properties file we use this method.
    @Value("${myusername}")
    private String userName;

    @Value("${password}")
    private String password;

    @Value("${url}")
    private String url;

}
