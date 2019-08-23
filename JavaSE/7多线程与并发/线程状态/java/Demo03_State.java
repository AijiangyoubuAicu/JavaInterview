/**
 * 消费者与生产者问题
 *
 * 包子铺线程生产包子，吃货线程消费包子。当包子没有时（包子状态为false），吃货线程等待，包子铺线程生产包子
 * （即包子状态为true），并通知吃货线程（解除吃货的等待状态）,因为已经有包子了，那么包子铺线程进入等待状态。
 * 接下来，吃货线程能否进一步执行则取决于锁的获取情况。如果吃货获取到锁，那么就执行吃包子动作，包子吃完（包
 * 子状态为false），并通知包子铺线程（解除包子铺的等待状态）,吃货线程进入等待。包子铺线程能否进一步执行则取
 * 决于锁的获取情况。
 */
public class Demo03_State {
    public static void main(String[] args) {
        // 等待唤醒案例
        Bun bun = new Bun();

        Eater eater = new Eater("吃货：", bun);
        BunStore store = new BunStore("包子铺", bun);

        eater.start();
        store.start();
    }
}

/**
 * 包子类
 */
class Bun {
    // 包子皮
    String skin;
    // 包子馅
    String filling;
    // 包子资源标记；是-存在，否-不存在
    boolean flag = false;
}

/**
 * 吃货线程类
 */
class Eater extends Thread {

    private Bun bun;

    public Eater(String name, Bun bun) {
        // 调用 Thread 类的名称构造，设置线程名
        super(name);
        this.bun = bun;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bun) {
                // 没包子
                if (bun.flag == false) {
                    try {
                        // 等待包子中.....
                        bun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("吃货正在吃：" + bun.skin + bun.filling + "包子");
                bun.flag = false;
                bun.notify();
            }
        }
    }
}

/**
 * 包子铺线程类
 */
class BunStore extends Thread {

    private Bun bun;

    public BunStore(String name, Bun bun) {
        super(name);
        this.bun = bun;
    }

    @Override
    public void run() {

        int count = 0;

        // 制造包子
        while (true) {
            // 同步
            synchronized (bun) {
                if (bun.flag == true) {
                    try {
                        bun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 没有包子，造包子
                System.out.println("包子铺开始制作包子");
                if (count % 2 == 0) {
                    // 冰皮、叉烧
                    bun.skin = "冰皮";
                    bun.filling = "叉烧";
                } else {
                    // 薄皮、奶黄
                    bun.skin = "薄皮";
                    bun.filling = "奶黄";
                }
                count ++;

                bun.flag = true;
                System.out.println("包子制作好啦：" + bun.skin + bun.filling);
                System.out.println("吃货快来吃吧！");

                // 唤醒等待线程
                bun.notify();
            }
        }
    }
}