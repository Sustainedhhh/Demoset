package socket.basicdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * Socket通信简单演示
 * Server端
 * @author : zgl
 * @date : 2019-05-09
 */
public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        serverStart();


    }

    /**
     * 简单的Server服务端实现
     * @throws IOException
     */
    public static void serverStart() throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String str = bufferedReader.readLine();
        System.out.println(str);
    }

    public static void nioServerStart(int listenPort) throws IOException {

        Selector selector = Selector.open();

        // 实例化一个通道
        ServerSocketChannel listenChannel = ServerSocketChannel.open();

        // 为通道绑定端口
        listenChannel.socket().bind(new InetSocketAddress(listenPort));

        //  配置信道为非阻塞模式
        listenChannel.configureBlocking(false);

        // 注册到各通道至选择器
        listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // select() 返回准备就绪的通道数量
            if (selector.select(3000) == 0) {
                // 等待信道准备的同时，可以异步执行其他任务
                continue;
            }

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {

                }

                // 手动剔除当前key
                keyIterator.remove();
            }

        }

    }
}
