# 面试题导航

## 刷题记录及错题集锦

- [20190902刷题](JavaAnswer/src/main/20190902刷题/README.md)

# JavaSE

## [Java基本常识](JavaSE/0Java基本常识/Interview.md)
 - 简单的说一下什么是跨平台
 - Oracle JDK 和 OpenJDK 的对比
 - 说一下Java和C++的区别
 
## [变量与数据类型](JavaSE/1变量与数据类型/Interview.md)
- 什么是实例变量？什么是局部变量？什么是类变量？什么是final变量？
- 引用类型是占用几个字节的
- char型变量能不能存储一个中文汉字？为什么？
- 列出Java中所有基本数据类型，并说明这些数据类型占用的字节数 
- 不同的数据类型的转换有哪些规则
- 强制类型转换的注意事项		
- 为什么需要包装类
- 基本数据类型与包装类的区别

## [Java运算与控制流程](JavaSE/2Java运算与控制流程/Interview.md)
- "4&5" "4^5" "4|5" "4&10 >> 1"各等于多少
- 说说 && 于 & 的区别
- short s1 = 1，s1 = 1 + 1有什么错吗？或者short s1 = 1，s1 += 1有什么错吗?
- 用最有效率的方法算出 2 * 8 等于几
- break、continue 以及 return 有什么区别？
- java中switch选择结构中可以使用数据类型的数据(在JDK1.8)
- 值传递和引用传递有哪些区别
- 局部变量使用前需要显式地赋值，否则编译通过不了，为什么这么设计
- Math.round(-2.5)等于多少

## [面向对象](JavaSE/3面向对象/Interview.md)
- 面向对象与面向过程的区别 
- 面向对象有哪些特征 
- 面向对象六大原则
- 什么是继承 -重载与重写有什么区别 
- 接口与抽象类的区别
- 重载与重写有什么区别？	
- this 与 super 关键字有什么区别	
- Java 提供了哪两种用于多态的机制	
- instanceof 有什么作用
- static 关键字有哪些作用
- 使用 static 关键字的四种使用情况
- static 与 final 结合使用表示什么意思？
- 什么是不可变类?	
- 使用 final 关键字修饰一个变量时，是引用不能变？还是引用的对象不能变	-
- 既然Java反射可以访问和修改私有成员变量，那封装成private还有意义么

	
## [基本API](JavaSE/4基本API/Interview.md)
- ==与equals的区别
- 为什么规定重写 equals() 就一定要重写 hashCode() 方法
- 两个对象的hashCode相同，则equals也一定为true吗？
- String、StringBuffer和StringBuilder的区别
	
	
## [容器](JavaSE/5容器/)
- Java中数组是不是对象
- length 属性与 length() 方法有什么区别？
- ConcurrentModificationException异常出现的原因
- ArrayList和LinkedList的区别	
- ArrayList和Vector的比较
- HashSet与TreeSet的比较
- HashMap和ConcurrentHashMap的区别 
- HashTable和ConcurrentHashMap的区别
- 如何让Map集合保证线程安全又效率高
- 怎么样让HashMap同步
		
	
## [IO数据的处理]


## [多线程与并发]
  
## Java高级语法特性
### [泛型](JavaSE/8Java高级语法特性/泛型/Interview.md)
- Java中的泛型是什么？使用泛型的好处是什么？
- Java的泛型是如何工作的？什么是类型擦除？ 
- 在Java中List<Object> 和原始类型 List 之间的区别

# Web前端

## [XML](JavaEE/src/main/directory/XML/Interview.md)
- XML 是什么？
- XML 与 HTML 的区别是什么？
- DTD 与 XML Schema 有什么区别？
- XPath 是什么？
- XSLT 是什么?
- 什么是 XML 元素和属性
- 什么是格式良好的 XML
- DOM 和 SAX 解析器有什么区别
- XML CDATA 是什么
- Java 的 XML 数据绑定是什么

# 数据库
## [数据库原理](数据库/Interview.md)
- 说一下数据库存储引擎的概念
- 说一下你对InnoDB（B+树）的理解
- 什么是索引？
- 创建索引索引有那些原则？
- 什么是数据库的三范式？
- 什么是事务？事务的有那些属性？
- 什么是存储过程？
- 存储过程如何优化？说一下优化的思想
- 什么是触发器？
- 数据库的并发策略有哪一些？请详细描述一下
- 数据库的锁有那些？
- 分区分表的方式有那些？

# [JavaEE](JavaEE/Interview.md)

- Java Web 通常包含哪些常用的技术规范（组件）？
- HTTP 请求的 GET 和 POST 的区别？
- 什么是Servlet
- Servlet的优点 
- Servlet执行流程 
- 转发(Forward)和重定向(Redirect)的区别
- Servlet 的会话机制？
- cookie 和 session 的作用、区别、应用范围？
- JSP 是什么？有什么特点？ 
- JSP 页面包含哪些语法？它们具有什么特征？ 
- JSP 的编译指令有哪些？ 
- JSP 中动态 include 与静态 include 的区别？ 
- JSP 有哪些动作指令？分别是什么？ 
- JSP 有哪些内置对象？作用分别是什么？ 
- JSP 和 Servlet 有哪些相同点和不同点？ 
- JSTL 是什么？优点有哪些？ 
- 如何避免 JSP 页面自动生成 session 对象？为什么要这么做？ 
- EL 表达式的功能？为什么要用 EL 表达式？
- Filter 是什么？有什么作用？
- Listener 是什么？有什么作用？

# 框架


## [Spring](Spring/Interview.md)

- 什么是 Spring？
- Spring 有哪些优点？
- Spring 框架中都用到了哪些设计模式？
- 什么是 Spring Bean？
- Spring 框架中单例 Bean 是线程安全的吗？
- Spring 中的依赖注入是什么？
- Spring IoC 容器是什么？IoC 有什么优点？
- Bean factory.Factory 和 ApplicationContext 有什么区别？ 
- IoC 和 DI 的区别？
- 有哪些不同类型的依赖注入（IoC）？
- 什么是 Bean wiring（Bean 装配）？
- 什么是 Bean 自动装配？解释各种自动装配模式
- @Required 注解？
- @Autowired 注解？
- @Qualifier 注解？
- 自动装配有哪些局限性？
- 什么是 AOP？
- 什么是目标对象？ 
- 什么是代理？ 
- Spring 的 AOP 代理有什么实现方式？ 
- Spring 中 AOP 的应用场景、AOP 原理、好处？
- 介绍 Spring 支持的 5 种 Advice（增强处理）
- 引入（Introduction）和织入（Weaving）的区别？
- Spring 支持哪些 ORM？
- Spring 的事务管理有哪些优点？
- Spring 支持的事务管理类型？

# [SpringMVC](SpringMVC/Interview.md)
- 什么是MVC模式？
- 什么是 Spring MVC 框架？
- 什么是 DispatcherServlet ？
- 什么是 Spring MVC 框架的控制器？
- 什么是 WebApplicationContext？
- @Controller 注解
- @RequestMapping 注解
- Spring MVC 的流程

# [Mybatis]

# 设计模式

# 算法与数据结构
