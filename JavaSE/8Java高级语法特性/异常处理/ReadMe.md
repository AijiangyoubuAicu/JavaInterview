# 异常

## 概述

定义：指在程序在执行中，出现的非正常的情况，最终会导致JVM非正常停止

在Java等面对对象的编程语言中，异常本身是一个类，产生异常就是创建异常对象并抛出一个异常对象；
Java处理异常的方式是中断处理

>异常指的并不是语法错误,语法错了,编译不通过,不会产生字节码文件,根本不能运行

## 异常体系

异常机制其实是帮助我们找到程序中的问题，异常的根类是`java.lang.Throwable`，其下有两个子类：
`java.lang.Error`和`java.long.Exception`，平常所说的的异常是`java.lang.Exception`

![](img/异常体系.png)

- Error 严重错误；无法通过处理的错误，只能事先避免，好比绝症
- Exception 异常；异常产生后程序员可以通过代码的方式纠正，使程序继续运行，是必须要处理的

Throwable 中最常用的方法：
- `public void printStackTrace()` 打印异常的详细信息
- `public String getMessage()` 获取发生异常的原因
- `public String toString()` 获取异常的类型和异常的描述信息

## 异常分类

异常(Exception)的分类
- 编译时异常：checked异常，在编译时期，就会检查，如果没有处理异常，则编译失败(如日期格式化异常)
- 运行时异常：runtime异常，在运行时期，检查异常，在编译时期异常不会编译器检测

![](img/异常的分类.png)

# 异常的处理
Java异常处理的五个关键字：try、catch、finally、throw、throws

## 抛出异常throw
在编写程序的时候，我们必须要考虑程序出现问题的情况；比如，在定义方法时，方法需要接受参数。
那么，当调用方法使用接受到的参数时，首先需要先对参数数据进行合法的判断，
数据若不合法，就应该告诉调用者，传递合法的数据进来。这时需要使用`抛出异常`的方式来告诉调用者。
                         
在Javba中，提供了`throw`关键字用来抛出一个指定的异常对象，具体操作：
- 创建一个异常对象，封装了一些提示信息
- 将这个异常对象告知给调用者，通过关键字 throw 异常对象就可以完成

throw 用在方法内，用来抛出一个异常对象，将这个异常对象传递给调用者处，并结束掉当前方法的执行
使用格式：
	
	throw new 异常类名(参数);
	如：
	throw new NullPointException("空指针异常");
	throw new ArrayIndexOutBoundsException("数组索引越界异常");

>Objects非空判断
 Objects有null-save（空指针安全的）或null-tolerant（容忍空指针的）两个方法，
 那么在它的源码中，对对象为null的值进行了抛出异常操作。
 public static <T> T requireNonNull(T obj):查看指定引用对象不是null。

## 捕获异常 try..,catch

如果异常出现的话，会立刻终止程序，所以我们得处理异常：

- 该方法不处理，而是声明抛出，由该方法的调用者来处理(throws)
- 在方法中使用 try-catch 的语句块来处理异常

try-catch 的方式就是`捕获异常`

- 捕获异常：Java中对异常有针对性的语句进行捕获，可以对出现的异常进行指定方式的处理

语法格式：
		
		try {
		  // 可能会出现异常的代码
		} catch(要捕获的异常类型 e) {
		  // 处理日志/打印异常信息/继续抛出异常
		}

Throwable 类中定义了一些查看方法：
- `public String getMessage()` 获取异常的描述信息、原因(提示给用户的时候，就提示错误原因)
- `public String toString()` 获取异常的类型和异常描述信息
- `public void printStackTrace()` 打印异常的跟踪栈信息并输出到控制台

包含异常的类型，异常的原因，还包括异常出现的位置，在开发和调试阶段，都得使用 printStackTrace() 方法

## finally 代码块

finally：有一些特定的代码无论异常是否发生，都需要执行。另外，因为异常会引发程序跳转，导致有些语句执行不到。
而finally就是解决这个问题的，在finally代码块中存放的代码都是一定会被执行的。

finally 的语法：
	
		try {
  	  // 可能会出现异常的代码
  	} catch(要捕获的异常类型 e) {
  		// 处理日志/打印异常信息/继续抛出异常
  	} finally {
  	  // 关闭资源等必须要执行的代码块
  	}