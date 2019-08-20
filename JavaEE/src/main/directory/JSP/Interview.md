# JSP 面试题汇总

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