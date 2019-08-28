package abstractFactory;

public class Test {
    public static void main(String[] args) {
        /**
         * 通过AK工厂我们可以得到一套产品
         */
        Factory factory = new AKFactory();
        Gun ak = factory.produceGun();
        Bullet ak_bullet = factory.produceBullet();
        ak.shooting();
        ak_bullet.load();

        /**
         * 另一个工厂生产的来一套产品
         */
        Factory factory1 = new M4A1Factory();
        Gun m4a1 = factory1.produceGun();
        Bullet m4a1_bullet = factory.produceBullet();
        m4a1.shooting();
        m4a1_bullet.load();

    }
}
