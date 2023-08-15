package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")//When we use this it will add all the method end points /student
public class StudentController {

    //@RequestMapping(value = "/register",method = RequestMethod.GET) //localhost:8080/student/register
    @GetMapping("/register")//get mapping to request a view to see.
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
    }

    @RequestMapping(value = "/welcome",method = RequestMethod.POST) //localhost:8080/student/welcome?name=Ozzy
    @PostMapping("/welcome")//to send a data to server
    public String welcome(@RequestParam String name){//We add link a parameter with parenthesis and capture it here as parameter.


        System.out.println(name);
        return "student/welcome";
    }
}
