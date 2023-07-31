package com.cydeo.streotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan//Go and look to the classes and for the classes that have the @Component annotation create from them beans.
@ComponentScan("com.cydeo")//normally componentScan scan the package which it is in but when we add an address in the parenthesis it looks there and scan that package. Here we say it that scan all cydeo package and look for @component annotation and create beans according to this.
public class PcConfig {
}
