package factory;

/**
 * 长方形工厂类
 * 具体工厂角色之一
 */
public class RectangleFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
