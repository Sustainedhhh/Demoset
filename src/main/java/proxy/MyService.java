package proxy;

public interface MyService {


    @myAnnotation("In Interface before | add | myAnnotaion")
    @myAnnotation2("In Interface before | add | myAnnotation2")
    void add();

    @myAnnotation("In Interface before | update | myAnnoation")
    @myAnnotation2("In Interface before | update | myAnnotion2")
    void update();

}
