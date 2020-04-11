package name.guolanren.aspect;

import name.guolanren.annotation.AopAnnotation;
import name.guolanren.annotation.AopAnnotations;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author guolanren
 */
@Aspect
@Component
public class AopAnnotationAspect extends SpelSupportedAspect {


    @Around("@annotation(aopAnnotations)")
    public Object aroundMatch(ProceedingJoinPoint joinPoint, AopAnnotations aopAnnotations) throws Throwable {
        try {
            addVariable(joinPoint);
            boolean requiredAop = true;
            for (AopAnnotation aopAnnotation : aopAnnotations.value()) {
                 requiredAop = requiredAop && getValue(aopAnnotation.condition(), Boolean.class);
            }
            if (requiredAop) {
                System.out.println("Around: before required aop...");
            }
            Object result = joinPoint.proceed();
            return result;
        } catch (Throwable e) {
            throw e;
        }
    }

}
