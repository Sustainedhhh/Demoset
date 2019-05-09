package socket.basicdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket通信简单演示
 * Server端
 * @author : zgl
 * @date : 2019-05-09
 */
public class ServerSocketTest {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String str = bufferedReader.readLine();
            System.out.println(str);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
