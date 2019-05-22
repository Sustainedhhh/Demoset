package lang;

import java.util.Arrays;
import java.util.Date;

/**
 * 内部类的学习
 *
 * @author zwl
 * @create 2019/5/17
 * @since 1.0.0
 */
public class Outer {


    public static void main(String[] args) {
        Outer outer = new Outer();
        Temp temp = new Temp(10);
        outer.print(temp);
    }


    /**
     * 局部内部类（匿名内部类） 在使用局部参数时，无论其是类实例类型还是基本数据类型。
     * 都要求其要么显示被标注为 final 或是 实质上是final的 即没有别修改
     * @param tempValue
     */
    public void print(Temp tempValue) {
        int counter = 0;
        // 使用 数组避免final不可变的问题
//        final int[] counter = new int[1];

        Date[] dates = new Date[5];
        for (int i = 0; i < dates.length; i++) {
            // 匿名内部类：继承自Date，并重写了compareTo方法
            dates[i] = new Date() {
                @Override
                public int compareTo(Date other) {
                    System.out.println("-------counter-----");
                    System.out.println(counter);

//                    System.out.println("-------counter数组方式-----");
//                    counter[0]++;

//                    System.out.println("-------tempValue-----");
//                    System.out.println(tempValue.tempValue);

                    return super.compareTo(other);
                }
            };
        }
        Arrays.sort(dates);
//        System.out.println(counter[0] + " comparisons.");
    }
}

class Temp {
    public int tempValue;
    public Temp(int value) {
        this.tempValue = value;
    }
}