/**
 * 多线程的测试
 */
public class Demo01_Thread {
    public static void main(String[] args) {
        // 创建自定义的线程对象并设置线程名
        MyThread my = new MyThread("自定义的线程的子类");
        // 开启自定义的线程
        my.start();
        // 在主方法中执行同样的 for 循环，以观察并行运行
        for (int i = 0; i < 10; i++) {
            System.out.println("main()主线程：正在执行中！" + i);
        }

        /*
        执行结果：
            自定义的线程的子类：正在执行中！0
            自定义的线程的子类：正在执行中！1
            自定义的线程的子类：正在执行中！2
            自定义的线程的子类：正在执行中！3
            自定义的线程的子类：正在执行中！4
            自定义的线程的子类：正在执行中！5
            自定义的线程的子类：正在执行中！6
            自定义的线程的子类：正在执行中！7
            自定义的线程的子类：正在执行中！8
            自定义的线程的子类：正在执行中！9
            main()主线程：正在执行中！0
            main()主线程：正在执行中！1
            main()主线程：正在执行中！2
            main()主线程：正在执行中！3
            main()主线程：正在执行中！4
            main()主线程：正在执行中！5
            main()主线程：正在执行中！6
            main()主线程：正在执行中！7
            main()主线程：正在执行中！8
            main()主线程：正在执行中！9
         */
    }
}

/**
 * 自定义线程类
 * 即继承了 Thread 类的类即为多线程的子类
 */
class MyThread extends Thread {
    // 定义指定线程名称的构造方法
    public MyThread(String name) {
        // 调用超类的 String 参数的构造方法可以指定线程的名称
        super(name);
    }

    /**
     * 重写 run() 方法，完成该线程执行的逻辑
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "：正在执行中！" + i);
        }
    }
}