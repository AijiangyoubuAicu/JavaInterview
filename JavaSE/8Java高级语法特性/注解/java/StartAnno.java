import com.aijiang.ClassDemo.Dog;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotation {
    /**
     * 定义了两个属性，在使用时应进行赋值
     * @return
     */
    int id();
    String msg();

    /**
     * 定义两个默认值属性
     * @return
     */
    int uid() default -1;
    String msz() default "Hi World";
}

@Retention(RetentionPolicy.RUNTIME)
@interface Check {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Perform {
}

@TestAnnotation(id = 3, msg = "hello")
public class StartAnno {

    @Check(value = "hi")
    int a;

    @Perform
    public void testMethod() {

    }

    @SuppressWarnings("deprecation")
    public void test1() {
        Dog dog = new Dog();
        dog.run();
        dog.toString();
    }

    public static void main(String[] args) {
        boolean Annotation = StartAnno.class.isAnnotationPresent(TestAnnotation.class);

        if (Annotation) {
            TestAnnotation test = StartAnno.class.getAnnotation(TestAnnotation.class);
            // 获取类的注解的成员属性
            System.out.println("id：" + test.id());      // id：3
            System.out.println("msg：" + test.msg());    // msg：hello
            System.out.println("uid：" + test.uid());    // uid：-1
            System.out.println("msz：" + test.msz());    // msz：Hi World
        }

        try {
            // 获取一个成员变量上的注解
            Field f = StartAnno.class.getDeclaredField("a");
            f.setAccessible(true);
            Check check = f.getAnnotation(Check.class);
            if (check != null) {

                System.out.println("成员变量a上的注解@Check的值为" + check.value());
                // 成员变量a上的注解@Check的值为hi
            }

            // 获取方法中的注解的值
            Method method = StartAnno.class.getDeclaredMethod("testMethod()");
            if (method != null) {
                Annotation[] ans = method.getAnnotations();
                for( int i = 0;i < ans.length;i++) {
                    System.out.println("成员方法test1的注解的值为："+ans[i].annotationType().getSimpleName());
                }
            }

        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}