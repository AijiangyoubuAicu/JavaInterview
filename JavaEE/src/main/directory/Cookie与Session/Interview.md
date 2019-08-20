# Cookie与Session的面试题汇总

- Servlet 的会话机制？
- cookie 和 session 的作用、区别、应用范围？

## Servlet 的会话机制？

因为 HTTP 协议是无状态协议，又称为一次性连接，所以 webapp 必须有一种机制能够记住用户的一系列操作，并且唯一标示一个用户
- Cookie：就是使用一个短文本保存用户信息，在页面加载完毕是通过响应写回客户端进行保存。
- Session：在服务器保存数据，Session 就是单个客户的一块内存，用以存储数据。

Tomcat 的 Session 是 HashMap 的实现

当 request.getSession()时 Session 对象被服务器创建，并且产生一个唯一的 SessionID，
SessionID 会通过 Cookie 写回客户端进行保存。如果 Cookie 被客户端禁用，只能使用 URL 重写机制。
Session 对象可以使用 setAttribute(String name,Object o)将对象存储在 Session 作用范围域中。Session
作用范围域是在浏览器打开到浏览器关闭。


## cookie 和 session 的作用、区别、应用范围？

- cookie 数据保存在客户的电脑上，session 数据保存在服务端

- cookie 不是安全的，别人可以读取、甚至修改客户端电脑上的 cookie，甚至可进行 cookie 欺骗，因
	cookie 不适合保存安全性相关的数据，安全性要求较好的数据应使用 session 保存到服务端
	
- session 会在一定时间内保持在服务器上，但是会占用内存资源，当访问的用户过多，会加重服务器
	的负载，考虑到减轻服务器的压力，可以将不重要的数据放在 cookie 中持久的保存
	
- 单个 cookie 保存的数据不能超过 4k，很多浏览器都限制站点最多保存 20 个 cookie
