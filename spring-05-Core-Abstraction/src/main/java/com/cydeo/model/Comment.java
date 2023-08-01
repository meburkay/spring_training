package com.cydeo.model;

import lombok.Data;

@Data
//We did not put here @Component annotation because this class doesn't have a class instance variable inside (doesn't have a has a relationship) and in our application any other class has a relationship with this class means any other class has it as a instance variable.(any other class doesn't have a has a relationship with this class) WE DON'T ADD @COMPONENT TO ENTITY/MODEL CLASSES.
public class Comment {
    private String author;
    private String text;
}
