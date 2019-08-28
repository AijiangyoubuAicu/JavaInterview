package abstractFactory;

/**
 * 具体生产AK及其子弹的工厂
 */
public class AKFactory implements Factory {

    @Override
    public Gun produceGun() {
        return new AK();
    }

    @Override
    public Bullet produceBullet() {
        return new AK_Bullet();
    }
}
