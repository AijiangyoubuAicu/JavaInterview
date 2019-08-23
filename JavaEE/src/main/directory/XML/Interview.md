## XML 是什么？

XML 即**可扩展标记语言（Extensible Markup language）**，你可以根据自己的需要**扩展 XML**。
XML 中可以轻松定义<books>, <orders>等自定义标签，而在 HTML 等其他标记语言中必须使
用**预定义**的标签，比如<p>，而不能使用用户定义的标签。使用 DTD 和 XML Schema 标准化
XML 结构。XML 主要用于从一个系统到另一系统的数据传输，比如企业级应用的客户端与服务端

## XML 与 HTML 的区别是什么？
- XML 文档区分大小写，而 HTML 文档区分大消息
- 在 HTML 文档中当存在列表键时，可省略结尾标记，而在 XML 文档中所有的标记不能省略
- 在 XML 文档中，属性值必须写在引号中，而在 HTML 文档中没有严格的规定

## DTD 与 XML Schema 有什么区别？
DTD 与 XML Schema 有以下区别：DTD 不使用 XML 编写而 XML Schema 本身就是 xml 文
件，这意味着XML解析器等已有的XML工具可以用来处理XML Schema。而且XML Schema 是
设计于 DTD 之后的，它提供了更多的类型来映射 xml 文件不同的数据类型。DTD 即文档类
型描述(Document Type definition)是定义 XML 文件结构的传统方式

## XPath 是什么？
XPath 是用于从 XML 文档检索元素的 XML 技术。XML 文档是结构化的，因此 XPath 可
以从 XML 文件定位和检索元素、属性或值。从数据检索方面来说，XPath 与 SQL 很相似，但
是它有自己的语法和规则

## XSLT 是什么?
XSLT 也是常用的 XML 技术，用于将一个 XML 文件转换为另一种 XML，HTML 或者其他
的格式。XSLT 为转换 XML 文件详细定义了自己的语法，函数和操作符。通常由 XSLT 引擎完成转换，XSLT 引擎读取 XSLT 
语法编写的 XML 样式表或者 XSL 文件的指令。XSLT 大量使用递归来执行转换。一个常见 XSLT 
使用就是将 XML 文件中的数据作为 HTML 页面显示。XSLT 也可以很方便地把一种 XML 文件转换为另一种 XML 文档

## 什么是 XML 元素和属性
下面是简单的 XML 片断
```xml
<Orders>
  <Order id="123">
    <Symbol>6758.T</Symbol>
    <Price>2300</Price>
  <Order>
<Orders>
```
例子中 id 是元素的一个属性，其他元素都没有属性

## 什么是格式良好的 XML
一个格式良好的 XML 意味着该 XML 文档语法上是正确的

- 只有一个根元素
- 所有的开放标签合适地闭合
- 属性值必须加引号等等

如果一个 XML 不是格式良好的，那么它可能不能被各种 XML 解析器正确地处理和解析。

## XML 命名空间是什么？它为什么很重要？


## DOM 和 SAX 解析器有什么区别
DOM 和SAX 解析器的主要区别在于它们解析 XML 文档的方式
- 使用 DOM 解析时，XML 文档以树形结构的形式加载到内存中
- SAX 是事件驱动的解析器

## XML CDATA 是什么
CDATA 是指**字符数据**，它有特殊的指令被 XML 解析器解析。XML 解析器解析 XML 文档中所有的文本，比如<name>This
is name of person</name>，标签的值也会被解析，因为标签值也可能包含 XML 标签，比如
<name><firstname>First Name</firstname></name>。CDATA 部分不会被 XML 解析器解析。
CDATA 部分以<![CDATA[开始，以]]>结束

## Java 的 XML 数据绑定是什么
Java 的 XML 绑定指从 XML 文件中创建类和对象，使用 Java 编程语言修改 XML 文档。XML
绑定的 Java API，JAXB 提供了绑定 XML 文档和 Java 对象的便利方式。另一个可选的 XML 绑
定方法是使用开源库，比如 XML Beans。Java 中 XML 绑定的一个最大的优势就是利用 Java
编程能力创建和修改 XML 文档



