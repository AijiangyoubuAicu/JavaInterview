package factory;

/**
 * 圆形工厂类
 * 具体工厂角色之一
 */
public class CircleFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Circle();
    }
}
