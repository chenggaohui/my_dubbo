import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 普通线程池练习
 * newFixedThreadPool固定大小的线程池
 * newSingleThreadExecutor只有一个线程的线程池
 * newCachedThreadPool无限大小的线程池
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolDemo td=new ThreadPoolDemo();
        ExecutorService pool= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            pool.submit(td);
        }
        pool.shutdown();
    }
}
class ThreadPoolDemo implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+(int)(Math.random()*101));
    }
}