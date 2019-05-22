package lang;

/**
 * JAVA的多态
 *
 * @author : zgl
 * @date : 2019-05-22
 */
public class Polymorphic {

    public static void main(String[] args) {
//        A.test();

//    Father child = new Child();
//    child.staticTest();
//    child.overrideTest();

        Child child = new Child();
        child.staticTest();
        child.overrideTest();


    }

}

class Father {

    static void staticTest() {
        System.out.println("father's staticTest");
    }

    void overrideTest() {
        System.out.println("father's overrideTest");
    }
}

class Child extends Father {

    static void staticTest() {
        System.out.println("Child's staticTest");
    }

    @Override
    void overrideTest() {
        System.out.println("Child's overrideTest");
    }
}


/**
 * 网上摘抄的一段关于多态问题的练习
 *
 * @author : zgl
 * @date : 2019-05-22
 */
class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

    public static void test() {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }

}

class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    @Override
    public String show(A obj) {
        return ("B and A");
    }
}

class C extends B {
}

class D extends B {
}
