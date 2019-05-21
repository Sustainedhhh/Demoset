package io;

import java.io.*;

/**
 * 用来学习使用JAVA操作文件
 *
 * @author : zgl
 * @date : 2019-05-14
 */
public class FileIOTest {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        writeFileTest();
        readFileTest();
    }

    public static void writeFileTest() throws FileNotFoundException, IOException {
        // 此时的file并未关联真正的文件对象
        File file = new File("/Users/zgl/Downloads/record.txt");

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write("s".getBytes());
        fileOutputStream.write('g');
        fileOutputStream.write('l');

        //使用完毕需要及时关闭流
        fileOutputStream.close();
    }

    public static void readFileTest() throws FileNotFoundException, IOException{
        File file = new File("/Users/zgl/Downloads/record.txt");

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] res = new byte[2];


        // 循环读取文件内容的方式1：
//        for (int i = 0; i < file.length(); i++) {
//            System.out.print((char)fileInputStream.read());
//        }

        // 循环读取文件内容的方式2：
        int index = 0;
        while ((index = fileInputStream.read(res)) != -1) {
            System.out.print(new String(res, 0, index));
        }
    }
}
