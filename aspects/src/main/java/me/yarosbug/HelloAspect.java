package me.yarosbug;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class HelloAspect {
    @Around("execution(* *(..)) && @annotation(me.yarosbug.Marker)")
    public Object hello(ProceedingJoinPoint joinPoint) {
        return "Hello from Aspect!";
    }
}
