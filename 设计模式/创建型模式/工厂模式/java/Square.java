/**
 * 正方形
 * 具体产品角色之一
 */
public class Square implements Shape {

    public Square() {
        System.out.println("正方形");
    }

    @Override
    public void draw() {
        System.out.println("画了一个正方形");
    }
}
