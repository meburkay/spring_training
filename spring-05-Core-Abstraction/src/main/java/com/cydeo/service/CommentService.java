package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
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

    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){

        commentRepository.storeComment(comment);//save comment
        commentNotificationProxy.sendComment(comment);//send email
    }
}
