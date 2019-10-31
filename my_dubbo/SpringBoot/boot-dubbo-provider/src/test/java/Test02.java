import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test02 {
    @Test
    public void test01() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8989));
        FileChannel fileChannel = FileChannel.open(Paths.get("F:\\temp\\car.jpg"), StandardOpenOption.READ);
        System.out.println(Paths.get("F:\\temp\\car.jpg"));
        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = -1;
        while ((len = fileChannel.read(byteBuffer)) != -1) {
            //切换到读模式
            byteBuffer.flip();
            socketChannel.write(byteBuffer);


            byteBuffer.clear();
        }
        System.out.println("发送完成！！！！！");
        fileChannel.close();
        socketChannel.close();
    }

    @Test
    public void test02() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel fileChannel = FileChannel.open(Paths.get("newCar.jpg"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        serverSocketChannel.bind(new InetSocketAddress(8989));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("开始接受数据：");
        int len = -1;
        while ((len = socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        System.out.println("数据接收完成");
        serverSocketChannel.close();
        fileChannel.close();

    }
}
