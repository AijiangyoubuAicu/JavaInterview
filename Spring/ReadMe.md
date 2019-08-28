# Spring框架

## 通过XML输出"Hello World！"

### 创建 Maven 项目工程，并导入依赖 jar 包
 
```xml
<dependencies>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.3.24.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>

</dependencies>
```
### 创建输出"HelloWorld"的 Javabean

JavaBean规范请见[面向对象-封装](../JavaSE/3面向对象/面向对象与类/ReadMe.md/##JavaBean)

在spring工程目录下的src/main/java下创建包(当前为cn.aijiang.spring)并创建如下类

```java
package cn.aijiang.spring;

public class HelloWorld {
    
    @Override
    public String toString() {
        return "Hello World!";
    }

}
```

### 写XML配置

在src/main/resources目录下创建一个一个xml文件，并复制如下的**<beans>**约束

在<bean>闭合标签中写入全限类名的 HelloWorld 的 Bean 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="HelloWorld" class="cn.aijiang.spring.HelloWorld" />
    
</beans>
``` 

### 单元测试

在src/main/test/java/下创建与bean同样的包，命名为HelloWorldTest

```java
package cn.aijiang.spring;

import org.junit.After;
import org.junit.Before;
import org.junit.factory.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

    // 上下文依赖对象，读取XML文件
    ClassPathXmlApplicationContext ctx;

    // Before:之前，@Before注释的方法会在测试案例之前
    // 执行，可以用于初始化资源
    @Before
    public void init() {
        // 读取对应的XML文件
        ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    // After:之后，@After注释的方法会在测试案例之后执行
    // 可以用于测试后回收资源
    @After
    public void destroy() {
        ctx.close();
    }

    @factory.Test
    public void testDemoBean() {
        // 通过 getBean 方法获取一个bean
        HelloWorld b2 = ctx.getBean("HelloWorld", HelloWorld.class);
        System.out.println(b2);
    }
}
```

## Spring之旅

### 历史

之前的JavaEE组件：
- applet
- Java数据对象(JDO)
- JavaBean(EJB)

EJB以及JavaEE2在不断演化的同时，EJB自身也提供了**面向POJO**的编程模型，也采用了**依赖注入(DI)**和**面向切面编程(AOP)**，这两个特定是受Spring的成功启示的

**POJO（Plain Ordinary Java
Object）**简单的Java对象，实际就是普通**JavaBeans**，是为了避免和EJB混淆所创造的简称。拥有一些属性和getting和setting方法；

### 简化Java开发

- Spring是一个开源框架;
- Spring是为了解决企业级应用开发的复杂性而创建的;
- Spring可以让简单的JavaBean实现之前只有EJB才能完成的事情;
- Spring可以让任何Java应用都能在简单性、可测试性和松耦合等方面获益;

	Spring的目标是致力于全方位的简化Java开发，为了降低Java开发的复杂性，Spring采取了4种关键策略：
	
- 基于**POJO**的**轻量级**和**最小侵入性**编程
- 通过**依赖注入**和**面向接口**实现**松耦合**
- 基于**切面**和**惯例**进行**声明式编程**
- 通过**切面**和**模板**减少**样板式代码**

### 激发POJO的潜能

很多框架强迫应用继承它们的类或实现它们的接口从而导致应用和框架绑死，典型的便是EJB2时代的无状态会话bean;

Spring竭力避免因自身的API而弄乱应用代码，Spring不会强迫实现Spring规范的接口或继承Spring规范的类；

在基于Spring构建的应用中，它的类通常没有任何痕迹表明你使用过了Spring

Spring赋予POJO的魔力的方式之一就是通过**DI**来装配它们！

## 控制反转IOC

### 解耦思想

依赖注入(DI)功能是如何实现的？

>任何一个有实际意义的应用都会由两个或更多类组成，
>这些类相互之间进行协作来完成特定的业务逻辑

传统的做法：每个对象负责管理与自己相互协作的对象(即它所依赖的对象)的引用，这将导致高耦合和难以测试的代码，如下述：

```java
package cn.aijiang.decoupling;

/**
 * 一个计算机老师类，拥有教书的功能
 */
class ComputerTeacher {

    public String teach() {
        return "老师正在教Java语言";
    }

}

/**
 * 一个学生类
 */
class Student {
    // 依赖于老师类
    private ComputerTeacher ct;

    /**
     * 这将导致高耦合，任何一名学生都将依赖计算机老师在教Java
     * @param ct 传入计算机老师对象
     */
    public Student(ComputerTeacher ct) {
        this.ct = new ComputerTeacher();
    }

    public void Listening() {
        System.out.println("学生们正在听" + ct.teach());
    }

}

public class Decoupling01 {
    public static void main(String[] args) {
        ComputerTeacher tc = new ComputerTeacher();
        Student stu = new Student(tc);
        stu.Listening();    // 学生们正在听老师正在教Java语言
    }
}
```

上述的学生与计算机老师是紧密耦合的，这在现实中思想是：
- 每一个学生都必须会听这名计算机老师在教Java
- 即使不是本专业的学生，你都和这名计算机老师产生关系，
- 即堆内存中有学生对象也会有这名计算机老师的地址！也就是说他何时何地都会陪伴着你！

作为一名学生，肯定会依赖于老师的教书来获得知识，那我们不想只指定一名特定的老师： 

> **面向接口编程**的思想就在于此：在一定程度上实现解耦

```java
package cn.aijiang.decoupling;

/**
 * 一个老师的接口，拥有教书的功能
 */
interface Teacher {

    String teach();

}

/**
 * 实现了老师的接口的实现类并重写教书的方法
 */
class ComputerTeacher implements Teacher {

    @Override
    public String teach() {
        return "老师在教Java语言！";
    }
}

/**
 * 一个学生类
 */
class Student {
    // 依赖于老师接口
    private Teacher t;
    // 注入接口
    public Student(Teacher t) {
        this.t = t;
    }

    public void Listening() {
        System.out.println("学生们正在听" + t.teach());
    }

}

public class Decoupling01 {
    public static void main(String[] args) {
        /**
         * 通过接口类型实例化接口实现类
         * 这样，我们就可以不特指任何一名老师
         */
        Teacher t = new ComputerTeacher();
        Student stu = new Student(t);
        stu.Listening();    // 学生们正在听老师正在教Java语言
    }
}
```
上述的**面向接口编程**中我们做了几项改变：
- 在计算机老师类中向上抽取出一个**老师**的接口
- 在学生类中我们选择依赖于**老师**接口，这样的好处在于我们不再依赖于一名特定的老师， 
  而是在实例化接口的对象时才确定真正来教书的老师是哪一位老师(当前为计算机老师，你也可以实现老师接口来一个语文老师或数学老师等等等)

耦合具有两面性(two-header beast)：
- 一方面：紧密耦合的代码难以测试、难以复用、难以理解，并且典型地表现出"打地鼠"式的BUG特点(牵一发而动全身)
- 另一方面：一定程度的耦合又是必须的，完全没有耦合的代码什么都做不了，为了完成有实际意义的功能，不同的类必须以适当的方式进行交互。
  一定程度的耦合是必须的，但应当小心谨慎地管理

### Spring的依赖注入DI

比起上述的高耦合做法还是面向接口编程，Spring DI就是针对前两者实现最高程度的**解耦**的做法

那么通过DI，对象的**依赖关系**将由系统中负责协调各对象的**第三方组件**(Spring框架)创建对象的时候进行设定，对象无需自行创建或管理它们的依赖关系了<br>
创建组件之间的协作的行为通常称为**装配(wiring)**;
即下述依赖关系就不用在自己声明，而是由 Spring IOC 容器负责声明及装配：

```
    // 依赖于老师接口
    private Teacher t;
    // 注入接口
    public Student(Teacher t) {
        this.t = t;
    }
```

Spring 有多种装配方式，XML 就是很常用的一种

不管使用基于 XML 的配置还是基于 Java 的配置，DI带来的收益都是相同的；

观察如何工作的？
- Spring 通过**应用上下文(Application Context)**装载bean的定义并把它们组装起来
- Spring 应用**上下文**全权负责对象的创建和组装

### 容纳 Bean

在基于 Spring 的应用中，应用对象生存在 Spring IOC 容器中;<br>

Spring 的 IOC
容器负责创建对象、装配它们，配置它们并管理它们整个生命周期，从生存到死亡;

IOC 容器是 Spring 框架的核心！ Spring容器使用 DI
管理构成应用的组件，它会创建相互协作的组件之间的关联；

Spring 容器并不是只有一个，Spring 自带了多个容器实现，可以归为两种不同类型：

- `bean工厂`(org.springframework.beans.factory.eanFactory接口定义):最简单的容器，提供基本的DI支持，
- `应用上下文`(由org.springframework.context.ApplicationContext接口定义):基于BeanFactory构建。并提供应用框架级别的服务

应用上下文 比 bean工厂 更受欢迎

Spring自带了多种类型的应用上下文：
- `AnnotationConfigApplicationContext`:从一个或多个基于Java的配置类中加载Spring应用上下文
- `AnnotationConfigWebApplicationContext`:从一个或多个基于Java的配置类中加载Spring
  Web应用上下文
- `ClassPathXmlApplicationContext`:从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源
- `FileSystemXmlapplicationcontext`:从文件系统下的一个或多个XML配置文件中加载上下文定义
- `XmlWebApplicationContext`:从Web应用中的一个或多个XML配置文件加载上下文定义

## 装配Bean

任何一个成功的应用都是由多个为了实现某一业务目标而相互协作的组件构成;

在Spring中，对象无需自己查找或创建与其所关联的其他对象，相反，容器负责把需要相互协作的对象引用赋予各个对象;

创建应用对象之间协作关系的行为通常称为**装配(wiring)**，这也是**依赖注入(DI)**的本质;

### Spring的配置的可选方案
- 在XML中进行显式配置(HelloWorld案例)
- 在Java中进行显式配置
- 隐式的bean发现机制和自动装配

建议：尽可能使用自动配置的机制，显式配置越少越好！

Spring从两个角度来实现自动化装配：

- 组件装配(component scannning)：Spring会自动发现应用上下文中所创建的bean
- 自动装配(autowiring):Spring自动满足bean之间的依赖


### 应用切面

DI能够让相互协作的软件组件保持松散藕合，而`面向切面编程`允许把遍布应用各处的功能分离出来形成可重用的组件;

面向切面编程往往被定义为促使软件系统实现关注点的分离这一项技术;

系统由许多不同的组件组成，每一个组件各负责一块特定功能，除了实现自身核心的功能之外，这些组件还承担着额外的职责；

诸如日志、事务管理和安全这样的系统服务经常融入到自身具有核心业务逻辑的组件中，这些系统服务通常被称为"横切关注点"，因为它们会跨越系统的多个组件;

如果将这些关注点分散到多个组件中去，你的代码会带来双重的复杂性：

(1) 实现系统关注点功能的代码将会重复出现在多个组件中，这意味着如果你要改变这些关注点的逻辑，就必须修改各个模块中的相关实现。即使你把这些关注点抽象为一个独立的模块，其他模块只是调用它的方法，但方法的调用还是会重复出现在各个模块中;

(2) 组件会因为那些与自身核心业务无关的代码变得混乱：如一个向地址簿添加地址条目的方法应该只关注如何添加地址，而不应该关注它是不是安全或者是否需要支持事务

AOP能够使这些服务`模块化`，并以`声明`的方式将它们应用到它们需要影响的组件中去，所造成的结果就是这些组件会具有更高的内聚性并且会更加关注自身的业务，完全不需要了解涉及系统服务所带来的复杂性，即：AOP能够确保POJO的简单性

### 使用模板消除样板式代码

Spring旨在通过模板封装来消除`样板式代码`，Spring的JDBC Template使得执行数据库操作时，避免传统JDBC样板式代码





