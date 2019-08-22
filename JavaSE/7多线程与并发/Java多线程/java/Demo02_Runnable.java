public class Demo02_Runnable {
    public static void main(String[] args) {
        // 通过匿名内部类实现自定义线程任务对象
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("Runnable：" + i);
                }
            }
        };

        // 传入自定义线程任务对象
        new Thread(r).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main()：" + i);
        }
    }
}
