/**
 * 自动类型转换
 */
public class Demo01_BasicDataType {

    public static void main(String[] args) {
    }

    /**
     * 自动类型转换情况一
     *
     * 字面量默认转换
     */
    private static void show03() {
        // 整数，默认是 int 类型
        System.out.println(1024);
        // 浮点数，默认是 double 类型
        System.out.println(3.14);
    }

    /**
     * 自动类型转换情况二
     *
     * 字面量与类型间的转换
     */
    private static void show04() {
        // 右边是 int 类型，左边是 long 类型
        long num1 = 100;
        // int ---> long
        System.out.println(num1);
        int i = 1;
        double d = 2.5;
        double e = i + d;
        System.out.println(e);      // 3.5
        // 右边是 float 类型，左边是 double 类型
        double num2 = 2.5F;
        // float ---> long
        System.out.println(num2);
    }

    /**
     * 自动类型转换情况三
     *
     * float --> long
     */
    private static void show05() {
        float num3 = 30L;
        System.out.println(num3); // 30.0
    }

    /**
     * 自动类型转换情况四
     *
     * byte、short、char类型之间的计算
     *
     * 以下情况计算完成均会转换成 int 类型
     */
    private static void show06() {
        int i = 1;
        byte b = 2;
//        byte x = b + i;   // 编译期报错
        int j = b + i;
        System.out.println(j);      // 3
    }

    /**
     * 自动类型转换情况五
     *
     * char 类型字符型变量视为数值计算
     */
    private static void show07() {
        char c1 = 'A';
        System.out.println(c1 + 1); // 66
    }
}
