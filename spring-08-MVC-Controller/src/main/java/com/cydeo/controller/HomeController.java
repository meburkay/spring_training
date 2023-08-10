package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//By this annotation spring creating a bean from this class and this class registered to Handler Mapping as a controller class.
public class HomeController {

    @RequestMapping("/home")//this is the END POINT which is coming after the base url of the web application. For example www.amazon.com/home. Spring find by this information that which method will it call.
    public String home(){
        return "home.html";//By this string spring go to View Resolver to find the appropriate html view from the static and template folders
    }

    @RequestMapping("/ozzy")
    public String getHomePage2(){
        return "home.html";
    }

    @RequestMapping // nothing or /   means default and automatically goes to the without url page view.
    public String getHomePage3(){
        return "home.html";
    }

    @RequestMapping ({"/apple","/orange"}) //We can give multiple end points for one view.
    public String getHomePage4(){
        return "home.html";
    }

}
