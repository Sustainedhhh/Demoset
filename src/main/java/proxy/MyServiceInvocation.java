package proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyServiceInvocation implements InvocationHandler {

    private Object target;

    public MyServiceInvocation(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before method.invoke");
        if ( null != method.getAnnotations() && method.getAnnotations().length != 0){
            for (Annotation an : method.getAnnotations()){
                System.out.println(an.toString());
            }
        }
        Object obj = method.invoke(target,args);
        return obj;
    }
}
