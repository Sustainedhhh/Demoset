package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);

//        cat myCat = applicationContext.getBean(cat.class);
        MyService myService = applicationContext.getBean(MyService.class);

//        System.out.println(myCat.getClass().getName());
//        System.out.println(myService.getClass().getName());
//        System.out.println("--------");
//
//        myCat.say();
//
//        System.out.println("--------");
//
//        myService.say();
//
//        System.out.println("--------");

        System.out.println(myService.update());



    }
}
