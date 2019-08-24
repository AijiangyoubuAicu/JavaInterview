# 反射

反射技术通常被用来检测和改变应用程序在 Java 虚拟机中的行为表现。
它是一个相对而言比较高级的技术，通常它应用的前提是开发者本身对 Java
语言特性有很强的理解的基础上。 值得说明的是，反射是一种强有力的技术特性，
因此可以使得应用程序突破一些藩篱，执行一些常规手段无法企及的目的

简而言之：反射能够在程序运行时修改程序的行为；但反射是非常规手段，反射是有风险，应用时需谨慎

## Class

`java.lang.Class`类用来表示**正在运行**的Java应用程序中的类和接口

反射的入口就是类`Class`，但是这个类中是没有公开的构造方法的；

在 Java 反射中`Class`的获取通过以下三种方式：
- `public final 类<?> getClass()`
  是`java.lang.Object`中的方法，如果该对象可以访问，那么该方法就可以获取它相应的`Class`对象
- `类名.class` 通过`类名.class`标识的方式可获取到一个Class的实例
- `public static 类<?> forName(String className) throws
  ClassNotFoundException`
  是`Class`的静态方法，可通过`Class.forName(全限定类名)`获取到`Class`的实例

## 获取一个类的 Class 对象

>Class 是一个入口，它代表引用、基本数据类型甚至是数组对象，所以获取它们的方式又有一点不同

这是一个普通的类： 

```java
import java.io.Serializable;

public class Dog implements Serializable {

    private static final long serialVersionUID = -2849831858169198753L;

    private String name;
    private Integer age;
    private String gender;

    public Dog() {
    }

    /**
     * 一个普通的方法
     */
    public void run() {
        System.out.println("汪汪汪，跑跑跑");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

}
```

### `Class.getName()` 

- 当 Class 代表一个**引用**时：返回的是一个二进制形式的字符串，如**类的全限类名**
- 当 Class 代表一个**基本数据类型**：返回的是它们的关键字，比如 int.class 的名字是
  int
- 当 Class 代表的是基础数据类型的数组时：比如
  String[].getClass().getName()结果是 [Ljava.lang.String


        Java 对于这 Class 的名称一块制定了相应规则，在元素的类型前面添加相应数量的 [ 符号， 用 [
        的个数来提示数组的维度，并且值得注意的是，对于基本类型或者是类，
        都有相应的编码，所谓的编码大多数是用一个大写字母来指示某种类型，规则如下
        
        元素类型    编码
        boolean    Z
        byte       B
        char       C
        double     D
        float      F
        int        I
        long       J
        short      S
        类或接口    L类名
        
        类或者是接口的类型编码是 L类名; 的形式,后面有一个分号。
        比如 String[].getClass().getName() 结果是 [Ljava.lang.String;


测试类：

```java
import com.aijiang.ClassDemo.Dog;public class TestClass {
    public static void main(String[] args) {
        try {

            Class clz = Class.forName("com.aijiang.ClassDemo.Dog");       
            Class clz1 = float.class;
            Class clz2 = new int[]{}.getClass();    
            Class clz3 = new Dog[]{}.getClass();

            System.out.println(clz.getName());  // com.aijiang.ClassDemo.Dog
            System.out.println(clz1.getName()); // float
            System.out.println(clz2.getName()); // [I
            System.out.println(clz3.getName()); // [Lcom.aijiang.ClassDemo.Dog;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```
### `Class.getSimpleName()` 与 `Class.getCanonicalName()`

- Class.getSimpleName() 
  返回源代码中给出的基础类的简单名称；如果基础类是匿名的，则返回一个空字符串

- Class.getCanonicalName() 返回一个 Class 对象的官方名字，这个官方名字
  canonicalName 是 Java 语言规范制定的，如果 Class 对象没有 canonicalName
  的话就返回 null

最大的区别在于内部类： 

一个内部类：
```java
package com.aijiang.ClassDemo;

public class Outter {

    // 静态内部类，只为了方便调用
    public static class Inner {}
}
```
测试代码： 
```java
import com.aijiang.ClassDemo.Outter;

public class TestClass {
    public static void main(String[] args) {
        Class clz = Outter.Inner.class;

        System.out.println("内部类的类名：" + clz.getName());  // 内部类的类名：com.aijiang.ClassDemo.Outter$Inner
        System.out.println("内部类的简单类名：" + clz.getSimpleName());  // 内部类的简单类名：Inner
        System.out.println("内部类的官方类名：" + clz.getCanonicalName());   // 内部类的官方类名：com.aijiang.ClassDemo.Outter.Inner
    }
}
```
因为是内部类，所以通过`getName()`
方法获取到的是**二进制形式的全限定类名**，并且类名前面还有个**$**符号。
`getSimpleName()`则直接返回了 Inner，去掉了包名限定；

## 获取修饰符

在 Java 中开发一个类，有以下几种修饰符：
- 权限修饰符
- 抽象修饰符 abstract
- 静态修饰符 static
- 注解

可通过`Class.getModifiers()`方法即可，它返回的是一个 int 数值

## 获取成员属性 Field

- `public Field getDeclaredField(String name)` 获取的是 Class 中被 private 修饰的属性
- `public Field getField(String name)` 获取的是非私有属性
- `public Field[] getDeclaredFields()` 获取所有的属性，不包括父类继承的属性
- `public Field[] getFields()` 获取自身的所有的 public 属性，包括从父类继承下来的

### 获取成员属性的类型

- `public Type getGenericType()`
- `public Class<?> getType()` 能够获取到泛型类型

### 获取成员属性的修饰符

- `public int getModifiers()`

## 获取成员方法 Method

方法由以下几方面构成：

- 方法名 
- 方法参数 
- 方法返回值 
- 方法的修饰符 
- 方法可能会抛出的异常

反射中`Method`提供了相应的 API 来提取这些元素

### 获取方法的方法名：
 
- `public Method getDeclaredMethod(String name, Class<?>...
  parameterTypes)` 获取的是 Class 中被 private 修饰的方法
- `public Method getMethod(String name, Class<?>... parameterTypes)`
  获取的是非私有方法
- `public Method[] getDeclaredMethods() throws SecurityException`
  获取所有的成员方法，不包括父类继承的方法
- `public Method getMethod(String name, Class<?>... parameterTypes) `
  获取自身的所有的 public 成员方法，包括从父类继承下来的方法

### 获取方法的参数：
- `public Parameter[] getParameters()` 返回的是一个 Parameter 数组，在反射中 Parameter 对象就是用来映射方法中的参数
  - `public String getName()` 获取参数名字
  - `public Class<?> getType()` 获取参数类型
  - `public int getModifiers()` 获取参数的修饰符

### 获取方法的返回值类型
- `public Class<?> getReturnType()` 获取返回值类型
- `public Type getGenericReturnType()` 获取返回值类型包括泛型

### 获取方法抛出的异常
- `public Class<?>[] getExceptionTypes()`
- `public Type[] getGenericExceptionTypes()`

## 获取方法的执行 invoke
- `public Object invoke(Object obj, Object... args)`

很多时候运用反射目的其实就是为了以常规手段执行 Method

- Method 调用 invoke() 的时候，存在许多细节：
  - invoke() 方法中第一个参数 Object 实质上是 Method 所依附的 Class
    对应的类的实例，如果这个方法是一个静态方法，那么 ojb 为 null，后面的可变参数
    Object 对应的自然就是参数。

  - invoke() 返回的对象是 Object，所以实际上执行的时候要进行强制转换

  - 在对 Method 调用
    invoke()的时候，如果方法本身会抛出异常，那么这个异常就会经过包装，由 Method
    统一抛出 InvocationTargetException。而通过
    InvocationTargetException.getCause() 可以获取真正的异常。


## 获取构造器 Constructor

构造器也称构造方法，在反射机制中却把它与 Method 分离开来，单独用`Constructor`
这个类表示； 这个类的方法同`Method`差不多，它的特别的地方在于**能够创建一个对象**

在 Java 反射机制中有两种方法可以用来创建类的对象实例
- `Class.newInstance()` 
- `Constructor.newInstance()`

> 官方文档建议开发者使用 Constructor.newInstance()

原因在于：
- Class.newInstance() 只能调用无参的构造方法，而 Constructor.newInstance()
  则可以调用任意的构造方法
- Class.newInstance() 通过构造方法直接抛出异常，而 Constructor.newInstance()
  会把抛出来的异常包装到 InvocationTargetException 里面去，这个和 Method
  行为一致
- Class.newInstance() 要求构造方法能够被访问，而 Constructor.newInstance()
  却能够访问 private 修饰的构造器

### 获取构造器的名称

- `public Constructor<T> getDeclaredConstructor(Class<?>...
  parameterTypes)` 获取的是 private 修饰的构造器

- `public Constructor<T> getConstructor(Class<?>... parameterTypes)`
  获取的是非私有构造器

- `public Constructor<?>[] getDeclaredConstructors() throws
  SecurityException` 获取所有的构造器

- `public Constructor<?>[] getConstructors() throws
  SecurityException`获取自身的所有的 public 的构造器
  


