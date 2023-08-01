package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment  = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");


        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);


        CommentService cs1 = context.getBean(CommentService.class);
        CommentService cs2 = context.getBean(CommentService.class);

        //We change the scope of spring at the CommentService to prototype and because of that spring give us new beans when we request. Below we test it.
        System.out.println(cs1);        //com.cydeo.service.CommentService@408d971b
        System.out.println(cs2);        //com.cydeo.service.CommentService@6c6cb480
        System.out.println(cs1==cs2);   //false

    }
}
