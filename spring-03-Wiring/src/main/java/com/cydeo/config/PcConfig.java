package com.cydeo.config;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {

    @Bean
    public Case caseDell(Dimensions dimensions){//We give Dimensions parameter and spring automatically give here the Dimensions bean. It is autowiring. If we have another bean that need Dimensions spring use the same Dimensions bean object and autowire it to that bean too. It does not create a new object/bean for it. It is the advantage of spring framework.

        return new DellCase("220B","Dell","240",dimensions);
    }
    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);
    }


}
