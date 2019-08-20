
/**
 * 饿汉式(枚举方式)
 *
 * 这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。
 * 它更简洁，自动支持序列化机制，绝对防止多次实例化
 */
public class Enum {
    // 使用方式
    public static void main(String[] args) {
        Enum_Singleton uniqueInstance = Enum_Singleton.INSTANCE;
        uniqueInstance.doSomeThing();
    }
}

/**
 * 在枚举中我们明确了构造方法限制为私有，在我们访问枚举实例时会执行构造方法，
 * 同时每个枚举实例都是static final类型的，也就表明只能被实例化一次。
 *
 * 当枚举只有一个实例时，即可视为单例模式！
 *
 * 使用枚举来实现单实例控制会更加简洁，而且无偿地提供了序列化机制，
 * 并由JVM从根本上提供保障，绝对防止多次实例化，是更简洁、高效、安全的实现单例的方式。
 */
enum Enum_Singleton {
    // 定义一个枚举元素，它就是一个 Singleton 的一个实例
    INSTANCE;

    public void doSomeThing() {
        System.out.println("枚举简单的实现单例");
    }
}
