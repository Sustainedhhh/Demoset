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
        printTest();
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
}
