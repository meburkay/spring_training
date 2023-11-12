package com.cydeo.client;

import com.cydeo.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url="https://dummyapi.io",name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {

    //AT FeignClient if we need to send app-id to the api for retrieving data we use @RequestHeader annotation which is send the argument we put when calling the method to the api for retrieving data.
    @GetMapping("/data/v1/user?limit=10")
    Employee getEmployee(@RequestHeader("app-id") String id);
}
