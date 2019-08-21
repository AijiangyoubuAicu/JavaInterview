## 概述

XML - Extensible Markup Language 可扩展标记语言

- 可扩展：即标签都是可以自定义的

- 功能

	- 存储数据
	- 充当配置文件
	- 在网络中传输
	
- XML 与 HTML 的区别
	- XML 标签都是自定义的，HTML 标签是预定义的
	- XML 语法严格，HTML 语法松散
	- XML 是存储数据的，HTML 是展示数据

## XML语法

- XML 文档的后缀名 `.xml`

- XML 第一行必须定义为`文档声明` <?xml version='1.0' ?>		
		
	- 格式 `<?xml 属性列表?>`
	- 属性列表：
  	  * version：版本号，必须的属性
      * encoding：编码方式。告知解析引擎当前文档使用的字符集，默认值：ISO-8859-1
      * standalone：是否独立 -- 取值：yes：不依赖其他文件 / no：依赖其他文件
          
  - 指令(了解)：如结合css的 `<?xml-stylesheet type="text/css" href="a.css" ?>`
		
- XML 可`自定义标签`，但文档有且仅有一个`根标签`
	- 标签：标签名称自定义的 
	- 规则：
      * 名称可以包含字母、数字以及其他的字符 
      * 名称不能以数字或者标点符号开始 
      * 名称不能以字母 xml（或者 XML、Xml 等等）开始 
      * 名称不能包含空格
   - 属性：
      - id属性值唯一
      - 可自定义
	
- 属性值必须使用引号(单双尽可)引起来
- 标签必须正确的闭合，如<... />或<..></..>
- XML 标签名称是`区分大小写`

- XML 约束 Schema
	 * 作为框架的使用者(程序员)：
   	  1. 能够在xml中引入约束文档
   	  2. 能够简单的读懂约束文档
   		
    * 分类：
   	  1. DTD:一种简单的约束技术
   	  2. Schema:一种复杂的约束技术
   
   * DTD：
   	  * 引入dtd文档到xml文档中
   		* 内部dtd：将约束规则定义在xml文档中
   		* 外部dtd：将约束的规则定义在外部的dtd文件中
   		  * 本地：<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">
   		  * 网络：<!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件的位置URL">
   
   * Schema:
   	  * 引入：
   		- 1.填写xml文档的根元素
   		- 2.引入xsi前缀.  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   		- 3.引入xsd文件命名空间.  xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"
   		- 4.为每一个xsd约束声明一个前缀,作为标识  xmlns="http://www.itcast.cn/xml" 
   
   
   	<students   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   		xmlns="http://www.itcast.cn/xml"
   		xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd">

![](img/约束.bmp)

## XML解析

解析：操作xml文档，将文档中的数据读取到内存中

- 操作xml文档
		1. 解析(读取)：将文档中的数据读取到内存中
		2. 写入：将内存中的数据保存到xml文档中。持久化的存储

	* 解析xml的方式：
		1. DOM：将标记语言文档一次性加载进内存，在内存中形成一颗 dom 树
			* 优点：操作方便，可以对文档进行CRUD的所有操作
			* 缺点：占内存
		2. SAX：逐行读取，基于事件驱动的。
			* 优点：不占内存。
			* 缺点：只能读取，不能增删改


	
- xml常见的解析器：
	- JAXP：sun公司提供的解析器，支持dom和sax两种思想
	- DOM4J：一款非常优秀的解析器
	- Jsoup：jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
	- PULL：Android操作系统内置的解析器，sax方式的。


- Jsoup：jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
	* 快速入门：
		* 步骤：
			1. 导入jar包
			2. 获取Document对象
			3. 获取对应的标签Element对象
			4. 获取数据