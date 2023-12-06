package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.inOrder;

//For using Mockito annotations we need to add this annotation and class name.
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    //Instead of dependency injection we create mocks by @Mock annotation. Then we use them instead of real ones.
    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    //When testing we use direct classes. Because @InjectMocks doesn't work with interfaces. When we add this annotation it injects the mock objects and extra create an object from the userService.
    @InjectMocks
    UserServiceImpl userService;

    @Test
    void findByUserName_Test() {

        // I'm calling the real method inside the main, which is the method I want to test.
        userService.findByUserName("harold@manager.com");

        // I'm checking if this method ran or not which is inside the main method.
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);

        //Here we define that how many times does the method must execute. According to that it succeed or fail.
        verify(userRepository, times(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atMost(10)).findByUserNameAndIsDeleted("harold@manager.com", false);


        //Here we test the execution order of the methods. We inOrder interface and method provided by Mockito.
        InOrder inOrder = inOrder(userRepository, userMapper);

        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);
        inOrder.verify(userMapper).convertToDto(null);

    }
}