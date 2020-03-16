//import java.util.Random;
//import java.util.concurrent.*;
//
///**
// * 定时执行任务的线程池
// * newScheduledThreadPool
// */
//public class TestScheduledThreadPool {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ScheduledExecutorService pool= Executors.newScheduledThreadPool(5);
//        for (int i=0;i<10;i++){
//            Future<Integer> result = pool.schedule(new Callable<Integer>() {
//
//                @Override
//                public Integer call() throws Exception {
//                    int i = new Random().nextInt(100);
//                    System.out.println(Thread.currentThread().getName() + ":" + i);
//                    return i;
//                }
//            }, 1, TimeUnit.SECONDS);
//            System.out.println(result.get());
//        }
//        pool.shutdown();
//    }
//}
