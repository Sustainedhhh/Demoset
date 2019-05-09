package aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut(value = "execution(* aop.*.say(..))")
    public void say(){}

    @Pointcut(value = "execution(* aop.*.update(..))")
    public void update(){}


    @Before(value = "update()")
    private void beforeSay(){
        System.out.println("before update()");
    }

    @Around(value = "update()")
    private Object aroundUpdate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Around Update before");
        Object res  = proceedingJoinPoint.proceed();
        System.out.println("Around Update after");

        return res;
    }
}
