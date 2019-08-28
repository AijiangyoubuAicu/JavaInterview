package abstractFactory;

/**
 * 具体生产M4A1及其子弹的工厂
 */
public class M4A1Factory implements Factory {
    @Override
    public Gun produceGun() {
        return new M4A1();
    }

    @Override
    public Bullet produceBullet() {
        return new MA41_Bullet();
    }
}
