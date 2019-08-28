package abstractFactory;

/**
 * 枪的实现类之一：AK
 * 具体产品类
 */
public class AK implements Gun {

    @Override
    public void shooting() {
        System.out.println("使用AK进行射击");
    }
}
