package abstractFactory;

/**
 * 子弹的实现类之一：M4A1的子弹
 * 具体产品类
 */
public class MA41_Bullet implements Bullet {

    @Override
    public void load() {
        System.out.println("装填子弹进M4A1中");
    }

}
