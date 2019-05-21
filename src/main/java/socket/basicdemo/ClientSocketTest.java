package socket.basicdemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Socket通信简单演示
 * Client端
 * @author : zgl
 * @date : 2019-05-09
 */
public class ClientSocketTest {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",9999);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            String str = "第一个Socket";
            bufferedWriter.write(str);
            bufferedWriter.flush();
//            关闭Client端的输出流
            socket.shutdownOutput();
        } catch(IOException e) {
            e.printStackTrace();

        }
    }
}
