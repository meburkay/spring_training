package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.modelmapper.ModelMapper;

@SpringBootApplication
@EnableFeignClients//For consuming apis by feign way we must put this here.
public class Spring17RestConsumingApisApplication {

    public static void main(String[] args) {

        SpringApplication.run(Spring17RestConsumingApisApplication.class, args);
    }

    //this is the first method to consume apis but it will be depriciated soon. To use this method first we create a bean from it.
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }


}
