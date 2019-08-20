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
			
			
			
				
			