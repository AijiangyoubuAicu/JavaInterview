package abstractFactory;

/**
 * 抽象工厂接口
 * 它拥有一套产品的方法
 */
public interface Factory {
    Gun produceGun();
    Bullet produceBullet();
}
