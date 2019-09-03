public class Question15 {
    public static void main(String[] args) {
        class A {
            public int i = 3;
        }
        Object o = (Object)new A();
        A a = (A)o;
        System.out.println("i = " + a.i);
    }
}
