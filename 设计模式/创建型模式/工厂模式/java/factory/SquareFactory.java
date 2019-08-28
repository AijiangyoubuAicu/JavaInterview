package factory;

/**
 * 正方形工厂类
 * 具体工厂角色之一
 */
public class SquareFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Square();
    }
}
