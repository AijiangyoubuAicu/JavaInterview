# 注解(元数据)

## 概念

注解是JDK5之后添加的新特性，支持Java在源文件中嵌入**补充信息**，这类信息称为**注解(Annotation)**；

注解不会改变程序的动作，因此也就不会改变程序的**语义**，但也有一些类型的注解实际上可以用于这一目的；

在开发和部署期间，各种工具和框架会用到这心信息；例如：源代码生成器可以处理注解，即术语**元数据(metadata)**
也表示着这个特性； 即 Java 注解会为 Java 代码提供**元数据**；

## 基础知识

注解是基于**接口**的机制创建的，如声明一个注解 Anno

```java 
// 一个简单的注解类型 
public @interface Anno { 
    String str(); 
    int val(); 
}

```

上述代码的创建详解：

- 1.关键字**@interface**前面的**@**是告诉编译器正在声明一个注解类型；
- 2.声明了两个抽象成员变量；所有注解都只能包含方法声明，这些方法不能提供方法体；

注意事项：
- 1.注解不能包含**extends**子句，
- 2.所有注解类型都自动扩展了`java.lang.annotation.Annotation`接口，该接口是所有注解的顶级接口；
  - 重写了 Object 类中的 `hashCode()`、`equals()`、`toString()`方法
  - 指定了一个`annotationType()`方法，该方法返回表示调用注解的 Class 对象
  
上述注解的使用： 
```java
// 创建一个类在类定义上以 @ 符号添加该注解即可
@Anno
public class factory.Test {
    
}
```
## 元注解

元注解是可以注解到注解上的注解， 或者说元注解是一种基本注解，但是它能够应用到其它的注解上面,即注解上的注解

元注解的作用和目的在于：给其他的注解进行解释和说明，元注解有以下几种

### @Retention 

`@Retention` 去给一个注解解释的时候，它指定了这个注解的存活时间

-  `RetentionPolicy.SOURCE` 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视
-  `RetentionPolicy.CLASS` 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中
-  `RetentionPolicy.RUNTIME`注解可以保留到程序运行的时候，它会被加载进入到JVM中，所以在程序运行时可以获取到它们

```java
// 声明这个注解可以保留到程序运行的时候
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

}
```
### @Documented

与文档注释相关；它的作用是能够将注解中的元素包含到 Javadoc 中去

### @Target

Target 是目标的意思，`@Target`指定了注解运用的地方

- `ElementType.ANNOTATION_TYPE` 可以给一个**注解**进行注解
- `ElementType.CONSTRUCTOR` 可以给**构造方法**进行注解 
- `ElementType.FIELD` 可以给**属性**进行注解 
- `ElementType.LOCAL_VARIABLE` 可以给**局部变量**进行注解 
- `ElementType.METHOD` 可以给**方法**进行注解 
- `ElementType.PACKAGE` 可以给一个**包**进行注解 
- `ElementType.PARAMETER` 可以给一个**方法内的参数**进行注解 
- `ElementType.TYPE` 可以给一个**类型**进行注解，比如类、接口、枚举

### @Inherited

Inherited 是**继承**的意思，但是它并不是说注解本身可以继承， 而是说如果一个超类被
`@Inherited` **注解过的注解**进行注解的话，
那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解

```java
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedClass {}

@InheritedClass
public class A {}

// A 被 @InheritedClass 注解，那么类 B 继承 类A，类B也拥有了这个注解
/* @InheritedClass */ 
public class B extends A {}
```

### @Repeatable
Repeatable
自然是可重复的意思；`@Repeatable`代表着一个**容器注解**，用来存放其他注解的地方，它本身也属于一个注解

## 注解的属性
注解的属性也叫做**成员变量**，且只有成员变量而没有方法；

注解的成员变量在注解的定义中以**无形参的方法**形式来声明，
其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型

注意事项： 
- 赋值的方式是在注解的括号内以 value="" 形式，多个属性之前用逗号隔开
- 在注解中定义属性时它的类型必须是 8 种基本数据类型外加类、接口、注解及它们的数组
- 定义的**非默认值**属性应在使用时进行赋值
- 注解中属性可以有**默认值**，默认值需要用`default`关键值指定
- 如果一个注解内仅仅只有一个名字为 value 的属性时，那么使用注解可以只写值
- 一个注解没有任何属性，在应用这个注解的时候，括号都可以省略

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface AnnoTest {
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

@AnnoTest(id = 3, msg = "Hello World")
public class AnnotationTest {
}
```
## Java 预置的注解

在 Java 语言本身已提供了几个预设置的注解：

### @Deprecated

用来标记**过时的元素**

编译器在编译阶段遇到这个注解时会发出提醒警告， 告诉开发者正在调用一个过时的元素比如过时的方法、过时的类、过时的成员变量

一些过时的的元素(如方法、类等)在 IDE 的编译期会被划上一条线

### @Override

重写方法标记

一般用来提示这个方法是重写父类的方法，如果改注解报警告，说明没有正确的重写父类的方法

### @SuppressWarnings

**阻止警告的意思**；之前说过调用被 @Deprecated 注解的方法后，编译器会警告提醒，
而有时候开发者会忽略这种警告，他们可以在调用的地方通过 @SuppressWarnings 达到目的

### @SafeVarargs

JDK7之后：

**参数安全类型注解**；它的目的是提醒开发者不要用参数做一些不安全的操作,
它的存在会阻止编译器产生 unchecked 这样的警告

### @FunctionalInterface

JDK8之后：

**函数式接口(Functional Interface)**就是一个具有一个方法的普通接口；
标记了这个注解的类表示这个接口可以很容易转换为 Lambda 表达式

请参见`Runnable`接口的源码

## 注解的提取

注解通过**反射**获取；

`Class`类中的方法提取注解的方法：

- `public boolean isAnnotationPresent(Class<? extends Annotation>
  annotationClass)` 判断它是否应用了某个注解
  
- `public <A extends Annotation> A getAnnotation(Class<A>
  annotationClass)` 获取 Annotation 对象，返回指定类型的注解

- `public Annotation[] getAnnotations()` 获取 Annotation
  对象，返回注解到这个元素上的所有注解


