# Object 类

## 概述
`java.util.Object`是Java语言中的根类，即所有类的超类；任意子类都可以使用该超类的方法，
在对象实例化的时候，最终找到的超类都是Object；

如果一个类没有特别指定超类，那么默认继承 Object；

其中 Object 类中3个重要的方法：

- `public String toString` 返回该对象的字符串表示
- `public boolean equals(Object)` 指示其他某个对象是否与此对象"相等"
- `public int hashCode()`   返回对象的哈希码值

## toString() 方法

- `public String toString()` 返回该对象的字符串表示形式

toString()方法返回该对象的字符串表示，其实该字符串内容就是：
	
	对象的类型 + @ + 内存地址值

由于 toString() 方法返回的结果是内存地址，在实际开发中，经常需要按照对象的属性
得到相应的字符串表现形式，因此需要重写它

重写 toString() 的工作一般交由IDE处理；

重写的 toString() 方法可以使用输出语句`System.out.println()`输出，其实该语句内部调用了对象的 toString() 方法

## equals() 方法

- `public boolean equals(Object obj)` 指示其他某个对象是否与此对象"相等"

调用成员方法 euqals() 并指定参数为另外一个对象，则可以判断是否相同，此处有`默认`和`自定义`两种形式

- 默认地址比较
	
	如果没有重写 equals() 方法，那么 Object 类中默认进行`==`运算符的对象地址进行比较，只要不是同一对象
	便会返回 false

- 自定义对象内容比较

	如果希望进行对象内容的比较，即所有或指定部分成员变量相同就判断两个对象相同，则可以重写equals()方法
	
具体操作，我们也可以通过 IDE 的快捷方式进行输入

## hashCode() 方法

请见：
[Set集合](../../5容器/2.单列集合Collection/Set/ReadMe.md)