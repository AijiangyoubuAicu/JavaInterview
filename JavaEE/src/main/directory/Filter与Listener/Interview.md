# Filter 与 Listener 的面试题汇总

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