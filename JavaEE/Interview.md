# JavaEE概述

## Java Web 通常包含哪些常用的技术规范（组件）？
Java Web 通常包含如下技术规范：

- JSP 和 Servlet：Servlet的作用是`处理请求生成响应`；JSP 的本质其实就是 Servlet，所有 JSP 页面都需要先编译成 Servlet 

- Filter：Filter 的作用是对用户请求或响应进行`过滤`，它可以对用户请求进行预处理，也可以对响应进行后处理。

- Listener：Listener 就是`监听器`。可以用不同的 Listener 监听不同的事件

- JSTL 标签库：标签库是一种优秀的`表现层技术`。通过标签库，可以在简单的标签中封装复杂的数据展示逻辑。

- EL 表达式语言：EL 表达式语言并不是真正的编程语言，它只是一种数据访问语言，通常用于访问 JavaWeb 应用各范围内的数据。

- JDBC：建立与数据库连接的一套规范，用于建立与不同数据库之间的连接

## HTTP 请求的 GET 和 POST 的区别？

- GET 方式的请求：直接在浏览器地址栏输入访问地址所发送的请求或提交表单发送请求时，该表单对应的 form 元素没有
设置 method 属性，或设置 method 属性为 get，这几种请求都是 GET 方式的请求。

- POST 方式的请求：这种方式通常使用提交表单（由 form HTML 元素表示）的方式来发送，且需要设置 form 元素的 method 属性为 post。

- 数据的可见性
	- GET 方式的请求会将请求参数的名和值转换成字符串，并附加在原 URL 之后，如?username=fkjava&password=123，因此可以在地址栏中看到请求参数名和值。
	- POST 请求使用请求正文提交请求数据，因此用户不可见。
	
- 数据的大小
	- GET 请求传送的数据量较小，一般不能大于 2KB。POST 方式传送的数据量较大，
	- POST 通常认为请求参数的大小不受限制，只取决于服务器的限制。

- 编码方式

	Java Web 使用 request 对象获取请求信息，我们可以使用 request.setCharacterEncoding 方法修改请求的字符编码信息，
	但是不能修改地址栏字符编码。
	
	- GET 请求从地址栏传递信息，因此不能使用 request.setCharacterEncoding 方法去修改字符编码。
	- POST 从请求正文以 form 表单形式提交，所以可以使用 request.setCharacterEncoding 这个方法去修改字符编码。

# Servlet
## 什么是Servlet

Servlet 是采用Java语言编写的服务端程序，它可以运行于Web服务器中的Servlet容器中；
其主要功能是提供请求/响应的Web服务模式，可以生成动态的Web内容中，这正是HTML所不具备的功能

## Servlet的优点

- 只需要启动一个操作系统进程及加载一个JVM，大大降低了系统的开销
- 如果多个请求需要做同样的处理的时候，这时候需要加载一个类，这大大降低了开销
- 所有动态加载的类可以实现对网络协议以及解码的请求的共享，大大降低了工作量
- Servlet能直接和Web交互，而普通CGI程序却不能，Servlet还能在各个程序之间共享数据，使数据库线程池类的功能很容易实现
			
>CGI:通用网关接口（Common Gateway Interface/CGI）是一种重要的互联网技术，可以让一个客户端
从网页浏览器向执行在网络服务器上的程序请求数据。CGI描述了服务器和请求处理程序之间传输数据的一种标准。
			
>补充：Sun Microsystems公司在1996年发布Servlet技术就是为了和CGI进行竞争，Servlet是一个特殊的Java程序，
一个基于Java的Web应用通常包含一个或多个Servlet类。Servlet不能够自行创建并执行，它是在Servlet容器中运行的，
容器将用户的请求传递给Servlet程序，并将Servlet的响应回传给用户。通常一个Servlet会关联一个或多个JSP页面。
以前CGI经常因为性能开销上的问题被诟病，然而Fast CGI早就已经解决了CGI效率上的问题，所以面试的时候大可不必信口开河的诟病CGI，
事实上有很多你熟悉的网站都使用了CGI技术。

		
## Servlet执行流程

## 转发(Forward)和重定向(Redirect)的区别
	
转发是服务器行为，重定向是客户端行为；
	
转发(Forward)是通过RequestDiaptcher对象的forward()方法实现的，RequestDispatcher可通过HttpServletRequest和getRequestDispatcher()方法获得
	
重定向(Redirect)是利用服务器返回的状态码来是实现的，客户端浏览器请求服务器的时候，服务器会返回一个状态码；
服务器通过HttpServletResponse和setStatus(int status)方法设置状态码，如果服务器返回301或者302，则浏览器
会到新的网址重新请求该资源；
	
两者的区别：
- 从地址显示来说
	- forWard是服务器请求资源，服务器直接访问目标地址的URL，把那个URL的响应内如读取过来，然后把这些内容再发给浏览器，浏览器根本不知道服务器发送的内容从哪里来的，所以它的地址栏还是原来的地址；
	- redirect是服务端根据逻辑发送的一个状态码，告诉浏览器重新去请求那个地址，所以地址栏显示的是新的URL；
			
- 从数据共享来说
	- forWard：转发页面和转发的页面可共享request里面的数据
	- redirect：不能共享数据
			
- 从运用地方来说
	- forWard：一般用于用户登录的时候，根据角色转发到相应的模块
	- redirect：一般用于用户注销登录时返回主页和跳转到其他的网站等
		
- 从效率来说：
	- forWard：高
	- redirect：低
			
# JSP 面试题汇总
## JSP 是什么？有什么特点？

JSP 全称是 Java Server Pages，它和 Servlet 技术一样，都是 Sun 公司（已被 Oracle 收购）定义的一种
用于`开发动态Web站点的技术`。JSP 通过在 HTML 页面中`直接嵌入` Java 脚本，从而使得页面可以显示动态数据

相比 Servlet 在 Java 代码中嵌入 HTML 标签，JSP 在页面显示上具有更方便的优势，
JSP 的本质还是 Servlet，JSP 会由 Web 服务器编译成 Servlet，因此 JSP 实际上还是以 Servlet 的形式在运行

在实际开发中，通常会使用 MVC 模式开发，其中 Servlet 充当控制器，Servlet 负责处理请求、并调用
Service 等组件处理请求，并通过 Service 等组件获取数据，而 JSP 只是充当视图，负责数据的展现工作

## JSP 页面包含哪些语法？它们具有什么特征？

JSP 页面可包含如下 4 种语法：

- JSP 注释：它的语法格式为：<%-- 注释 --%>，JSP 注释与 HTML 注释的区别在于：JSP 注释是服
务端注释，当 Web 服务器处理编译 JSP 页面时，它就会忽略这些 JSP 注释，JSP 编译生成的 Servlet
并不包含 JSP 注释，因此 JSP 注释不会输出到浏览器。而 HTML 注释则会输出到浏览器

- JSP 声明：它的语法是：<%! 声明 %>。JSP 声明对应于 Servlet 的成员变量部分，因此 JSP 声明语
法内可定义成员变量、方法、内部类，而且这些成员变量、方法也可使用 private、protected、public、
static 等修饰符修饰。由于 JSP 声明的内容属于该 Servlet 的成员，因此它们可以在所有脚本中使用

- JSP 脚本（也可叫 Java 脚本）：它的语法是：<% 声明 %>。JSP 脚本对应于 Servlet 的 service 方法
中执行代码，因此 JSP 脚本中只能定义局部变量和放置可执行性语句，JSP 脚本中定义的局部变量不
能使用 private、protected、public、static 等修饰符修饰，唯一可使用的修饰符是 final

- 表达式（也叫输出表达式）：它的语法是：<%= 表达式%>，这种语法比较简单，只能用于在页面
上输出表达式的值。JSP 表达式对应于 JSP 脚本对应于 Servlet 的 service 方法中的一条 out.writeln(表
达式)语句

## JSP 的编译指令有哪些？
JSP 使用编译指令的语法为：

	<%@ 编译指令名 属性名="属性值"…%>
	
JSP 编译指令有如下 3 条：
- page：该指令是针对当前页面的指令，通常用于对该页面指定某些设置信息，比如该页面的字符集、
该页面需要导入的 Java 包。一个 JSP 页面可以包含多条 page 指令

- include：用于指定包含另一个页面。这种包含被称为静态包含。一个 JSP 页面可以包含多条 include指令

- taglib：用于导入定义标签库。一个 JSP 页面可以包含多条 taglib 指令

## JSP 中动态 include 与静态 include 的区别？

- 动态 include 用 <jsp:include.../> 动作指令实现，适合用于包含动态页面，并且可以带参数，
动态 include不会导入被 include 页面的编译指令，仅仅将被导入页面的 body 内容插入本页面

- 静态 include 用 <%@ include file=included.htm %> 编译指令实现

归纳起来，静态导入和动态导入有如下三点区别：
- 静态导入是将被导入页面的代码完全融入，两个页面融合成一个整体 Servlet；而动态导入则在Servlet 中使用 include 方法来引入被导入页面的内容
- 静态导入时被导入页面的编译指令会起作用；而动态导入时被导入页面的编译指令则失去作用，只是插入被导入页面的 body 内容
- 动态包含还可以增加额外的参数

## JSP 有哪些动作指令？分别是什么？

JSP 动作指令主要有如下 7 个

- jsp:forward：执行页面转向，将请求的处理转发到下一个页面
- jsp:param：用于传递参数，必须与其他支持参数的标签一起使用
- jsp:include：用于动态包含一个 JSP 页面
- jsp:plugin：用于下载 JavaBean 或 Applet 到客户端执行
- jsp:useBean：创建一个 JavaBean 的实例
- jsp:setProperty：设置 JavaBean 实例的属性值
- jsp:getProperty：输出 JavaBean 实例的属性值

## JSP 有哪些内置对象？作用分别是什么？

JSP 共有以下 9 个内置的对象：

- application：javax.servlet.ServletContext 的实例，该实例代表 JSP 所属的 Web 应用本身，可用于 JSP页面，或者在 Servlet 之间交换信息

- config：javax.servlet.ServletConfig 的实例，该实例代表该 JSP 的配置信息

- exception：java.lang.Throwable 的实例，该实例代表其他页面中的异常和错误。只有当页面是错误处理页面，
即编译指令page的isErrorPage属性为true时，该对象才可以使用

- out：javax.servlet.jsp.JspWriter 的实例，该实例代表 JSP 页面的输出流，用于输出内容，形成 HTML页面

- page：代表该页面本身，通常没有太大用处。也就是 Servlet 中的 this，其类型就是生成的 Servlet类，能用 page 的地方就可用 this

- pageContext：javax.servlet.jsp.PageContext 的实例，该对象代表该 JSP 页面上下文，使用该对象可以访问页面中的共享数据

- request：javax.servlet.http.HttpServletRequest 的实例，该对象封装了一次请求，客户端的请求参数都
被封装在该对象里。这是一个常用的对象，获取客户端请求参数必须使用该对象
   
- response：javax.servlet.http.HttpServletResponse 的实例，代表服务器对客户端的响应。通常很少使
用该对象直接响应，而是使用 out 对象，除非需要生成非字符响应。而 response 对象常用于重定向
   
- session：javax.servlet.http.HttpSession 的实例，该对象代表一次会话。当客户端浏览器与站点建立连
接时，会话开始；当客户端关闭浏览器时，会话结束

## JSP 和 Servlet 有哪些相同点和不同点？

JSP 的本质就是 Servlet，JSP 经过 Web 服务器编译之后就变成了 Servlet，因此它们的生命周期、运行机制完全是相同的

Servlet 和 JSP 最主要的不同点在于表现形式：
- Servlet 是一个继承 HttpServlet 的 Java 类，
- JSP 则是在 HTML 页面中嵌入 JSP 脚本，嵌入之后组合成一个扩展名为.jsp 的页面文件。

在实际项目开发当中，JSP 侧重于视图，Servlet 主要用于控制逻辑

## JSTL 是什么？优点有哪些？

JSTL（JSP Standard Tag Library，JSP 标准标签库）是 Java 官方提供的开放源代码的标砖标签库标签库，
主要由四个标准的标签库（core、format、xml、sql）组成。优点有：

- 可以简化 Java Web 的开发，JSTL 已经提供平时开发所需的各种通用标签，因此开发者基本不需要编写自定义标签

- 通过 JSTL 可以避免在 JSP 页面中使用 Java 脚本来进行控制，在实际企业开发中，通常都会禁止在JSP 页面上输出 Java 脚本

## 如何避免 JSP 页面自动生成 session 对象？为什么要这么做？

在默认情况下，当浏览器对 JSP 页面发出请求时，如果 session 还没有建立，那么 Web 服务器就会自
动为该请求创建一个 session 对象，但是 session 是比较消耗资源的，如果没有必要保持和使用 session，
就不应该创建 session，例如一些只是做产品展示、公司简介网页，就没必要使用 session 来保存信息。
可以在 JSP 中使用 page 指令设置来避免 JSP 页面为每个请求都自动创建 session。实例代码如下：

	<%@page session="false"%> 
	
## EL 表达式的功能？为什么要用 EL 表达式？

EL 的全称是 Expression Language（表达式语言），它主要功能包括：

- 从四个域对象中读取数据数据并显示。
- 读取请求参数数据并显示。
- 读取 Cookie 并显示
- 支持丰富的运算符

EL 是 JSP 2.0 引入的功能，通过 EL 可以方便地访问、显示数据。传统的 JSP 脚本、JSP 表达式用于显示数据则比较麻烦，它们往往存在如下缺点：
   
- 需要在 JSP 页面中嵌入 JSP 脚本
- 往往需要判断
- 有时候还需要进行类型转换			
			
# Filter 与 Listener

- Filter 是什么？有什么作用？
- Listener 是什么？有什么作用？

## Filter 是什么？有什么作用？

Filter 是过滤器，它既可以对用户请求进行预处理，也也可以对响应进行后处理。Struts 2 的核心控制
器就是使用一个 Filter 实现的。Filter 可负责拦截多个请求或响应；一个请求或响应也可被多个 Filter 拦截。

常用的 Filter 有如下：
- 用户授权的 Filter：Filter 负责检查用户请求，根据请求过滤用户非法请求。
- 日志 Filter：详细记录某些特殊的用户请求。
- 负责解码的 Filter：包括对非标准编码的请求解码

## Listener 是什么？有什么作用？

Listener 是指 Servlet 中的监听器。

Listener 可以对 ServletContext 对象、HttpSession 对象、ServletRequest 对象进行监听。既可监听
ServletContext 对象、HttpSession 对象、ServletRequest 对象的开始和结束，也可监听它们对应范围的属性的改变。常用的 Listener 有如下几个：

- ServletContextListener：监听 Web 应用的启动和结束
- HttpSessionListener：监听用户 Session 的开始和结束
- ServletRequestListener：监听用户请求
- ServletContextAttributeListener：监听 application 范围的属性的改变
- HttpSessionAttributeListener：监听 session 范围的属性的改变
- ServletRequestAttributeListener：监听 request 范围的属性的改变