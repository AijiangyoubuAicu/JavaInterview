package abstractFactory;

/**
 * 枪的实现类之一：M4A1
 * 具体产品类
 */
public class M4A1 implements Gun {

    @Override
    public void shooting() {
        System.out.println("用M4A1进行射击");
    }
}
