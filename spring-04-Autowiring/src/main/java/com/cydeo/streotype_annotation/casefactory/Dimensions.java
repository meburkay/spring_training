package com.cydeo.streotype_annotation.casefactory;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor//Because of this constructor spring try to create the bean but it doesn't have the int value for the fields. Because of that it can not create bean and give error.
@Component
public class Dimensions {

    private int width;
    private int height;
    private int depth;

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}
