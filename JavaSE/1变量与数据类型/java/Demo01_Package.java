/**
 * 包装类的方法测试
 */
public class Demo01_Package {
    public static void main(String[] args) {
        show01();
        show02();
        show03();

    }

    /**
     * 装箱机制：把基本类型的类型，包装到包装类中(基本类型 --> 包装类)
     */
    private static void show01() {
        /**
         * 构造方法一
         *
         * - Integer(int value) 构造一个新分配的 Integer 对象，它表示指定的 int 值
         * - Integer(String s) 构造一个新分配的 Integer 对象，它表示 String 参数所指示的 int 值
         *
         * 注意：这两个构造方法已过时，不推荐使用；
         */
        Integer in1 = new Integer(1);
        System.out.println(in1);
        Integer in2 = new Integer("1");
        System.out.println(in2);

        /**
         * 静态方法
         *
         * - static Integer valueOf(int i) 返回一个表示指定的 int 值的 Integer 实例
         * - static Integer valueOf(String s) 返回保存指定的 String 的值的 Integer 对象
         */
        Integer in3 = Integer.valueOf(1);
        System.out.println(in3);
        Integer in4 = Integer.valueOf("1");
        System.out.println(in4);
    }

    /**
     * 拆箱机制：在包装类中取出基本类型的数据(包装类 --> 基本类型)
     */
    private static void show02() {
        /**
         *  int intValue() 以 int 类型返回该 Integer 的值
         */
        Integer in1 = new Integer(1);
        int i = in1.intValue();
        System.out.println(i);
    }

    /**
     * 基本类型与字符串之间的转换
     *
     * 所有包装类型都有 parseXXX(String str) 方法将字符串参数转换为对应的基本类型
     */
    private static void show03() {
        int num = Integer.parseInt("100");
        System.out.println(num);    // 100
    }
}
