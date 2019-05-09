package aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("myService")
public class MyServiceImp implements MyService {

    @Override
    public void say() {
        System.out.println("say");
    }

    @Override
    public int update() {
        System.out.println("update");
        return 666;
    }


}
