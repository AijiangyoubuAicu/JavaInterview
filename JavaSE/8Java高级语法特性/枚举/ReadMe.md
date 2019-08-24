# 枚举

## 概念

枚举Enumeration 

- 最简单的枚举：是一系列具有名称的**常量**
- 在JAVA中，枚举定义了一种**类类型**。通过将枚举定义为类，可具有构造函数、方法或实例变量

创建枚举需要关键字`enum`

定义一个最简单的枚举

```java
/**
 * 一个水果的枚举，列出了四种水果
 */
public enum Fruit {

    /**
     * 包含着"苹果"、"西瓜"、"梨"、"桃子"四个常量
     */
    APPLE, WATERMELON, PEAR, PEACH
}
```

"苹果"、"西瓜"、"梨"、"桃子"等这些**枚举元素**都被称为**枚举常量**；这些常量被称为**自类型化的
self-typed**，**自**是指封装常量的枚举，每个枚举常量被隐式声明为 Fruit
的**公有的**、**静态的**、**final的**成员

## 枚举的使用

定义了枚举之后，可以创建枚举类型的变量；不能使用**new**实例化枚举，枚举变量的声明和使用方式在许多方面与基本类型相同

```java
public class Demo {

    public static void main(String[] args) {
        // 定义一个枚举类型的变量
        FruitDemo fruit;
        // 可以赋值包含在 FruitDemo 枚举中定义的那些值并视为常量
        fruit = FruitDemo.APPLE;
        // 输出这个常量
        System.out.println("现在的水果是：" + fruit);  // 现在的水果是：APPLE

        /**
         * 可以使用 == 号比较其相等性
         */
        if (fruit == FruitDemo.PEACH) {
            System.out.println("这个变量现在是桃子");
        } else if (fruit == FruitDemo.APPLE) {
            System.out.println("这个变量现在是苹果");    // 这个变量现在是苹果
        }

        /**
         * 注意：枚举是类类型
         */
        if (fruit instanceof FruitDemo) {
            System.out.println("这个还是个类类型");
        }

    }
}
```

枚举值可以使用**switch**语句，所有 case 使用的常量的枚举类型，都必须与 switch
表达式使用的枚举类型相同 

> 枚举与常量一样，在第一次使用前必须赋初值！

```java
public class TestEnum {

    public static void main(String[] args) {
        // 定义一个枚举类型的变量
        FruitDemo fruit;
        // 赋值
        fruit = FruitDemo.APPLE;

        switch(fruit) {
            case APPLE:
                System.out.println("苹果");   // 苹果
                break;
            case PEACH:
                System.out.println("桃子");
                break;
            case PEAR:
                System.out.println("梨");
                break;
            case WATERMELON:
                System.out.println("水果");
                break;
            default:
                System.out.println("还没进行赋初值");
        }
    }
}
```

枚举常量没有使用枚举类型名称限定（FruitDemo.APPLE）；
而是直接使用名称，这是因为switch表达式的枚举类型已经隐式指定了 case 常量的枚举类型

## 枚举的方法

所有的枚举都自动包含了两个预定义方法：
- `public static <T extends Enum<T> T values()` 返回一个包含枚举常量列表的数组
- `public static <T extends Enum<T> T valueOf(String str)`  方法返回与传递到参数str的字符串相对应的枚举常量

> <T extends Enum<T> T 视为枚举类型即可

> 预定义的方法是没法在文档中找到方法，以及JDK源码的；这种方法形如数组的一些预定义的方法(clone()方法)

### 方法的使用：

values() 方法的使用：

    枚举类型[ ] 数组名 = 枚举.values();
    
```java
public class Demo {

    public static void main(String[] args) {
        // 定义一个枚举类型的变量
        FruitDemo fruit;
        fruit = FruitDemo.APPLE;

        // 使用 values() 返回一个包含枚举常量列表的数组
        FruitDemo[] arrays = fruit.values();
        // 循环输出这个数组
        for (FruitDemo f : arrays) {
            System.out.print(f + " ");  // APPLE WATERMELON PEAR PEACH
        }
    }
}

```

valueOf(String str) 方法的使用：

```java
public class Demo {

    public static void main(String[] args) {
        // 定义一个枚举类型的变量
        FruitDemo fruit;
        // 之前的赋初值
//        fruit = FruitDemo.APPLE;

        // 使用 valueOf() 方法返回对应字符串的枚举常量
        fruit = FruitDemo.valueOf("APPLE");
        System.out.println(fruit);  // APPLE
    }
}
```

## 枚举是类类型

虽然无法使用**new**实例化枚举，但枚举却又许多和其他类的功能可以为枚举提供**构造函数**、**添加实例变量**和**方法**、甚至可以**实现接口**
 	
每个枚举常量都是所属枚举类型的**对象**！ 

如果为枚举定义了**构造函数**，那么当创建每个枚举常量时都会**调用**该构造函数

此外，对于枚举定义的实例变量，每个枚举常量都有它自己的**副本**
  
枚举作为类类型在进行构造函数时还有两条限制 
- 枚举**不能继承**其他类
- 枚举**不是超类**，意味着无法扩展
  	
每个枚举常量都是定义它的类的对象！每个常量都应该以对象的视角看待！

```java
enum ClothesMeasurement {
    // 使每个衣服的码数对应最合适身高
    S(162), M(165),
    L(168), XL(171),
    XXL(173), XXXL(176);

    // 定义一个枚举的成员变量
    private int heightPerson;

    // 定义一个构造器
    ClothesMeasurement(int heightPerson) {
        this.heightPerson = heightPerson;
    }

    // 定义一个空参函数，对于没有相对应合适的身高的尺寸衣服适合，将回返回一个-1值表示该值还不存在
    ClothesMeasurement() {
        heightPerson = -1;
    }
    
    // 定义一个访问器
    public int getHeightPerson() {
        return heightPerson;
    }
}

public class TestEnum {
    public static void main(String[] args) {
        // 调用枚举的构造方法和访问器
        int i = ClothesMeasurement.valueOf("S").getHeightPerson();
        System.out.println("S码衣服尺寸的合适身高为：" + i);

        System.out.println("所有衣服的身高尺寸参数：");
        for (ClothesMeasurement cm : ClothesMeasurement.values()) {
            System.out.println("衣服的尺寸：" + cm + " 对应的身高为：" + cm.getHeightPerson());
		
        }
    }
}
```
上述的 foreach 循环的输出结果:

    	衣服的尺寸：S 对应的身高为：162
		衣服的尺寸：M 对应的身高为：165
		衣服的尺寸：L 对应的身高为：168
		衣服的尺寸：XL 对应的身高为：171
		衣服的尺寸：XXL 对应的身高为：173
		衣服的尺寸：XXXL 对应的身高为：176

>枚举可定义两种甚至更多的重载形式

这里的ClothesMeasurement有三个内容： 
- 实例变量`heightPerson` 
- `ClothesMeasurement`构造函数，以合适身高作为参数
- `getMeasurement`成员方法，用于返回`heightPerson`变量的值
			
当在`main()`方法中声明了枚举变量`mea`时，对于每个特定的常量`(S(162), M(165),
L(168)...)`调用一次构造函数

注意指定构造函数参数的方式，通过将它们放置在每个常量后面的圆括号加之指定 `S(162),
M(165), L(168), XL(171), XXL(173), XXXL(176)`;

这些数值都被传递给枚举的构造器`ClothesMeasurement()`的参数 `heightPerson`，每个常量都会调用构造函数一次！
			
圆括号（此处说的合适的身高）里的值都有自己的**变量副本**，所以调用`getHeightPerson()`即可获取指定尺寸的合适身高值
			
通过for循环遍历枚举可以获得所有衣服的合适身高数值。因为每个枚举常量都有`heightPerson`变量的副本，与枚举常量关联的值是独立的！

所以可通过遍历获取，与基本数据类型相当

## 枚举继承自**Enum**类
所有枚举都自动继承超类 `java.lang.Enum` 这个类定义所有枚举的一些方法
 	
有三个主要方法：
- `public int
  ordinal()`方法：检索序数值，可获取用于指示枚举常量在常量列表中位置的值，枚举常量对应的位置又称为**序数值**
  - 方法声明：final int ordinal()	
  - 序数值从0开始
	
- `public final int compareTo(E o)` 方法比较相同类型的两个枚举常量的序数值	
		
 	
- `public final boolean equals(Object
  other)`方法比较枚举常量和其他对象的相同性，来自重写了`Object`类定义的`equals()`
  方法
  - 只有当两个对象都引用同一枚举中相同的常量时，它们才会相等
  - 也可使用“==”比较两个枚举引用的相等性

方法的使用： 

```java
enum Phone {
    华为, Apple, Mi, 魅族, 三星, 努比亚, 一加, OPPO, VIVO, 锤子,
}


public class Enumeration004 {

    public static void main(String[] args) {
        // 可以同时定义多个枚举变量
        Phone p1,p2,p3;
        
        // 为变量赋枚举常量
        p1 = Phone.Mi;
        p2 = Phone.三星;
        p3 = Phone.魅族;
        Phone p4 = Phone.锤子;
        Phone p5 = Phone.锤子;

        // 1) ordinal()方法：检索序数值，可获取用于指示枚举常量在常量列表中位置的值，注意是从0开始数数
        int location1 = p1.ordinal();
        int location2 = p2.ordinal();
        int location3 = p3.ordinal();
        System.out.println(location1 + " " + location2 + " " + location3);	// 2 4 3

        // 2) compareTo()方法比较相同类型的两个枚举常量的序数值，这是个整数值，将返回两个枚举变量的差值
        System.out.println(p1.compareTo(p4));   // -7
        System.out.println(p3.compareTo(p1));   // 1
        System.out.println(p3.compareTo(p2));   // -1

        System.out.println(p1.compareTo(Phone.Mi));     //0
        System.out.println(p3.compareTo(Phone.Apple));  //2
        System.out.println(p3.compareTo(Phone.锤子));    //-6

        // 3) equal()方法比较枚举常量和其他对象的相同性
        boolean tf1 = p1.equals(Phone.Mi);
        boolean tf2 = p2.equals(p1);
        boolean tf3 = p5.equals(p4);
        System.out.println(tf1 + " " + tf2 + " " + tf3); // true false true

    }
}

```
> 此案例中枚举常量用了中文字符，不建议使用；但在一般程序中应以**常量**的命名规范来命名