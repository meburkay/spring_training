package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    //We create by using interface because if we want to change the database implementation we need to change this and it is tightly coupled. But When we create interface reference we do it loosely coupled. If we want to change it we will not touch here we create the new way's class and implement it.
    //private DBCommentRepository dbCommentRepository;
    //@Autowired//Instead of this we create constructor and it automatically autowired.
    //to use final is a good practice because when we use final and if we forget to create constructor the compiler warn us that we did not initialize the references. Or after some time if we add new reference here and forget to add it to constructor compiler will warn as again.
    private final CommentRepository commentRepository;
    //@Autowired//Instead of this we create constructor and it automatically autowired.
    private final CommentNotificationProxy commentNotificationProxy;

    //we solve the @primary issue by using instead of it @Qualifier annotation. Here we said that when you create a CommentService use emailCommentNotificationProxy(this is the default name of the class only the first letter become lower case, When we use stereotype annotations the bean names become like this automatically)
    public CommentService(CommentRepository commentRepository,@Qualifier("emailCommentNotificationProxy") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){

        commentRepository.storeComment(comment);//save comment
        commentNotificationProxy.sendComment(comment);//send email
    }
}
