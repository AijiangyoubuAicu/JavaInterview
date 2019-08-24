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
		

		