# JavaEE概述 面试题汇总

- Java Web 通常包含哪些常用的技术规范（组件）？
- HTTP 请求的 GET 和 POST 的区别？

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

