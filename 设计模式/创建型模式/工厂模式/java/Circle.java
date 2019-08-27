/**
 * 圆形
 * 具体产品角色之一
 */
public class Circle implements Shape {

    public Circle() {
        System.out.println("圆形");
    }

    @Override
    public void draw() {
        System.out.println("画一个圆");
    }
}
