package com.example.demo;

import aop.AopConfig;
import aop.MyService;
import aop.MyServiceImp;
import aop.cat;
import aop.AopConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("aop")
public class DemoApplication {



    public static void main(String[] args) {

        
        SpringApplication.run(DemoApplication.class, args);

    }


}
