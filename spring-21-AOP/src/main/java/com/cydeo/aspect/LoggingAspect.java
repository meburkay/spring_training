package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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



    //we use within with package. We define the package here as controller.. which means controller package and all the subpackages under it. By this every method under controller package will be Pointcut.
//    @Pointcut("within(com.cydeo.controller..*)")
//    public void anyControllerOperation() {}
//
    //@within we use annotations. And we must give the exact place of that annotation. Here we use it for the @service annotation. When we look at the import of @service annotation we see the address that we write below. By this every @Service annotation class's methods will be Pointcuts.
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation() {}
//
    //here we use or and use two Pointcuts together.
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }


    //We use @annotation here and like @within we give the exact import of the annotation. By this every @DeleteMapping annotations become pointcuts it doesn't matter which class or package they are in.
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation() {}
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }


    //We create our own annotation, we put it some methods at the CourseController and used it here.
//    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC() {}
//
//    @Before("loggingAnnotationPC()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }



//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation() {}
//


    //Here we use @AfterReturning annotation and different from before we use names when adding parameters and after pointcut parameter we add a returning parameter. And we can see what the method returns by using that result object.
//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "result")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, Object result) {
//        logger.info("After Returning -> Method: {}, Result: {}", joinPoint.getSignature(), result.toString());
//    }
//



    //Here we try to do the same thing with list but when we use as List<Object> the method didn't work. After that we try to use the direct returning type and it worked. The issue is because of casting. We can cast one object but when it comes to list we can not do that.
//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "results")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results) {
//        logger.info("After Returning -> Method: {}, Result: {}", joinPoint.getSignature(), results.toString());
//    }
//
    // CourseDTO -> Object     --> This is ok
    // List<CourseDTO> -> List<Object>     --> This is not ok
//


    //We use here @AfterThrowing annotation. The parameters are the same as after returning. instead of return we use throwing and by that parameter we can see it at the log.
//    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
//    public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception) {
//        logger.error("After Throwing -> Method: {}, Exception: {}"
//                , joinPoint.getSignature().toShortString(), exception.getMessage());
//    }


    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC() {}

    //We use @Around here. We define return type as an Object because we will use it. And different from others we use ProceedingJoinPoint here. It is similar to JoinPoint the one difference is ProceedingJoinPoint has a proceed method which we will use later.
    @Around("loggingAnnotationPC()")
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint) {

        logger.info("Before -> Method: {} - Parameter {}"
                , proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());

        //here we create an Object for the return part.
        Object result = null;

        //This try catch will be our line for the after part. Actually by using proceed method we said that we finish the before part you can continue to execute the method here. After the method executed the returning object assign to our result object.
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //After the method executed we take the logging information and for the return part of the method we use result to take the data. And we return result. As far as I understand we do not need to Object as a return type here. We can use void. and did not return result likewise.
        logger.info("After -> Method: {} - Result: {}"
                , proceedingJoinPoint.getSignature().toShortString(), result.toString());
        return result;

    }



}
