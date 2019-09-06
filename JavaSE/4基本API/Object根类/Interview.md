## == 与 equals 的区别
`==`比较的是两个引用中在内存中的指向是不是同一个对象(即同一内存空间)，也就是说在内存空间中的存储位置是否一致，如果
两个对象的引用相同时(指向同一内存空间)，`==`操作非返回true，否则返回false

`equals`用来比较某些特征是否一样；如果未重写equals方法，则它的作用与`==`相同，大部分的类都重写了equals方法，如String
重写equals中它不止判断了内存地址，还增加了字符串是否相同的比较；

## 为什么规定重写 equals() 就一定要重写 hashCode() 方法

一般重写 equals() 方法的同时也重写 hashCode() 方法，否则就违反了 Object.hashCode 的通用约定；
这是因为如果不同时重写这两个方法，就导致该类与所有基于散列表 (hash) 的集合类 (HashMap、HashSet和Hashtable) 结合在一起才能正确运行；

## 两个对象的hashCode相同，则equals也一定为true吗
比如，自定义hashCode()方法
```java
@Override
public int hashCode() {
    return 1;
}
```
这样，该类的hashCode()返回的值都会是1

如果按照官方的规范重写hashCode()方法的话，hashCode一定相等，但是不按照官方的规范或者不重写hashCode方法就会出现不相等的情况

## String、StringBuffer和StringBuilder的区别
- 1.数据可变与不可变
	- `String`底层使用了一个不可变字符数组`private final char value[]`；所以它是不可变的
	- `StringBuffer`和`StringBuilder`都继承了`AbstractStringBuilder`底层使用的可边字符串`char[] value`
- 2.线程安全
	- `SringBuilder`是线程不安全的，效率高
	- `StringBuidder`是线程安全的，因为`append()`是有同步锁，所以效率低
		
- 3.相同点
	- `StringBuilder`和`StringBuffer`有公共父类`AbstarctStringBuilder`
		
- 4.操作可边字符串速度
	- `StringBuilder` > `StringBuffer` > `String`
		

		