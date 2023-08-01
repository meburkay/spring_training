package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.casefactory.Case;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import com.cydeo.streotype_annotation.motherboardfactory.Motherboard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component//By putting this and adding the necessary objects Autowired we give the creating PC bean responsibility to spring.
@AllArgsConstructor//If we create AllArgsConstructor by lombok it again Automatically add the @Autowired structure.
public class PC {

    //@Autowired
    private Case theCase;
    //@Autowired
    private Monitor monitor;
    //@Autowired
    private Motherboard motherboard;

    //Spring said that if we have a constructor you don't need to write Autowired annotation I will do it automatically.
    //@Autowired//Instead of using field Autowire we use constructor Autowire. This is the true usage of it. By this we automatically Autowired all the necessary beans to PC.
//    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
//        this.theCase = theCase;
//        this.monitor = monitor;
//        this.motherboard = motherboard;
//    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}
