package com.cydeo.proxy;

import com.cydeo.model.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy {


    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment:" + comment.getText());
    }
}
