package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //this is from slf4j library. We create a Logger object with this line and then use it. The library has different methods for logging the program.
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //This means every method inside the CourseController class and (..) doesn't matter if they have parameter or not.
//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPointcut() {}
//
//    @Before("myPointcut()")
//    public void log() {
//        logger.info("Info log..........");
//    }
//
    //We can use like this without @Pointcut annotation. But in this case if we want to use the same Pointcut with another advice we have to write it again.
//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log() {
//        logger.info("Info log..........");
//    }

    //this means findById method execution it doesn't matter which type but have to have one argument.
    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
    public void courseRepositoryFindByIdPC() {}


    //Here we use JoinPoint parameter which is used for logging. And inside info method we use an implementation generally used inside logger libraries. First we give a string argument and then we use joinPoint for getting info about the operation. For every curly braces at the first string we put one argument that retrieve data about the log. And that data go to the curly braces place when log printing at the console.
    @Before("courseRepositoryFindByIdPC()")
    public void beforeCourseRepositoryFindById(JoinPoint joinPoint) {
        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
    }

}
