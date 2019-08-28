package abstractFactory;

/**
 * 子弹的具体实现类之一：AK的子弹
 * 具体产品
 */
public class AK_Bullet implements Bullet {

    @Override
    public void load() {
        System.out.println("装填子弹进AK中");
    }

}
