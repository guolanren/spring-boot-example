package name.guolanren.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author guolanren
 */
@Aspect
@Component
public class AopCommonAspect {

    @Pointcut("execution(* name.guolanren..*(..))")
    public void allMatch() {}

    @Pointcut("execution(public * name.guolanren..*(..))")
    public void allPublicMatch() {}

    @Before("allMatch()")
    public void beforeAllMatch() {
        System.out.println("Before allMatch...");
    }

    @Before("allPublicMatch()")
    public void beforeAllPublicMatch() {
        System.out.println("Before: before allPublicMatch...");
    }

    @After("allMatch()")
    public void afterAllMatch() {
        System.out.println("After: after allMatch...");
    }

    @AfterReturning(pointcut = "allMatch()", returning = "retVal")
    public void afterReturningMatch(Object retVal) {
        System.out.printf("AfterReturning: after returning allMatch, retVal is %s...%n", retVal);
    }

    @AfterThrowing(pointcut = "allMatch()", throwing = "e")
    public void afterThrowingMatch(Throwable e) {
        System.out.printf("AfterThrowing: after throwing allMatch, exception is %s...%n", e.getMessage());
    }

    @Around("allMatch()")
    public Object aroundMatch(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("Around: before allMatch...");
            Object result = joinPoint.proceed();
            return result;
        } catch (Throwable e) {
            System.out.printf("Around: throwing allMatch, exception is %s...%n", e.getMessage());
            throw e;
        } finally {
            System.out.println("Around: after allMatch...");
        }
    }

}
