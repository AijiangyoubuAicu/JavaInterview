/**
 * 自动类型转换
 */
public class Demo01_BasicDataType {

    public static void main(String[] args) {
        show01();
        show02();
    }

    /**
     * byte类型转换为int类型
     */
    private static void show01() {
        int i = 1;
        byte b = 2;
//        byte x = b + i;   // 编译期报错
        int j = b + i;
        System.out.println(j);      // 3

    }

    /**
     * int类型转换为double类型
     */
    private static void show02() {
        int i = 1;
        double d = 2.5;
        double e = i + d;
        System.out.println(e);      // 3.5
    }


}
