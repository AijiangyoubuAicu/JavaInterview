## break、continue 以及 return 有什么区别？

- break：用于直接强行跳出当前循环
- continue：用于停止当前循环，回到循环起始处进入下一次循环
- return：是一个跳转语句，用来表示从一个方法返回，返回调用该方法的地方

>Java 是否存在 goto 语句？-- goto是Java的保留字，是没有在Java中使用

## java中switch选择结构中可以使用数据类型的数据(在JDK1.8)
- 基本数据类型
	- char
	- byte
	- short
	- int
- 包装类
	- Character
	- Byte
	- Short
	- Integer
- 类类型
	- String
	- enum
