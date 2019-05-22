package exception;

/**
 * JAVA异常学习
 *
 * @author zwl
 * @create 2019/5/21
 * @since 1.0.0
 */
public class MyException extends Exception {

    public MyException() {}
    public MyException(String msg) {
        super(msg);
    }


    public static void main(String[] args) {
//        printTest();
//        exceptionTest(3);
//        exceptionConstructorTest();
//        finallyTest();
//    exceptionLostTest();
        exceptionChainTest();
    }




    /**
     * 错误信息的打印
     */
    public static void printTest() {
        try {
            throw new MyException();

        } catch (MyException e) {

            // 错误信息将会被默认地输出至err流 System.err
            e.printStackTrace();

            // 错误信息将会被输出至标准流 System.out
            e.printStackTrace(System.out);
        }
    }

    /**
     * 在捕获异常时，使用 异常基类 Exception 捕获所有异常
     */
    public static void exceptionTest(int type) {
           try {
               switch (type) {
                   case 1 :
                       throw new UnsupportedOperationException();
                   case 2 :
                       throw new IllegalAccessException();
                   case 3:
                       throw new NullPointerException("主动抛出的 RuntimeException 类型");
                   default:
                       throw new IllegalArgumentException();
               }
           } catch (Exception e) {
               System.out.println("----------------------------------------");
               System.out.println("Caught a Exception: ");
               System.out.println("e.getMessage(): ");
               System.out.println(e.getMessage());
               System.out.println("e.getLocalizedMessage: ");
               System.out.println(e.getLocalizedMessage());
               System.out.println("e.toString(): ");
               System.out.println(e.toString());
               System.out.println("e.getClass().getSimpleName(): ");
               System.out.println(e.getClass().getSimpleName());
               System.out.println("e.printStackTrace(System.out): ");
               e.printStackTrace(System.out);
           }
    }

    /**
     * 传入构造参数的 String 信息，会在打印错误时打印出来
     */
    public static void exceptionConstructorTest() {
        try {
            RuntimeException exception = new RuntimeException("带有msg信息");
            throw exception;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * finally 语句的含义是指
     * 无论因为何种原因（异常捕获处理跳转至catch 语句中、try 或 catch中使用了return返回、异常未被捕获而是抛出）
     * 跳转至上级执行环境时，
     * 都会先执行`finally`语句，结束后再跳转。
     */
    public static void finallyTest() {
        try {
            try {
                throw new Exception();
//        } catch (Exception e) {
//            return;
            } finally {
                System.out.println("Got it");
            }
        } catch (Exception e) {

        }

    }

    /**
     * 异常丢失
     */
    public static void exceptionLostTest() {
        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            throw e;
        } finally {
//            throw new NullPointerException();
         return;
        }

    }

    /**
     * 异常链使用
     */
    public static void exceptionChainTest() {
        try {
            try {
                throw new IllegalArgumentException("1st");
            } catch (Exception e) {
                NullPointerException nullpointerException = new NullPointerException("2st");
                nullpointerException.initCause(e);
                throw nullpointerException;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
