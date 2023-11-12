package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//to use feign method we create client methods and put feignClient annotation with base url and name inside the parenthesize. Name is used at microservices, right now it is not important. Then we create methods inside this UserClient interface.
@FeignClient(url = "https://jsonplaceholder.typicode.com",name="USER-CLIENT")
public interface UserClient {

    //We can not use feignclient method without dtos. Like below we get and return the data by our dtos. Here we use User dto.
    @GetMapping("/users")
    List<User> getUsers();

}
