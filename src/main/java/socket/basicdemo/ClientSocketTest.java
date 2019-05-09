package socket.basicdemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Socket通信简单演示
 * Client端
 * @author : zgl
 * @date : 2019-05-09
 */
public class ClientSocketTest {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String str = "第一个Socket";
            bufferedWriter.write(str);
        } catch(IOException e) {
            e.printStackTrace();

        }
    }
}
