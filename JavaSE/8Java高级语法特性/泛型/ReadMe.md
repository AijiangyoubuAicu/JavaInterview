# 泛型

## 泛型概述：从JDK5开始
 		
- 思想：

通过使用**泛型**，可以创建以**类型安全**的方式使用各种类型数据的类、接口以及方法，许多算法虽然操作的数据类型不同，但算法逻辑是相同的
使用泛型，只**定义算法一次**，使其**独立于特定的数据类型**，然后将算法应用于各种数据类型而不需要做额外的工作（避免因数据类型而导致的异常）
 	
- 概念：

**泛型**的意思是**参数化类型**；参数化类型很重要，因为使用该特性创建的类、接口以及方法，可以作为参数指定所操作数据的类型
使用泛型可以创建自动操作不同类型数据的类。操作参数化类型的类、接口或方法被称为**泛型**
 	
- Object：

在没有**泛型**的概念之前，一般的代码都是通过操作`Object`类型的引用，从而创建一般化的类、接口以及方法；
因为`Object`是所有其他类的超类，所以`Object`引用变量可以引用所有类型的对象！
一般化的类、接口以及方法使用`Object`引用来操作各种类型的对象；
缺点就在它们不能以类型安全（即过程发生类型转换容易产生异常）的方式进行工作

那么泛型提供了以前缺失类型的安全性，并且可以简化处理过程，因为不再需要显式地使用强制类型转换，即不需要再Object和实际操作中进行数据类型之间的转换！
所有类型转换都是自动和隐式的！

- 总结：即泛型书写的类、接口和方法的将“隐藏”数据类型，避免在写代码过程中需要的数据类型的转换，也避免了因数据类型发生的各种异常
  当然，泛型也可以看出是一个变量，用来接收数据类型
  - E e Element 元素 
  - T t Type 类型

### 定义一个泛型类
```java
/**
 * 定义一个泛型类
 *
 * @param <T> T是类型参数Type的名称，这个名称是实际类型的“占位符”
 */
class Gen<T> {
    // 定义泛型变量
    T value;
    // 定义有参泛型构造函数
    Gen(T value) {
        this.value = value;
    }
    // 定义泛型访问器
    T getValue() {
        return value;
    }
    // 定义展示输出数据类型的一般方法
    void showType() {
        System.out.println("泛型T的类型是：" + value.getClass().getName());
    }
}
```

### 使用这个泛型

```java
public class Generic001 {
    public static void main(String[] args) {
        // 实例化泛型类，并在实例时确定泛型的数据类型为 Integer
        Gen<Integer> i = new Gen<Integer>(88);
        // 调用一般方法
        i.showType();	// 泛型T的类型是：java.lang.Integer
        int v = i.getValue();
        System.out.println(v);	// 88
        // 实例化泛型类，并在实例时确定泛型的数据类型为Double
        Gen<String> s = new Gen<String>("Decade");
        s.showType();	// 泛型T的类型是：java.lang.String
        String t = s.getValue();
        System.out.println(t);	// Decade
    }
}
```
> 此处在JDK7之后可省略了 Gen<Integer> i = new Gen<>(88);
> 发生了自动装箱操作，显式代码为：Gen<Integer> i = new Gen<Integer>(new
> Inerger(88))，但是无任何好处哦

### 使用泛型的优点注意事项

- 泛型只使用**引用类型**
  当实例化泛型类的时候，传递过来的类型参数必须是**引用类型（各种封装器）**，不能使用任何8大基本数据类型
  这也是泛型添加类型安全性以及防止错误的方式之一
 		

### 使用泛型的优点注意事项

- 泛型提高类型安全的原理，对于任何涉及 Gen 的操作，泛型都可以**自动确保类型安全**！
  在这个过程中，消除了**手动输入类型转换**和**类型检查**两个操作；
		
- 通过泛型可以将**运行时错误**转换成**编译时错误**，这就是泛型的主要优势！

## 使用 Object 作为参数化类型

- 使用`Object`这个根类代替**泛型<T>**，这使得这个成员变量能够存储**任意类型对象**
- 使用`Object`最大优点也就是缺点：编译器根本不知道实际存储的数据类型的信息
- 使用`Object`就需要注意：
  - 对于存储的数据，必须显示地进行类型转换才能提取
  - 许多类型不匹配错误直到**运行期**才会出异常

用`Object`作为数据类型，可以达到泛型的可容纳大千的数据类型的效果，
但是`Object根本上是属于基本数据类型应用范畴，在类型转换过程等过程是类型不安全的，容易运行时异常

请看以下案例：

```java
// 创建一个非泛型类
class NonGenericGen {

    Object i;

    // 根类型参数的有参构造器
    NonGenericGen(Object i) {
        this.i = i;
    }
    // 访问器
    Object getValue() {
        return i;
    }
    // 展示数据类型的一般方法
    void showType() {
        System.out.println(i.getClass().getName());
    }
}

public class Demo {

    public static void main(String[] args) {
        // 实例化Integet形式
        NonGenericGen demoInt = new NonGenericGen(88);
        // 输出数据类型
        demoInt.showType();		    // java.lang.Integer
        /**
         * 必须通过手动装箱操作装入Integer封装器中；
         * 因为返回的类型是Object，
         * 为了能够对返回值进行自动拆装箱并保存到value里，
         * 那么此处就应该"显式"的进行类型转换
         */
        int value = (Integer)demoInt.getValue();
        System.out.println(value);	// 88

        // 实例化字符串形式
        NonGenericGen demoString = new NonGenericGen("二哈");
        // 输出数据类型
        demoString.showType(); 		// java.lang.String
        String value2 = (String)demoString.getValue();
        System.out.println(value2);	// 二哈

        // 赋值操作
        demoInt = demoString;
        System.out.println(demoInt);		// Konwledge005.NonGenericGen@15db9742
        System.out.println(demoString);		// Konwledge005.NonGenericGen@15db9742
        /**
         * 此刻，demoInt的引用被赋给了demoString，
         * 现在demoInt指向的是demoString里包含的字符串而非整型数值，
         * 但由于没有使用泛型，编译器就无法知情报出异常
         */
        try {
            int value3 = (Integer)demoInt.getValue();
            System.out.println(value3);
        } catch (ClassCastException e) {
            System.out.println("类类型转换异常");  // 类类型转换异常
        }
    }
}
```
## 多个泛型

在泛型中可以声明多个类型参数。为了指定两个或更多个类型参数，只需使用逗号分隔参数列表即可；

```java
// 一个有两个类型参数的Gen
class TwoGen<T,V> {
    // 成员变量
    T ob1;
    V ob2;
    // 有参构造器
    TwoGen(T ob1, V ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }
    // 访问器
    T getob1() {
        return ob1;
    }
    V getob2() {
        return ob2;
    }
    // 展示数据类型的一般函数
    void showType() {
        System.out.println(ob1.getClass().getName() + " " + ob2.getClass().getName());
    }
}

public class Generic {

    public static void main(String[] args) {
        /**
         * 实例化泛型类，两个泛型为 Integer 和 String
         * 也可将两个类型参数设置成一样的
         */
        TwoGen<Integer, String> tgObj = new TwoGen<>(88, "Generics");
        // 查看一下数据类型
        tgObj.showType();							// java.lang.Integer java.lang.String
        // 赋值1
        int v = tgObj.getob1();
        System.out.println(v);						// 88

        // 赋值2
        String str = tgObj.getob2();
        System.out.println(str);					// Generics

    }
}
```
## 有界类型

通过泛型继承形式，界定该泛型的类型参数声明父类的上限；

例如格式：

    class 类名<T extends Number> {}
 
如上述格式的用法体现在：
- 界定数值封装器的父类Number，那么所有T类型参数就就可以传入该父类的所有子类(即所有的包装类)
- 限制`T`的范围也会阻止创建非**包装类型**的对象，比如说在实例化时将T转换为String，那就在编译期报错

具体代码用法案例如下：

```java
class Stats<T extends Number> {

    T[] nums;

    Stats(T[] nums) {
        this.nums = nums;
    }

    double average() {
        double sum = 0.0;
        for(int i = 0; i < nums.length; i++) {
            /**
             * 此刻，average() 方式通过调用 doubleValue() 方法想要获取数组中每个数字的 double 版本
             * 但是编译器并不知道现在正视图创建只使用数值类型的 Stats 对象！
             * 就可以使用有界类型界定该泛型的类型转换的范围
             */
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }
}

public class Generic {

    public static void main(String[] args) {

        Integer[] inums = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<Integer>(inums);
        double v = iob.average();
        System.out.println(v);								//3.0

        Double[] dnums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<Double>(dnums);
        double d = dob.average();
        System.out.println(d);								//3.3

        /**
         * 已被界定上限，无法使用除Number父类下的子类之外其他参数类型
         * 会发生编译异常
         */
		String[] snums = {"1", "2", "3", "4", "5"};
		Stats<String> sob = new Stats<String>(snums);

    }
}
```
除了使用类作为边界之外，也可以使用**接口**

可以指定多个接口作为接口！边界可包含一个类和多个接口；

对于这种情况，必须指定类类型，如果边界包含接口类型，那么只有**实现**了哪种接口的类型参数是合法的；
当指定一个类和一个或多个接口的边界时，使用`&`运算符连接它们，例如格式： 

    class Gen<T extendsMyClass & MyInterface> {}
 		 		
解析：该定义通过类 MyClass 和接口 MyInterface 对 T 进行了限制， 因此所有传递给 T
的类型参数都必须是 MyClass 的子类，并且必须实现 MyInterface 接口

## 使用通配符?参数

JAVA泛型的特性之一：通配符参数，由符号`?`指定表示**未知类型**

```java
class Stats<T extends Number> {
    T[] nums;

    Stats(T[] nums) {
        this.nums = nums;
    }

    double average() {
        double sum = 0.0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    //常规下的泛型设计
//	boolean sameAvg(Stats<T> ob) {
//		if(average() == ob.average()) {
//			return true;
//		}
//		return false;
//	}

    // 通配符下的泛型设计
    boolean sameAvg(Stats<?> dob) {
        if(average() == dob.average()) {
            return true;
        }
        return false;
    }
    
}

public class Generic {

    public static void main(String[] args) {
        Integer[] inums = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<Integer>(inums);		  //3.0
        double v = iob.average();
        System.out.println(v);

        Double[] dnums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<Double>(dnums);		 //3.3
        double w = dob.average();
        System.out.println(w);

        Float[] fnums = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
        Stats<Float> fob = new Stats<Float>(fnums);			//3.0
        double x = fob.average();
        System.out.println(x);
        
        if (iob.sameAvg(dob)) {
            System.out.println("True");
        } else {
            System.out.println("False");						//False
        }

        if (iob.sameAvg(fob)) {
            System.out.println("True");
        } else {
            System.out.println("False");						//True
        }
    }
}
```
- iob和dob在之前已被类型转换，在此因无法再进行类型转换而编译报错
- 有通配符下的泛型设计后，不会再影响能够创建什么类型的Stats对象 
- 这是由 Stats 声明的 extends 子句控制的，通配符只是简单地匹配所有有效的Stats对象

## 有界通配符

可以使用与界定类型参数大体相同的方式界定通配符参数；对于创建用于操作类层次的泛型来说，有界通配符很重要
 	
 	一般来说，要为通配符建立上界，表达式为
 		<? extends superclass>
 	superclass是作为上界的类的名称，形成上界的类也包含在边界之内
 	
 	还可以为通配符添加一条super子句，为通配符指定下界
 		<? super subclass>