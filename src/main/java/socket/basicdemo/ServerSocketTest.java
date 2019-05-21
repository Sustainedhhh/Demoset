package socket.basicdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
        try {
            copyFiles("/Users/zgl/Downloads/record.txt",
                    "/Users/zgl/Downloads/copyRecord.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 简单的Server服务端实现
     * @throws IOException
     */
    public static void serverStart() throws IOException {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            System.out.println("Server has started.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            char[] temp = new char[20];
            int len = 0;
            while ((len = bufferedReader.read(temp)) != -1) {
                System.out.println(new String(temp, 0, len));
            }
    }

    /**
     * Using NIO to copy file.
     */
    public static void copyFiles(String srcFilePath, String dstFilePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(dstFilePath);

        FileChannel readChannel = fileInputStream.getChannel();
        FileChannel writeChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            buffer.clear();
            if (readChannel.read(buffer) == -1) {
                break;
            }
            // 将缓存区的游标置于0
            buffer.flip();
            writeChannel.write(buffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("Task has been finished.");
    }

    
    public static void nioTcpServerStart(int listenPort) throws IOException {
        Selector selector = Selector.open();

        // 实例化一个通道
        ServerSocketChannel listenChannel = ServerSocketChannel.open();

        // 将该通道的socket绑定到指定端口
        listenChannel.socket().bind(new InetSocketAddress(listenPort));

        // 配置信道非阻塞模式
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
