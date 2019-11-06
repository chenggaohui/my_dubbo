import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 分叉/合并练习
 * 工作窃取模式
 */
public class TestForkJoinPool {
    public static void main(String[] args) {
        ForkJoinPool pool=new ForkJoinPool();
        long start=System.currentTimeMillis();
        ForkJoinSum fj=new ForkJoinSum(0L,100000000000L);
        Long result = pool.invoke(fj);
        System.out.println(result);
        long end=System.currentTimeMillis();
        System.out.println("耗时："+(end-start)); //48171
    }

    /*
    JAVA 8 特性实现分叉合并
     */
    @Test
    public void test(){
        Instant start=Instant.now();
        long sum= LongStream.rangeClosed(0L,100000000000L).parallel().reduce(0L,Long::sum);
        Instant end=Instant.now();
        System.out.println(sum);
        System.out.println("耗时："+ Duration.between(start,end).toMillis());
    }
}


class ForkJoinSum extends RecursiveTask<Long>{

    private static final long serialVersionUID = 1966058823852589660L;
    long start;
    long end;
    private static final long THURSHOULD=10000L;
    ForkJoinSum(long start,long end){
        this.start=start;
        this.end=end;
    }

    @Override
    protected Long compute() {
        long length=end-start;
        if (length<=THURSHOULD){
            long sum=0L;
            for (long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{
            long temp=(start+end)/2;
            ForkJoinSum result1 = new ForkJoinSum(start, temp);
            result1.fork(); //进行拆分
            ForkJoinSum result2 = new ForkJoinSum(temp+1, end);
            result2.fork();//进行拆分
            return result1.join()+result2.join(); //结果进行合并
        }

    }
}