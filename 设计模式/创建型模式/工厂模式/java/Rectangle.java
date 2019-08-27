/**
 * 长方形
 * 具体产品角色之一
 */
public class Rectangle implements Shape {

    public Rectangle() {
        System.out.println("长方形");
    }

    @Override
    public void draw() {
        System.out.println("画了一个长方形");
    }
}
