import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch=new CountDownLatch(5);
        LatchDemo latchDemo=new LatchDemo(countDownLatch);
        long start=System.currentTimeMillis();
        for(int i=0;i<5;i++){
            new Thread(latchDemo).start();
        }
        countDownLatch.await();
        long end=System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }

}

class LatchDemo implements Runnable{
    private CountDownLatch countDownLatch;
    public LatchDemo(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println("结果有："+i);
            }
        }
        countDownLatch.countDown();
    }
}
