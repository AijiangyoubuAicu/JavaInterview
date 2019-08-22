class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+ " " + i);
        }
    }
}

public class Demo01_Runnable {
    public static void main(String[] args){
        // 创建自定义线程任务对象
        MyRunnable mr = new MyRunnable();
        // 创建线程对象
        Thread t = new Thread(mr);
        t.start();
        for (int i =0; i < 20; i ++) {
            System.out.println("main():" + i);
        }
    }
}