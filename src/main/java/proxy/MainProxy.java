package proxy;

        import java.lang.reflect.Proxy;

public class MainProxy {


    public static void main(String[] args) {

        //如果这个地方 传入的实例的类没有实现接口
        //那么在 Prox.newProxyInstance()中的第二个参数处就是null 无法实现动态代理


      /*
        cat cat2 = new cat();
        MyServiceInvocation myServiceInvocation = new MyServiceInvocation(cat2);
        cat catProxy = (cat) Proxy.newProxyInstance(cat2.getClass().getClassLoader(), cat2.getClass().getInterfaces(), myServiceInvocation);
        catProxy.say();
      */

      MyService imp = new MyServiceImp();

      MyServiceInvocation myServiceInvocation = new MyServiceInvocation(imp);

      MyService myservicePorxy = (MyService) Proxy.newProxyInstance(imp.getClass().getClassLoader(),imp.getClass().getInterfaces(),myServiceInvocation);

      myservicePorxy.add();
      myservicePorxy.update();
    }

}
