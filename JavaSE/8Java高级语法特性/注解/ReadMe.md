# 注解
## 概念

说明程序的。给计算机看的

## 注释

用文字描述程序的。给程序员看的

## 定义

注解（Annotation），也叫元数据。一种代码级别的说明。它是JDK1.5及以后版本引入的一个特性，与类、接口、枚举是在同一个层次。它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。

- 概念描述：
	- JDK1.5之后的新特性
		- 说明程序的
		- 使用注解：@注解名称
		
	
## 作用分类：
- ①编写文档：通过代码里标识的注解生成文档【生成文档doc文档】
- ②代码分析：通过代码里标识的注解对代码进行分析【使用反射】
- ③编译检查：通过代码里标识的注解让编译器能够实现基本的编译检查【Override】

## JDK中预定义的一些注解
- `@Override`	：检测被该注解标注的方法是否是继承自父类(接口)的
- `@Deprecated`：该注解标注的内容，表示已过时
- `@SuppressWarnings`：压制警告
	- 一般传递参数all  @SuppressWarnings("all")

## 自定义注解
格式：

	// 元注解
	public @interface 注解名称{
		属性列表;
	}

## 本质

注解本质上就是一个接口，该接口默认继承Annotation接口

	public interface MyAnno extends java.lang.annotation.Annotation {}

## 属性

接口中的抽象方法

- 要求：

1. 属性的返回值类型有下列取值
	* 基本数据类型
	* String
	* 枚举
	* 注解
	* 以上类型的数组

2. 定义了属性，在使用时需要给属性赋值
	1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
	2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。
	3. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略
		
		* 元注解：用于描述注解的注解
			* @Target：描述注解能够作用的位置
				* ElementType取值：
					* TYPE：可以作用于类上
					* METHOD：可以作用于方法上
					* FIELD：可以作用于成员变量上
					
			* @Retention：描述注解被保留的阶段
				* @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
			* @Documented：描述注解是否被抽取到api文档中
			* @Inherited：描述注解是否被子类继承


* 在程序使用(解析)注解：获取注解中定义的属性值

1. 获取注解定义的位置的对象  （Class，Method,Field）

2. 获取指定的注解

		* getAnnotation(Class)
		// 其实就是在内存中生成了一个该注解接口的子类实现对象

		public class ProImpl implements Pro{
		  public String className(){
		     return "cn.itcast.annotation.Demo1";
		  }
		  public String methodName(){
		     return "show";
		  }
		}
		
3. 调用注解中的抽象方法获取配置的属性值

