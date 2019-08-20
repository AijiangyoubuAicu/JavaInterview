
/**
 * 懒汉式(非线程安全和Synchronized关键字的线程安全版本)
 *
 * 即单例在第一次被使用时创建，而不是JVM在加载这个类时就马上创建唯一的单例
 */
public class Lazy {
    // 私有化静态一个类类型变量，且不同于饿汉式提前实例化
    private static Lazy uniqueInstance;
    // 私有化构造器
    private Lazy(){

    }
    // 对外提供的全局访问点
    public static Lazy getInstance() {
        // 如果该对象未被实例化，那么在第一次调用该方法时就会被创建
        if (uniqueInstance == null) {
            uniqueInstance = new Lazy();
        }
        return uniqueInstance;
    }
}

/**
 * synchronized关键字线程安全版本
 *
 * 在程序中每次使用getInstance() 都要经过synchronized加锁这一层，
 * 这难免会增加getInstance()的方法的时间消费，而且还可能会发生阻塞。
 *
 * 还有"双重检查加锁版本"就是为了解决这个问题而存在的。
 */
class Lazy_Synchronized {
    private static Lazy_Synchronized uniqueInstance;
    private Lazy_Synchronized() {
    }
    // synchronized加锁该方法，使其同步运行
    public static synchronized Lazy_Synchronized getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Lazy_Synchronized();
        }
        return uniqueInstance;
    }
}

/**
 * 双重检查加锁版本
 *
 * 利用双重检查加锁（double-checked locking），首先检查是否实例已经创建，
 * 如果尚未创建，“才”进行同步。这样以来，只有一次同步，这正是我们想要的效果。
 */
class Lazy_double_Synchronized {
    // //volatile保证，当uniqueInstance变量被初始化成Singleton实例时，多个线程可以正确处理uniqueInstance变量
    private volatile static Lazy_double_Synchronized uniqueInstance;
    // 私有化构造器
    private Lazy_double_Synchronized() {

    }
    // 对外提供的全局访问点
    public static Lazy_double_Synchronized getInstance() {
        // 检查实例是否已存在
        if (uniqueInstance == null) {
            // 只有第一次才彻底执行此处代码
            synchronized (Lazy_double_Synchronized.class) {
                // 进入同步代码块后，再检查一次，如果仍是null才实例
                if (uniqueInstance == null) {
                    uniqueInstance = new Lazy_double_Synchronized();
                }
            }
        }
        return uniqueInstance;
    }
}