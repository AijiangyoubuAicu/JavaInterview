public class Demo01_Operation {

    public static void main(String[] args) {
        operation01();
        operation02();
        operation03();
        operation04();
        operation05();
        operation06();
        operation07();
        operation08();
        operation09();
        operation10();
    }

    /**
     * 在JAVA中，整数使用算术运算符，无论怎么计算也不会得到小数
     */
    private static void operation01() {
       int i = 1234;
       System.out.println(i / 1000 * 1000); // 1000
    }

    /**
     * 变量前++
     */
    private static void operation02() {
        int a = 1;
        int b = ++a; // 等效于 int b = a + 1;
        System.out.println(a);  // 2
        System.out.println(b);  // 2
    }

    /**
     * 变量后++
     */
    private static void operation03() {
        int a = 1;
        int b = a++;    // 等效于 int b = a;
                        // a++;
        System.out.println(a);  // 2
        System.out.println(b);  // 1
        System.out.println(b);  // 1
    }

    /**
     * + 符号在字符串中的拼接的操作
     */
    private static void operation04() {
        System.out.println("5 + 5 = " + 5 + 5); // 5 + 5 = 55
    }

    /**
     * 赋值运算符操作
     */
    private static void  operation05() {
        int i = 5;
        i += 5;     // 计算方式：i = i + 5;变量i先加5，再赋值变量i
        System.out.println(i);  // 输出结果是10
    }

    /**
     * 比较运算符
     */
    private static void operation06() {
        System.out.println(1 == 1);     // true
        System.out.println(1 < 2);      // true
        System.out.println(3 > 4);      // false
        System.out.println(3 <= 4);     // true
        System.out.println(3 >= 4);     // false
        System.out.println(3 != 4);     // true
    }

    /**
     * 逻辑运算符
     */
    private static void operation07() {
        System.out.println(true && true);   // true
        System.out.println(true && false);  // false
        System.out.println(false && true);  // false

        System.out.println(false || false); // false
        System.out.println(false || true);  // true
        System.out.println(true || false);  // true

        System.out.println(!false);         // true
    }

    /**
     * 三元运算符
     */
    private static void operation08() {
        int i = (1 == 2 ? 100 : 200);   // 200
        System.out.println(i);
        int j = (3 <= 4 ? 500 : 600);   // 500
        System.out.println(j);
    }

    /**
     * += 符号的扩展
     *
     * s += 1 逻辑上看作是 s = s + 1 计算结果被提升为int类型，再向short类型赋值时发生错误，因为不能将取值范围
     * 大的类型赋值到取值范围小的类型。但是， s=s+1进行两次运算 ， += 是一个运算符，只运算一次，并带有强制转换的特点，
     * 也就是说 s += 1 就是 s = (short)(s + 1) ，因此程序没有问题编译通过，运行结果是2
     */
    private static void operation09() {
        short s = 1;
        s += 1;     // 等效于 s = (short) (s + 1);
        System.out.println(s);  // 2
    }

    /**
     * 常量与变量的运算
     */
    private static void operation10() {
        byte b1 = 1;
        byte b2 = 2;
        /**
         * b3 = 1 + 2 ， 1 和 2 是常量，为固定不变的数据，在编译的时候（编译器javac），
         * 已经确定了 1+2 的结果并没有超过byte类型的取值范围，可以赋值给变量 b3 ，
         * 因此 b3=1 + 2 是正确的。
         */
        byte b3 = 1 + 2;
        /**
         * 反之， b4 = b2 + b3 ， b2 和 b3 是变量，变量的值是可能变化的，
         * 在编译的时候，编译器javac不确定b2+b3的结果是什么，
         * 因此会将结果以int类型进行处理，所以int类型不能赋值给byte类型，因此编译失败。
         */
        byte b4 = (byte) (b2 + b3);
        System.out.println(b3);
        System.out.println(b4);
    }

}
