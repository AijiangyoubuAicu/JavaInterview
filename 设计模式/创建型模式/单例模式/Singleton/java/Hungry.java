
/**
 * 饿汉式创建方式
 *
 * 所谓饿汉式就是JVM在创建这个类时就会马上创建唯一的单例实例
 * 不管是否用上，先创建了再说；
 *
 * 如果一直未使用就会浪费空间，当每次都被调用时就不用再判断，可节省运行时间；
 */
public class Hungry {
    // 静态私有化先创建一个唯一的实例，该实例在程序启动时就会被创建该单例，且保证了线程安全
    private static Hungry uniqueInstance = new Hungry();
    // 私有化构造器，使其无法使用构造器new实例
    private Hungry(){

    }
    // 对外提供的全局访问点，返回唯一的实例
    public static Hungry getInstance() {
        return uniqueInstance;
    }
}
