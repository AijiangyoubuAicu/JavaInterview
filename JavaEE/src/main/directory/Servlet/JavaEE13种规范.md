## JDBC

全名为java database connectivity，是java数据库连接的API，为访问不同的数据库提供了一种统一的途径，像.net的ODBC一样，JDBC对开发者来说屏蔽了一些细节问题，几乎所有的关系型数据库厂商都提供JDBC服务或驱动。JDBC对数据库的访问具有平台无关性，位置透明。

这里多提一句，数据库连接池，用于管理数据库的连接，消除负载，可共享，十分安全。例如：如果没有数据库连接池，那么我们每一次和数据库的操作都需要连接数据库，如果有了数据库，我们把数据库连接信息存放在数据库连接池当中，这样极大程度减少连接次数，提高性能和效率。

利用JDBC访问数据库，有三种方法，分别为直接访问，使用DataSource（数据源）、使用statement和prepareed statements。这里重点提一下使用DataSource。使用DataSource，会现在JNDI中查找到它，然后从DataSource获得一个连接，示例图如下：

                                      


## JNDI

全名为java naming and directory interfaces，是java的命名和目录接口，为企业级应用提供统一的标准化连接，使java能够无缝的获取任何可目录化的企业信息。在JavaEE体系中，JNDI用来定位各种对象，包括EJB，数据库驱动，JDBC数据源以及消息连接等。由于JNDI是独立于目录协议的，因此还可以用JNDI访问各种特定的目录服务，如LDAP,DNS.下图对应上图：


## EJB

全名为enterprise Javabean。EJB提供了一个框架来开发和实施分布式商务逻辑，很显著得简化了具有可伸缩性和高度复杂的企业级应用的开发。接下来会提到很多次的bean，笼统得说就是一个类，一个可复用的类。

- EJB类型包含三种类型，会话bean（又分为无状态会话bean，有状态会话bean）、实体bean、消息驱动bean。

	- 无状态会话bean:执行独立才做不具有任何关联的客户端状态，但它可能会保持其实例的状态，EJB容器通常创建一个容器池和无状态的bean对象，使用这些对象来处理客户端的请求。
	- 有状态会话bean：企业bean保存客户端的会话状态类型,EJB容器创建一个单独的有状态会话bean来处理客户端的每个请求，请求范围过，有状态会话bean就会被销毁。
	- 实体bean：持久对象代表数据存储记录。
	- 消息驱动bean：EJB容器调用，接收到一个消息队列或主题，消息驱动bean是一个无状态bean来做异步任务。


## RMI

全名为remote method invoke，远程方法调用。它使用了序列化方式在客户端和服务端传递数据。RMI是一种被EJB使用的更底层的协议。


## Java IDL/CORBA

全名为Java IDL（Interface Description Language）/CORBA（Common Object Broker Architecture）Java 接口定义语言/公用对象请求代理程序体系结构。IDL是用来描述软件组件接口的一种计算机语言，通过一种中立的方式来描述来描述接口，使得在不同平台上运行的对象和用不同语言编写的程序可以相互通信交流。


## JSP

全名为java server pages，jsp页面由HTML代码和java代码组成。服务器在页面被客户端所请求以后对这些Java代码进行处理，然后将生成的HTML页面返回给客户端的浏览器。JSP可以使用Servlet提供的API，一般和JavaBean结合使用，从而将界面表现和业务逻辑分离。

##Servlet

是一种小型的Java程序，它扩展了Web服务器的功能。作为一种服务器端的应用，当被请求时开始执行。Servlet提供的功能大多与JSP类似，不过实现的方式不同。JSP通常是大多数HTML代码中嵌入少量的Java代码，而servlets全部由Java写成并且生成HTML。

## XML

XML是一种用于标记电子文件使其具有结构性的标记语言。它被用来在不同的商务过程中共享数据。XML的发展和Java是相互独立的，但是它和Java有着相同的目标，即平台独立性。通过Java和XML的组合，可以得到一个完美的具有平台独立性的解决方案。


## JMS

全名为java message service，java消息服务。JMS的客户端之间可以通过JMS服务进行异步的消息传输。JMS用于和面向消息的中间件相互通信的应用程序接口(API)。它既支持点对点的域，有支持发布/订阅(publish/subscribe)类型的域，并且提供对下列类型的支持：经认可的消息传递,事务型消息的传递，一致性消息和具有持久性的订阅者支持。

## JTA

全名为java transaction API，java事务API。在JavaEE应用中，事务是一个不可或缺的组件模型，它保证了用户操作ACID（即原子、一致、隔离、持久）属性。对于那些跨数据源（例如多个数据库，或者数据库与JMS）的大型应用，则必须使用全局事务JTA。应用系统可以由JTA定义的标准API访问各种事务监控，JTA为JavaEE平台提供了分布式事务服务，它隔离了事务与底层的资源，实现了透明的事务管理方式。

##JTS

全名为java transaction service，java事务服务。JTS是一个组件事务监视器。JTS是CORBA OTS事务监控的基本实现。JTS规定了事务管理器的实现方式。JTS事务管理器为应用服务器、资源管理器、独立的应用以及通信资源管理器提供了事务服务。

## JavaMail

是用于存取邮件服务器的API，它提供了一套邮件服务器的抽象类。不仅支持SMTP服务器，也支持IMAP服务器。vaMail.

## JAF

全名为javabean activation framework，JavaMail利用JAF来处理MIME编码的邮件附件。MIME的字节流可以被转换成Java对象，或者转换自Java对象。大多数应用都可以不需要直接使用JAF
接：https://blog.csdn.net/weienjun/article/details/78883439