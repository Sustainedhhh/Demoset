package aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("cat")
public class cat {

    public void say(){
        System.out.println("cat miao");
    }
}
