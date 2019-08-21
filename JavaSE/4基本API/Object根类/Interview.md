## == 、equals 和 hashCode 有什么区别？

- "=="运算符用来比较两个变量的值是否相等，也就是说该运算符用于比较变量对应的内存中所存储的数值是否相同，
	要比较两个基本类型或两个引用变量是否相等

- equals()是 Object 类是提供之一，所以每一个对象都具有equals()这个方法；Object 类定义的 equals()方法
	是直接使用"=="运算符比较的两个对象，所以在没有重写该方法时，与"=="号等效；

- hashCode() 方法是从 Object 类中继承过来的，它也用来鉴别两个对象是否相等；Object 类中的 hashCode() 方法
	返回对象在内存中地址转换成的一个 int 值，所以如果没有重写 hashCode() 方法，任何对象的 hashCode() 方法都是不相等的

## 为什么规定重写 equals() 就一定要重写 hashCode() 方法

一般重写 equals() 方法的同时也重写 hashCode() 方法，否则就违反了 Object.hashCode 的通用约定；
这是因为如果不同时重写这两个方法，就导致该类与所有基于散列表 (hash) 的集合类 (HashMap、HashSet和Hashtable) 结合在一起才能正确运行；

