public class String_ConstantPool01 {

    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
//        test04();
        test05();
    }

    /**
     * 第一种情况
     *
     * 字符串常量池直接存储
     *
     * JVM中提供了一个字符串常量池保存着许多的 String 对象
     * 里边的 String 对象可以被同一线程下的程序共享以提高效率
     * 由于 String 是不可变类(final)，它的值一经创建就不可更改
     */
    private static void test01() {
        // 在字符串常量池里创建一个对象
        String s1 = "abc";
        String s2 = "abc";
        // "==" 号表示指向着的地址值是否相等
        System.out.println("s1 == s2：" + (s1 == s2));  // s1 == s2 ：true
        // String 重写了 toString() 方法，equals()方法用来比较内容的相等性
        System.out.println("s1.equals(s2)：" + (s1.equals(s2))); // s1.equals(s2) ：true
    }

    /**
     * 第二种情况
     *
     * 关于 new String("")
     *
     * 第一次使用 new String("") 时会创建两个对象，它们分别会存方法在字符串常量池和堆内存中
     * 第二次创建相同的 new String("")那么会先从字符串常量池中寻找，如果存在则返回并且只会在堆内存创建一个对象
     */
    private static void test02() {
        String s1 = "abc";
        // 实例化一个字符串
        String s2 = new String("abc");
        String s3 = new String("abc");
        /**
         * 说明"=="号比较两个字符串时，堆内存的比较优先级较高
         */
        // 比较堆内存的地址值，s1 没有在堆内存中存在内存，s2 有
        System.out.println("s1 == s2：" + (s1 == s2));  // s1 == s2 ：false
        // s2 与 s3 是通过 new 关键字，new 关键字都会在堆内存中开辟内存
        System.out.println("s2 == s3：" + (s2 == s3));  // s1 == s2 ：false
        // String 重写了 toString() 方法，equals()方法用来比较内容的相等性
        System.out.println("s1.equals(s2) ：" + (s1.equals(s2))); // s1.equals(s2) ：true
    }

    /**
     * 第三种情况
     *
     * 关于使用"+"号拼接字符串
     *
     * 使用"+"号拼接字符串时，它会在编译期就会被确定
     * 上述第一种与第二种情况的分析建立在运行期之上
     */
    private static void test03() {
        // 该拼接字符串处理在编译期就会编译为 String s1 = "abc"
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println("s1 == s2：" + (s1 == s2));  // s1 == s2 ：true
    }

    /**
     * 第四种情况
     *
     * 关于使用"+"号拼接字符串变量
     *
     * 当两个字符串变量相加时，在运行期JVM会创建一个 StringBuilder 对象并将其赋值给
     * 第一个变量(s1)，然后使用其.append()的方法相连第二个变量(s2)
     *
     * 注意：该过程内存中存在了五个对象(s1、s2、StringBuilder(s1)、String(s2)、s4)
     */
    private static void test04() {
        String s1 = "ab";
        String s2 = "cd";
        // 等效于 String s3 = new StringBuilder(s1).append(new String(s2)).toString();
        String s3 = s1 + s2;
        String s4 = "abcd";
        System.out.println("s3 == s4：" + (s3 == s4));   // s3 == s4 ：false
    }

    /**
     * 第五种情况
     *
     * 关于使用"+"号拼接字符串常量和字符串变量
     *
     * 直接与变量用"+"拼接会导致运行期在堆内存中创建一个新的对象
     * 当如果该变量存储的是一个"常量"，那么它会在编译期得到解析并拼接
     */
    private static void test05() {
        // 常量
        final String S1 = "a";
        // 变量
        String s2 = "bc";
        // 字符串 + 变量
        String s3 = "a" + s2;
        // 字符串 + 常量
        String S3 = S1 + "bc";
        String s4 = "abc";
        System.out.println("s3 == s4：" + (s3 == s4));  // s3 == s4：false
        System.out.println("S3 == s4：" + (S3 == s4));  // S3 == s4：true
    }
}
