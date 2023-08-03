package com.cydeo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "db")//We type here prefix and it assigns all the data from application.properties with the same prefix to the instance variables.
@Data
public class DBConfigData {

    private String username;
    private String password;
    private List<String> type;

}
