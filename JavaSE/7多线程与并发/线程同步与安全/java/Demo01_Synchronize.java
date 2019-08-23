import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 电影院要卖票，模拟电影院的卖票过程。假设本次电影的座位共100个(本场电影只能卖100张票)；
 * 模拟电影院的售票窗口，实现多个窗口同时卖一场电影的电影票(多个窗口一起卖这100张票)
 * 需要窗口，采用线程对象来模拟；
 * 需要票，Runnable接口子类来模拟
 */
class Ticket implements Runnable {

    private int ticket = 100;

    /**
     * 执行卖票的操作
     */
    @Override
    public void run() {
        // 每个窗口卖票的操作且窗口永远开启
        while (true) {
            // 有票，可以卖
            if (ticket > 0) {
                // 出票操作，使用 sleep() 模拟出票时间
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 获取当前线程对象的名字
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖：" + ticket--);
            }
        }
    }
}

/**
 * 发现程序出现了两个问题：
 * 1. 会存在相同的票数被卖了两回！
 * 2. 不存在的票，比如0票与-1票，是不存在的！
 * 这种问题，几个窗口(线程)票数不同步了，这种问题称为线程不安全
 */
public class Demo01_Synchronize extends Thread {
    public static void main(String[] args) {
        // 创建线程任务对象
        Ticket ticket = new Ticket();
        // 创建三个窗口对象
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");

        // 同时卖
        t1.start();
        t2.start();
        t3.start();

    }
}

