import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * NIO练习
 */
public class TestNIO {

    public static void main(String[] args) throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("localhost", 9090));
        //切换到非阻塞模式
        sChannel.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = -1;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            byteBuffer.put((new Date().toString() + "说：" + str).getBytes());
            byteBuffer.flip();
            sChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        sChannel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //切换到非阻塞模式
        ssChannel.configureBlocking(false);
        ssChannel.bind(new InetSocketAddress(9090));

        //获取一个选择器
        Selector selector = Selector.open();
        //将serverSocketChannel注册到选择器中,并且监听连接事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //轮询选择器上已经(接收、连接、输入、输出)就绪的事件
        while (selector.select() > 0) {
            //获取上已经就绪的的选择键
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey sk = iterator.next();
                //如果是接收事件
                if (sk.isAcceptable()) {
                    SocketChannel sChnnel = ssChannel.accept();
                    //将socketChannel设置为非阻塞模式
                    sChnnel.configureBlocking(false);
                    //将接收完成的通道注册到选择器中，并监听读就绪事件
                    sChnnel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, len));
                        byteBuffer.clear();
                    }

                }
                //取消选择键
                iterator.remove();
            }

        }

    }
}
