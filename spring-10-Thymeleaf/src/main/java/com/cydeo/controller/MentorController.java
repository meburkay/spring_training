package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register") //localhost:8080/mentor/register
    public String register(Model model){

        //We create this list for the dropdown button at the view. Then we loop it there and use.
        List<String> batchList = Arrays.asList("JD1","JD2","JD3");
        model.addAttribute("batchList",batchList);

        //We create an empty Mentor object for the form to fill it.
        model.addAttribute("mentor",new Mentor());

        return "mentor/mentor-register";
    }


    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor){//We use @ModelAttribute here to retrieve the mentor object that used in the form. And then we used it in the confirm view.

        return "mentor/mentor-confirmation";
    }

}
