import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试
 */
public class Demo01_ThreadPool {
    public static void main(String[] args) {
        // 创建线程池对象，并设置线程池容量
        ExecutorService service = Executors.newFixedThreadPool(2);
        // 创建 Runnable 实例对象
        SwimTrainee trainee = new SwimTrainee();

        // 从线程池中获取线程对象，然后调用 SwimTrainee 中的 run()
        service.submit(trainee);
        // 再获取一个线程对象，调用 SwimTrainee 的 run()
        service.submit(trainee);
        service.submit(trainee);

        /**
         * 注意：submit()方法调用完后，程序并不终止，这是因为线程池控制了线程的关闭
         * 将使用完的线程又归还到了线程池中
         */

        // 关闭线程池，但一般不关闭
        // service.shutdown();
    }
}

/**
 * 实现 Runnable 接口的游泳学员 SwimTrainee 自定义线程对象
 */
class SwimTrainee implements Runnable {

    @Override
    public void run() {
        System.out.println("我要一个教练");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("教练来了：" + Thread.currentThread().getName());
        System.out.println("教完我游泳了，教练回到了游泳池");
    }
}
