package proxy;

public class MyServiceImp implements MyService {

    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void update() {
        System.out.println("update");
    }


}
