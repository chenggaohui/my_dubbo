//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * Lock锁练习
// */
//public class TestLock {
//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch=new CountDownLatch(5);
//        Ticket ticket=new Ticket(countDownLatch);
//        long start=System.currentTimeMillis();
//        new Thread(ticket,"1号窗口").start();
//        new Thread(ticket,"2号窗口").start();
//        new Thread(ticket,"3号窗口").start();
//        new Thread(ticket,"4号窗口").start();
//        new Thread(ticket,"5号窗口").start();
//        countDownLatch.await();
//        long end=System.currentTimeMillis();
//        System.out.println("买票耗时："+(end-start));
//
//    }
//}
//class Ticket implements Runnable{
//    public CountDownLatch countDownLatch;
//    public Ticket(CountDownLatch countDownLatch){
//        this.countDownLatch=countDownLatch;
//    }
//    public Lock lock=new ReentrantLock();
//
//    private int i=1000000;
//    @Override
//    public void run() {
//        lock.lock();
//        while(i>0){
//
//            System.out.println(Thread.currentThread().getName()+"完成买票！剩余票数："+ --i);
//
//        }
//        lock.unlock();
//        countDownLatch.countDown();
//    }
//}
