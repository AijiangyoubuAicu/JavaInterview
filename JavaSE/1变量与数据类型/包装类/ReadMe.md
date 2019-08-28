# 包装类

### 概述

Java提供了两个类型系统，基本类型与引用类型，使用基本类型在于效率，然而很多情况，会创建对象使用，因为对象可以做更多的功能，如果想要我们的基本类型像对象一样操作，就可以使用基本类型对应的包装类，如下：

| 基本类型    | 对应的包装类（位于java.lang包中） |
| ------- | --------------------- |
| byte    | Byte                  |
| short   | Short                 |
| int     | **Integer**           |
| long    | Long                  |
| float   | Float                 |
| double  | Double                |
| char    | **Character**         |
| boolean | Boolean               |

### 装箱与拆箱

基本类型与对应的包装类对象之间，来回转换的过程称为”装箱“与”拆箱“：

* **装箱**：从基本类型转换为对应的包装类对象。

* **拆箱**：从包装类对象转换为对应的基本类型。

用Integer与 int为例：（看懂代码即可）

基本数值---->包装对象

```java
Integer i = new Integer(4); // 使用构造函数函数
Integer iii = Integer.valueOf(4); // 使用包装类中的valueOf方法
```

包装对象---->基本数值

```java
int num = i.intValue();
```
### 自动装箱与自动拆箱

由于我们经常要做基本类型与包装类之间的转换，从Java 5（JDK 1.5）开始，基本类型与包装类的装箱、拆箱动作可以自动完成。例如：

```java
Integer i = 4; // 自动装箱。相当于Integer i = Integer.valueOf(4);
i = i + 5; // 等号右边：将i对象转成基本数值(自动拆箱) i.intValue() + 5;
// 加法运算完成后，再次装箱，把基本数值转成对象。
```

### 基本类型与字符串之间的转换

基本类型转换String总共有三种方式，查看课后资料可以得知，这里只讲最简单的一种方式： 

基本类型直接与`””`相连接即可，如：`34+""`

String转换成对应的基本类型 

除了`Character`类之外，其他所有包装类都具有`parseXxx`静态方法可以将字符串参数转换为对应的基本类型：

- `public static byte parseByte(String s)`：将字符串参数转换为对应的byte基本类型。
- `public static short parseShort(String s)`：将字符串参数转换为对应的short基本类型。
- `public static int parseInt(String s)`：将字符串参数转换为对应的int基本类型。
- `public static long parseLong(String s)`：将字符串参数转换为对应的long基本类型。
- `public static float parseFloat(String s)`：将字符串参数转换为对应的float基本类型。
- `public static double parseDouble(String s)`：将字符串参数转换为对应的double基本类型。
- `public static boolean parseBoolean(String s)`：将字符串参数转换为对应的boolean基本类型。

代码使用（仅以`Integer`类的静态方法`parseXxx`为例）如：

```java
public class Demo18WrapperParse {
    public static void main(String[] args) {
        int num = Integer.parseInt("100");
    }
}
```
> 注意:如果字符串参数的内容无法正确转换为对应的基本类型，则会抛出`java.lang.NumberFormatException`异常。
>

```java
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

```

------

[面试题](Interview.md)

[返回顶部](#变量与数据类型)

[返回上一页](../../KnowledgePoint.md)