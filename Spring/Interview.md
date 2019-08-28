## Spring 面试题汇总

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

## 什么是 Spring？

Spring 是一个`轻量级的`、`非侵入性的`开源框架，最重要的核心概念是`IoC`和`AOP`。以此为基础，Spring
上可以与各种主流的 MVC 框架整合（Spring 本身也提供了 Spring MVC 框架），下可以与各种主流的
ORM 框架、JDBC 整合，并对持久层、提供了优秀的事务支持；
通过使用 Spring，我们能够减少`类之间的依赖性`和`程序之间的耦合度`，最大程度的实现`松耦合`，使程
序更加灵活，具有更好的可扩展性。使用 Spring，可让开发人员真正的专注于业务逻辑实现，而不是代码。

## Spring 有哪些优点？

总结起来，Spring 具有如下优点

- `轻量级`:此处的轻量级并不是说 Spring 框架的 JAR 包有多大，而是说 Spring 框架无需依赖任何特定平台和容器。Spring 既可在 Java SE 环境下运行，也可以在 Tomcat 中运行。
- `低侵入式设计`，代码的污染极低。
- `控制反转（IoC）`：Spring 的 IoC 容器降低了业务对象替换的复杂性，提高了组件之间的解耦。
- `面向切面编程（AOP）`：Spring 的 AOP 支持允许将一些通用任务如安全、事务、日志等进行集中式处理，从而提供了更好的复用。
- Spring 的 ORM 和 DAO 支持提供了`与第三方持久层框架的良好整合`，并简化了底层的数据库访问。
- Spring 框架可以与各种 Java EE 框架整合，Spring 的`高度包容性`使得它成为 Java EE 开发中的必选框架。
- Spring 的`高度开放性`，并不强制应用完全依赖于 Spring，开发者可自由选用 Spring 框架的部分或全部。 

## Spring 框架中都用到了哪些设计模式？

Spring 框架中使用到了大量的设计模式，下面列举了比较有代表性的：

- `工厂模式`：Spring 本身就是一个超级大工厂，Spring 容器负责创建所有 Bean，因此 Spring 框架本身就是从工厂模式扩展而来的。
- `单例模式`：容器中 singleton Bean 都是单例的。
- `代理模式`：Spring AOP 就是基于代理模式的，由于所有 AOP 代理和目标对象之间的关系就是代理和目标之间的关系。
- `策略模式`：Spring 的事务控制、资源访问都是策略模式的典型应用。其中事务控制的策略接口就是PlatformTransactionManager，该接口定义了事务控制的 3 个核心方法，Spring 为该策略接口提供了大
	量的策略实现类；资源访问的策略接口是 Resource 接口，Spring 为该接口提供了大量的策略实现类。

## 什么是 Spring Bean？

Spring 的 Bean 就是 Spring 容器管理的 Java 对象，因此 Spring 容器的 Bean 并不是 Java Bean

传统的 JavaBean 和 Spring 中的 Bean 存在如下区别:
- 用处不同：
	- 传统的 JavaBean 更多是作为`值对象传递参数`；
	- Spring 的 Bean 用处几乎无所不包，任何Java 对象都可被称为 Bean。
- 写法不同：
	- 传统的 JavaBean 作为`值对象`，要求每个属性都提供 getter 和 setter 方法；
	- Spring 的Bean 只需为接受`设值注入`的属性提供 setter 方法即可。
- 生命周期不同：
	- 传统的 JavaBean 作为`值对象`传递，不接受任何容器管理其生命周期；
	- Spring 中的 Bean 由 Spring 管理其生命周期行为。

## Spring 框架中单例 Bean 是线程安全的吗？

Spring 框架并不保证 Bean 的线程安全。因此 Spring 框架中的单例 Bean 通常不是线程安全的。
如果开发者希望单例 Bean 在多线程环境下使用，则建议自己通过代码来保证该 Bean 是线程安全的。

## Spring 中的依赖注入是什么？

当 A 组件需要调用 B 组件的方法时，我们称为 A 组件`依赖` B 组件。A 组件称为`调用者`，B 组件成为`被依赖对象`。

在使用依赖注入之前，调用者要么显式 new 一个被依赖对象，要么通过工厂获取被依赖对象。

使用 Spring 框架之后，调用者无须主动获取被依赖对象，调用者只要被动接受 Spring 容器为调用者的成员变量赋值即可（只要配置一个<property.../>子元素，Spring 就会执行对应的 setter 方法为调用者
的成员变量赋值）。

由此可见，使用 Spring 框架之后，调用者获取被依赖对象的方式由原来的主动获取，变成了`被动接受`——将这种方式称为`控制反转`。

从 Spring 容器的角度来看，Spring 容器负责将被依赖对象赋值给调用者的成员变量——相当于为调用者注入它依赖的实例，这种方式称为`依赖注入`。

## Spring IoC 容器是什么？IoC 有什么优点？

Spring IoC 容器就相当于一个大工厂，Spring 容器中中所有 Bean 都由该工厂负责创建、管理；

IoC 容器负责`创建` Bean、`管理` Bean 之间的`依赖关系`（通过依赖注入）、`整合` Bean、`管理` Bean 的`生命周期`；

IOC 或依赖注入减少了应用程序的代码量。它使得应用程序的测试很简单，因为在单元测试中不再需
要单例或 JNDI 查找机制。简单的实现以及较少的干扰机 制使得松耦合得以实现。IOC 容器支持`勤性单例`及`延迟加载`服务。

## Bean factory.Factory 和 ApplicationContext 有什么区别？

(1) Spring 容器最基本的接口就是 `BeanFactory`。BeanFactory 负责配置、创建、管理 Bean，它有一个子接口：`ApplicationContext`，因此也被称为 `Spring上下文`。

(2) ApplicationContext 是 BeanFactory 的子接口，因此功能更强大。对于大部分 Java EE 应用而言，使用它作为 Spring 容器更方便。

常用实现类有：
- `FileSystemXmlApplicationContext`
- `ClassPathXmlApplicationContext`
- `AnnotationConfigApplicationContext`

(3) 除了提供 BeanFactory 所支持的全部功能外，ApplicationContext 还有很多额外的功能。
   
	- ApplicationContext 默认会预初始化所有的 singleton Bean，也可通过配置取消预初始化。
	- ApplicationContext 继承 MessageSource 接口，因此提供国际化支持。
	- 资源访问，比如访问 URL 和文件。
	- 事件机制。
	- 同时加载多个配置文件。
	- 以声明式方式启动并创建 Spring 容器。

## IoC 和 DI 的区别？

- IoC 是从`调用者的角度`来说的，以前调用者需要主动去获取被依赖对象，使用 IoC 容器之后，调用者只要`被动地接收`容器为之注入被依赖对象，控制关系反过来了，因此称为控制反转（IoC）。
- DI 是从` IoC 容器的角度`来说的，IoC 容器负责将被依赖对象注入调用者，因此被称为依赖注入（DI）。

## 有哪些不同类型的依赖注入（IoC）？

   主要有 3 种
- `设值注入`：IoC 容器使用成员变量的 setter 方法来注入被依赖对象。
- `构造器注入`：IoC 容器使用构造器来注入被依赖对象。
- `接口注入`：让调用者 Bean 实现特定接口，IoC 容器检测到该 Bean 实现该接口后会自动调用该 Bean

 >特定的 setter 方法，调用 setter 方法时将被依赖对象注入调用者 Bean。典型的，Bean 获取 Spring 容器、Bean 获取自身的配置 ID 分别要实现 ApplicationContextAware、BeanNameAware 接口，这就是接口注入。
 
  对于普通开发来说，通常使用的是设值注入和构造器注入。
  
## 什么是 Bean wiring（Bean 装配）？

所谓 Bean 装配，说的就是管理 Bean 之间的依赖关系：当 A 组件需要调用 Bean 组件时，IoC 容器自动将被依赖的 B 组件注入 A 组件，这就完成了 A、B 组件的装配。

## 什么是 Bean 自动装配？解释各种自动装配模式

所谓自动装配指的是使用 ref 显式指定依赖 Bean（也不使用@Resource 注解），而是由 Spring 容器检查 XML 配置文件内容，根据某种规则，为调用者 Bean 注入被依赖的 Bean。

自动装配可通过<beans.../>元素的default-autowire属性指定，该属性对配置文件中所有的Bean起作用；
也可通过<bean.../>元素的 autowire 属性指定，该属性只对该 Bean 起作用。

自动装配支持如下模式（也就是 autowire 属性支持的值）

1。 no：不使用自动装配。Bean 依赖必须通过 ref 元素定义。这是默认的配置，在较大的部署环境中不鼓励改变这个配置，显式配置合作者能够得到更清晰的依赖关系。

2. byName：根据 setter 方法名进行自动装配。Spring 容器查找容器中的全部 Bean，找出其 id 与 setter
方法名去掉 set 前缀、并小写首字母后同名的 Bean 来完成注入。如果没有找到匹配的 Bean 实例，则Spring 不会进行任何注入。

3. byType：根据 setter 方法的形参类型来自动装配。Spring 容器查找容器中的全部 Bean，如果正好有
一个 Bean 类型与 setter 方法的形参类型匹配，就自动注入这个 Bean；如果找到多个这样的 Bean，就
抛出一个异常；如果没找到这样的 Bean，则什么都不会发生，setter 方法不会被调用。

4. constructor：与 byType 类似，区别是用于自动匹配构造器的参数。如果容器不能恰好找到一个与构造器参数类型匹配的 Bean，则会抛出一个异常。

5. autodetect：Spring 容器根据 Bean 内部结构，自行决定使用 constructor 或 byType 策略。如果找到一个默认的构造函数，那么就会应用 byType 策略

## @Required 注解？
@Required 表明 Bean 的属性必须在配置时设置，为了避免开发者的疏忽，可以让 Spring 在创建容器
时就执行检查，此时需要为 setter 方法添加@Required 修饰，此时 Spring 会检查该 setter 方法：

如果开发者既没有显式通过<property.../>配置依赖注入；也没有使用自动装配执行依赖注入，Spring 容器会报异常：BeanInitializationException

## @Autowired 注解？
Spring 提供了@Autowired 注解来指定自动装配，@Autowired 可以修饰 setter 方法、普通方法、实例
变量和构造器等。当使用@Autowired 标注 setter 方法时，默认采用 byType 自动装配策略。

## @Qualifier 注解？
为了实现精确的自动装配，Spring 提供了@Qualifier 注解，通过使用@Qualifier，允许根据 Bean 的 id来执行自动装配

## 自动装配有哪些局限性？

自动装配有如下局限性：
1. 自动装配不支持标量类型：如果属性类型是 8 个基本类型及其包装类、String 类型，自动装配都不
能工作。
2. 模糊特性：自动装配不如显式指定依赖精确。
可见：自动装配可以减少配置文件的工作量，但降低了依赖关系的透明性和清晰性

## 什么是 AOP？
AOP 为 Aspect Oriented Programming 的缩写，意为：`面向切面编程（也叫面向方面）`，可以通过`预编
译方式`和`运行期动态代理`实现在不修改源代码的情况下给程序动态地、统一添加特定功能的一种技术。

AOP 是目前软件开发中的一个热点，也是 Spring 框架中的一个重要内容。利用 AOP 可以对`业务逻辑的各个部分进行隔离`，
从而使得业务逻辑各部分之间的`耦合度降低`，提高程序的`可重用性`，同时提高了开发的效率。

AOP 是 OOP 的延续，主要的功能是：日志记录，性能统计，安全控制，事务处理，异常处理等等在 Spring 中提供了 AOP 的丰富支持，
允许通过分离应用的业务逻辑与系统级服务（例如审计（auditing）和事务（transaction）管理）进行内聚性的开发。
应用对象只实现它们应该做的——完成业务逻辑——仅此而已。它们并不负责（甚至是意识）其他的系统级关注点，例如日志或事务支持。
 
## 什么是目标对象？
目标对象就是还没有被 AOP 框架所修改、增加的对象。目标对象将会被 AOP 框架进行修改、增强处
理，因此也被称为“被增强的对象”。如果 AOP 框架采用的是动态 AOP 实现，那么该对象就是一个被代理的对象。

## 什么是代理？
代理就是 AOP 框架所创建的对象，简单地说，代理就是对目标对象的加强。Spring 中的 AOP 代理可
以是 `JDK 动态代理`，也可以是` CGLIB 代理`。前者为实现接口的目标对象的代理，后者为不实现接口的目标对象的代理。

## Spring 的 AOP 代理有什么实现方式？

Spring AOP 代理有两种实现方式：

- 若目标对象实现了若干接口，Spring 使用 JDK 的 java.lang.reflect.Proxy 类代理。
	- 优点：因为有接口，所以使系统更加松耦合。
	- 缺点：为每一个目标类创建接口。
- 若目标对象没有实现任何接口，Spring 使用 CGLIB 库生成目标对象的子类。
	- 优点：因为代理类与目标类是继承关系，所以不需要有接口的存在。
	- 缺点：因为没有使用接口，所以系统的解耦不如使用 JDK 的动态代理好。

## Spring 中 AOP 的应用场景、AOP 原理、好处？

AOP 专门用于处理系统中分布于各个模块（不同方法）中的交叉关注点的问题，在 Java EE 应用中，
常常通过 AOP 来处理一些具有横切性质的系统级服务，如事务管理、安全检查、缓存、对象池管理等，AOP 已经成为一种非常常用的解决方案。

通俗来说，当我们需要为项目中某一批方法（分布于各个模块）增加某种通用的功能。此时 AOP 可达到的效果是，
保证在程序员不修改源代码的前提下，为系统中业务组件的多个业务方法添加某种通用功能。

AOP 框架的本质是，依然要去修改业务组件的多个业务方法的源代码——只是这个修改由 AOP 框架完成，程序员不需要修改！

AOP 实现可分为两类（按 AOP 框架修改源代码的时机）:
1. 静态 AOP 实现：AOP 框架在编译阶段对程序进行修改，即实现对目标类的增强，生成静态的 AOP代理类（生成的*.class 文件已经被改掉了，需要使用特定的编译器）。以 AspectJ 为代表。

2. 动态 AOP 实现：AOP 框架在运行阶段动态生成 AOP 代理（在内存中以 JDK 动态代理或 cglib 动态地生成 AOP 代理类），以实现对目标对象的增强。以 Spring AOP 为代表。

AOP 编程的优点：
1. 各步骤之间的良好隔离性，大大降低耦合度。

2. 源代码无关性，为项目扩展新功能时不需要修改源代码。

## 介绍 Spring 支持的 5 种 Advice（增强处理）

Spring 可以支持以下五种类型的 Advice：

- before Advice（前置增强处理）：在目标方法执行之前织入的 Advice。
- after Advice（最终增强处理）：在目标方法执行结束后（不论是正常返回还是异常退出）织入的Advice。
- after-returning Advice（后置增强处理）：在目标方法正常完成之后织入的 Advice。
- after-throwing Advice（异常增强处理）：在目标方法由于未捕获异常结束之后织入的 Advice。
- around Advice（环绕增强处理）：在目标方法执行前后都织入的 Advice。

## 引入（Introduction）和织入（Weaving）的区别？

引入和织入都是 AOP 框架对目标对象的修改方式。

- `引入`指的是为被处理的类添加方法或字段，Spring 允许将新的接口引入到任何被处理的对象。
- `织入`指的是将 Advice 添加到目标对象中，并创建一个被增强的对象（AOP 代理）的过程。织入有两
种实现方式——编译时增强（如 AspectJ）和运行时增强（如 Spring AOP）。Spring 和其他纯 Java AOP
框架一样，在运行时完成织入。

## Spring 支持哪些 ORM？

现在 Spring 主要支持 Hibernate 和 JPA 这两种持久化技术。
但实际上由于 Spring 现在已经是 Java EE 领域最流行的框架，因此基本上所有的 ORM 技术都可以与Spring 整合。

## Spring 的事务管理有哪些优点？

- 为不同的事务 API（如 JTA、JDBC、Hibernate、JPA）提供了统一的编程模型
- 支持声明式事务管理
- 为编程式事务提供了简化的、统一的编程 API
- 可以和 Spring 的多种数据访问技术很好地整合

## Spring 支持的事务管理类型？
Spring 支持如下两种方式的事务管理方式：
- 编程式事务，通过开发者自行编写程序来控制事务。通常可选择面向 PlatformTransactionManager或 TransactionTemplate 进行编程。这种方式带来了很大的灵活性，但很难维护。

- 声明式事务，在配置文件或注解中配置事务（推荐使用）。这种方式可将事务管理代码和业务代码分离。只需通过注解或者 XML 配置即可管理事务。因此具有很好的可维护性。

声明式事务又分为两种：

- 基于`XML`的声明式事务
- 基于`注解`的声明式事务

>推荐使用`声明式事务`，这种方式可将事务管理代码和业务代码分离。只需通过注解或者 XML 配置即可管理事务。因此具有很好的可维护性。
但在一些有特殊要求的事务控制场景下，也可以通过少量的编程式事务进行辅助

