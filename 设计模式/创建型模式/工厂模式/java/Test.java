
public class Test {
    public static void main(String[] args) {
        Factory circleFactory = new CircleFactory();
        Shape circle = circleFactory.getShape();
        circle.draw();
    }
}
