package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {

    //We use the api's uri which we will consume.
    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<User[]> readAllUsers(){

        //Rest template accepts array because of that we use User[]. class. And getForEntity method return ResponseEntity already. Because of that we directly return it. We did not use ResponseEntity class directly.
        //Actually by getForEntity here we give the api uri and the dto which will be used for the consuming data holder. And by executing the method we take the api's json data and put it to the User dto and return is as a ResponseEntity.
        return restTemplate.getForEntity(URI, User[].class);
    }

    //Here we use the consuming data directly without dtos. This is not the case most of the time. Because when we do not use dtos then we can not manipulate the data that we consume. But the method above we use dtos and by dto classes we can manipulate the data however we want. It is more suitable in general usage.
    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){

        String URL = URI + "/{id}";

        return restTemplate.getForObject(URL, Object.class,id);

    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostFromDummyApi(){

        //At the four lines of code below we set the header and its value.
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        //When we want to use headers we use exchange method of restTemplate.
        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

    }







}
