package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary//We give it here when we have two same type classes who implement the same interface. If we did not put this spring can not decide which of them it must use when creating the object according to the interface reference. In which cases this can be happen: For example if we take a third party like spring etc. interface and implement it but its feature is not suitable for us and we create our custom class implementation we must use this annotation and say spring that I want to use this implementation.
//The disadvantage of @primary annotation is when we used it we locked the other implementations. spring can only use this implementation. But if we need to use different implementations according to the situation.
@Qualifier("EMAIL")//We can customise Qualifier word like this. And we can use either this or the long name.
public class EmailCommentNotificationProxy implements CommentNotificationProxy {


    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment:" + comment.getText());
    }
}
