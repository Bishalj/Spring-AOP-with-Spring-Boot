package com.bishal.SpringAspect.aspectConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AspectConfig {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    @Before(value = "@annotation(LoggingActivity)")
    public void loggingBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getArgs());
        for (Object s:joinPoint.getArgs()) {
            String json = ow.writeValueAsString(s);
            System.out.println(json);
        }

        MethodSignature signature = (MethodSignature)
                joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("Logging source" + method.getAnnotation(LoggingActivity.class).source());
//
//        System.out.println();System.out.println(joinPoint.getKind());
//        System.out.println(joinPoint.getSignature());
//        System.out.println(joinPoint.getStaticPart());
//        System.out.println(joinPoint.getTarget());
//        System.out.println(joinPoint.getThis());
//        System.out.println(joinPoint.toLongString());
//        System.out.println(joinPoint.toShortString());
//        System.out.println(joinPoint.toString());
//        System.out.println(joinPoint.getSourceLocation());
//        System.out.println();
//        System.out.println();




        System.out.println("***************ASPECT WORKING*****************");
    }
}
