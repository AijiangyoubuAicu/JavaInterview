# Spring之旅

## 历史
之前的JavaEE组件：
- applet
- Java数据对象(JDO)
- JavaBean(EJB)

EJB以及JavaEE2在不断演化的同时，EJB自身也提供了面向POJO的编程模型，也采用了依赖注入(DI)和面向切面编程(AOP)，这两个特定是受Spring的成功启示的

`POJO`（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans，是为了避免和EJB混淆所创造的简称。拥有一些属性和getting和setting方法；

## 简化Java开发

- Spring是一个开源框架;
- Spring是为了解决企业级应用开发的复杂性而创建的;
- Spring可以让简单的JavaBean实现之前只有EJB才能完成的事情;
- Spring可以让任何Java应用都能在简单性、可测试性和松耦合等方面获益;

	Spring的目标是致力于全方位的简化Java开发，为了降低Java开发的复杂性，Spring采取了4种关键策略：
	
- 基于POJO的`轻量级`和`最小侵入性`编程
- 通过`依赖注入`和`面向接口`实现松耦合
- 基于切面和惯例进行`声明式编程`
- 通过切面和模板减少`样板式代码`

## 激发POJO的潜能

很多框架强迫应用继承它们的类或实现它们的接口从而导致应用和框架绑死，典型的便是EJB2时代的无状态会话bean;

Spring竭力避免因自身的API而弄乱应用代码，Spring不会强迫实现Spring规范的接口或继承Spring规范的类；

在基于Spring构建的应用中，它的类通常没有任何痕迹表明你使用过了Spring

Spring赋予POJO的魔力的方式之一就是通过`DI`来装配它们！

## DI依赖注入

DI功能是如何实现的？

	任何一个有实际意义的应用都会由两个或更多类组成，
	这些类相互之间进行协作来完成特定的业务逻辑

传统的做法：每个对象负责管理与自己相互协作的对象(即它所依赖的对象)的引用，这将导致高耦合和难以测试的代码！

耦合具有两面性(two-header beast)：
- 一方面：紧密耦合的代码难以测试、难以复用、难以理解，并且典型地表现出"打地鼠"式的BUG特点(牵一发而动全身)
- 另一方面：一定程度的耦合又是必须的，完全没有耦合的代码什么都做不了，为了完成有实际意义的功能，不同的类必须以适当的方式进行交互。
耦合是必须的，但应当小心谨慎地管理

那么通过DI，对象的依赖关系将由系统中负责协调各对象的第三方组件创建对象的时候进行设定，对象无需自行创建或管理它们的依赖关系了！

创建组件之间的协作的行为通常称为`装配(wiring)`;

Spring有多种装配方式，XML就是很常用的一种！

不管使用基于XML的配置还是基于Java的配置，DI带来的收益都是相同的；

观察如何工作的？

	Spring通过应用上下文(Application Context)装载bean的定义并把它们组装起来
	Spring应用上下文全权负责对象的创建和组装

## 应用切面

DI能够让相互协作的软件组件保持松散藕合，而`面向切面编程`允许把遍布应用各处的功能分离出来形成可重用的组件;

面向切面编程往往被定义为促使软件系统实现关注点的分离这一项技术;

系统由许多不同的组件组成，每一个组件各负责一块特定功能，除了实现自身核心的功能之外，这些组件还承担着额外的职责；

诸如日志、事务管理和安全这样的系统服务经常融入到自身具有核心业务逻辑的组件中，这些系统服务通常被称为"横切关注点"，因为它们会跨越系统的多个组件;

如果将这些关注点分散到多个组件中去，你的代码会带来双重的复杂性：

(1) 实现系统关注点功能的代码将会重复出现在多个组件中，这意味着如果你要改变这些关注点的逻辑，就必须修改各个模块中的相关实现。即使你把这些关注点抽象为一个独立的模块，其他模块只是调用它的方法，但方法的调用还是会重复出现在各个模块中;

(2) 组件会因为那些与自身核心业务无关的代码变得混乱：如一个向地址簿添加地址条目的方法应该只关注如何添加地址，而不应该关注它是不是安全或者是否需要支持事务

AOP能够使这些服务`模块化`，并以`声明`的方式将它们应用到它们需要影响的组件中去，所造成的结果就是这些组件会具有更高的内聚性并且会更加关注自身的业务，完全不需要了解涉及系统服务所带来的复杂性，即：AOP能够确保POJO的简单性

## 使用模板消除样板式代码

Spring旨在通过模板封装来消除`样板式代码`，Spring的JDBC Template使得执行数据库操作时，避免传统JDBC样板式代码

# 容纳Bean

在基于Spring的应用中，应用对象生存与Spring容器中;
	
Spring容器负责创建对象，装配它们，配置它们并管理它们整个生命周期，从生存到死亡;

容器是Spring框架的核心！
Spring容器使用DI管理构成应用的组件，它会创建相互协作的组件之间的关联；

Spring容器并不是只有一个，Spring自带了多个容器实现，可以归为两种不同类型：
- `bean工厂`(org.springframework.beans.factory.eanFactory接口定义):最简单的容器，提供基本的DI支持，
- `应用上下文`(由org.springframework.context.ApplicationContext接口定义):基于BeanFactory构建。并提供应用框架级别的服务

	应用上下文比bean工厂更受欢迎

## 应用上下文

Spring自带了多种类型的应用上下文：

`AnnotationConfigApplicationContext`:从一个或多个基于Java的配置类中加载Spring应用上下文
	
`AnnotationConfigWebApplicationContext`:从一个或多个基于Java的配置类中加载Spring Web应用上下文

`ClassPathXmlApplicationContext`:从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源

`FileSystemXmlapplicationcontext`:从文件系统下的一个或多个XML配置文件中加载上下文定义

`XmlWebApplicationContext`:从Web应用中的一个或多个XML配置文件加载上下文定义

## bean的生命周期

在bean准备就绪之前，bean工厂执行了若干启动步骤
- Spring对bean进行实例化;
- Spring将值和bean的引用注入到bean对应的属性中;
- 如果bean实现了BeanNameAware接口，Spring将bean的ID传递给setBean-Name()方法;
- 如果bean实现了BeanFactoryAware接口，Spring将调用setBean		 Factory()方法，将BeanFactory容器实例传入;
- 如果bean实现了ApplictionContextAware接口，Spring将调用setApplicationContext()方法，将bean所在的应用上下文的引用传入进来;
- 如果bean实现了BeanPosetProcessor接口，Spring将调用它们的post-ProcessBeforeInitialization()方法;
- 如果bean实现了InitializingBean接口，Spring将调用它们的after-PropertiesSet()方法，类似地，如果bean使用init-method声明了初始化方法，该方法也会被调用;
- 如果bean实现了BeanPostProcessor接口，Spring将调用它们的post-ProcessAfterInitialization()方法;
- 此时，bean已经准备就绪，可以被应用程序使用了，它们将一直驻留在应用上下文中，直到该应用上下文被销毁
- 如果bean实现了DisposableBean接口，Spring将调用它的destroy()接口方法，同样的，如果bean使用destroy-method声明了销毁方法，该方法也会被调用

# 装配Bean

任何一个成功的应用都是由多个为了实现某一业务目标而相互协作的组件构成;

在Spring中，对象无需自己查找或创建与其所关联的其他对象，相反，容器负责把需要相互协作的对象引用赋予各个对象;

创建应用对象之间协作关系的行为通常称为装配(wiring)，这也是依赖注入(DI)的本质;

## Spring的配置的可选方案
- 在XML中进行显式配置
- 在Java中进行显式配置
- 隐式的bean发现机制和自动装配

	建议：尽可能使用自动配置的机制，显式配置越少越好！

## 自动化装配bean

Spring从两个角度来实现自动化装配：

- 组件装配(component scannning)：Spring会自动发现应用上下文中所创建的bean
- 自动装配(autowiring):Spring自动满足bean之间的依赖



