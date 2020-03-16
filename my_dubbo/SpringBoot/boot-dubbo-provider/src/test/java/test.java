//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.MappedByteBuffer;
//import java.nio.channels.FileChannel;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.List;
//
///**
// * NIO练习
// */
//public class test {
//    public static void main(String[] args) throws IOException {
//
//        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
//        byteBuffer.put("ABC".getBytes());
//        System.out.println("~~~~~~~~~初始~~~~~~~~~~~");
//        System.out.println("mark:"+byteBuffer.mark());
//        System.out.println("position:"+byteBuffer.position());
//        System.out.println("limit:"+byteBuffer.limit());
//        byteBuffer.clear();
//        byteBuffer.put("G".getBytes());
//        System.out.println("~~~~~~~~~compact~~~~~~~~~~~");
//        System.out.println("mark:"+byteBuffer.mark());
//        System.out.println("position:"+byteBuffer.position());
//        System.out.println("limit:"+byteBuffer.limit());
//
////        test02();
//
//
//    }
//
//    private static void test01() throws IOException {
//        long start = System.currentTimeMillis();
//
//        FileChannel inChannel = FileChannel.open(Paths.get("E:\\Chrome\\ideaIU-2019.2.3.exe"), StandardOpenOption.READ);
//        FileChannel outChannel = FileChannel.open(Paths.get("F:\\temp\\ideaIU-2019.2.3.exe"), StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
//
//        //内存映射文件
//        MappedByteBuffer inBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
//        MappedByteBuffer outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
//
//        byte[] bytes = new byte[inBuffer.limit()];
//        System.out.println("缓冲区大小:" + inBuffer.limit());
//        inBuffer.get(bytes);
//        outBuffer.put(bytes);
//
//        inChannel.close();
//        outChannel.close();
//        long end = System.currentTimeMillis();
//        System.out.println("耗时：" + (end - start));   //缓冲区大小:706680656
//        //耗时：49666
//    }
//
//    public static void test02() throws IOException {
//        long start = System.currentTimeMillis();
//
//        FileChannel inChannel = FileChannel.open(Paths.get("E:\\Chrome\\ideaIU-2019.2.3.exe"), StandardOpenOption.READ);
//        FileChannel outChannel = FileChannel.open(Paths.get("F:\\temp\\ideaIU-2019.2.3.exe"), StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
//
//        inChannel.transferTo(0,inChannel.size(),outChannel);
//
//        inChannel.close();
//        outChannel.close();
//        long end = System.currentTimeMillis();
//        System.out.println("耗时：" + (end - start));
//
//    }
//
//}
