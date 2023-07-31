package com.cydeo.tightly_coupled;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PC {
    //Here PC class dependent to other classes which are below. And when we want to change the components of PC we have tha make changes here the main code of PC. Because PC is tightly coupled with these classes. And this is a bad structure.
    private DellCase theCase;
    private AcerMonitor monitor;
    private AsusMotherboard motherboard;

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        monitor.drawPixelAt(1200, 50, "yellow");
    }
}
