import com.aijiang.ClassDemo.Outter;

public class TestClass {
    public static void main(String[] args) {
        Class clz = Outter.Inner.class;

        System.out.println("内部类的类名：" + clz.getName());  // 内部类的类名：com.aijiang.ClassDemo.Outter$Inner
        System.out.println("内部类的简单类名：" + clz.getSimpleName());  // 内部类的简单类名：Inner
        System.out.println("内部类的官方类名：" + clz.getCanonicalName());   // 内部类的官方类名：com.aijiang.ClassDemo.Outter.Inner
    }
}
