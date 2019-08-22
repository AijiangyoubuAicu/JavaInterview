# IO概述

## 什么是IO

我们把这种数据的传输，可以看做是一种数据的流动，按照流动的方向，
以内存为基准，分为`输入input` 和`输出output` ，
即流向内存是输入流，流出内存的输出流

![](img/1_io.jpg)

Java中I/O操作主要是指使用`java.io`包下的内容，进行输入、输出操作。**输入**也叫做**读取**数据，**输出**也叫做作**写出**数据

## IO的分类

根据数据的流向分为

- **输入流** ：把数据从`其他设备`上读取到`内存`中的流。 
- **输出流** ：把数据从`内存` 中写出到`其他设备`上的流。

根据数据的类型分为：**字节流**和**字符流**。

* **字节流** ：以字节为单位，读写数据的流。
* **字符流** ：以字符为单位，读写数据的流。

## 顶级超类

- 输入流
	- 字节流 InputStream
	- 字符流 Reader
- 输出流
	- 字节流 OutputStream
	- 字符流 Writer

# 字节流

一切文件数据(文本、图片、视频等)在存储时，都是以`二进制数字`的形式保存，即一个一个的字节的保存一个一个字节的输出输入，所以字节流可以传输任意文件数据。
在操作流的时候，我们要时刻明确，无论使用什么样的流对象，底层传输的始终为`二进制数据`

# 字节输出流 OutputStream

`java.io.OutputStream `抽象类是表示字节输出流的所有类的超类，将指定的字节信息写出到目的地。它定义了字节输出流的共性方法

- `public void close()`：关闭此输出流并释放与此流相关联的任何系统资源
- `public void flush() `：刷新此输出流并强制任何缓冲的输出字节被写出
- `public void write(byte[] b)`：将 b.length字节从指定的字节数组写入此输出流
- `public void write(byte[] b, int off, int len)` ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流 
- `public abstract void write(int b)` ：将指定的字节输出流

> close方法，当完成流的操作时，必须调用此方法，释放系统资源。

## 文件输出流 FileOutputStream

`java.io.FileOutputStream `类是`OutputStream`的子类之一，属于文件输出流，用于将数据写出到文件

- 构造方法

	- `public FileOutputStream(File file)`：创建文件输出流以写入由指定的 File对象表示的文件。 
	- `public FileOutputStream(String name)`： 创建文件输出流以指定的名称写入文件。  

当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有这个文件，会创建该文件。如果有这个文件，会清空这个文件的数据。

## 写出字节数据

- 写出字节：

	`write(int b)` 方法，每次可以写出一个字节数据

> 1. 虽然参数为int类型四个字节，但是只会保留一个字节的信息写出。
> 2. 流操作完毕后，必须释放系统资源，调用close方法，千万记得。

- 写出字节数组：

`write(byte[] b)`，每次可以写出数组中的数据

- 写出指定长度字节数组：

`write(byte[] b, int off, int len)` ,每次写出从off索引开始，len个字节，代码使用演示：

## 数据追加续写

每次程序运行，创建输出流对象，都会清空目标文件中的数据；使用数据追加续写该文件的数据

- `public FileOutputStream(File file, boolean append)`： 创建文件输出流以写入由指定的 File对象表示的文件。  
- `public FileOutputStream(String name, boolean append)`： 创建文件输出流以指定的名称写入文件。  

这两个构造方法的参数中都需要传入一个boolean类型的值，`true` 表示追加数据，`false` 表示清空原有数据。
这样创建的输出流对象，就可以指定是否追加续写了

## 写出换行

Windows系统里，换行符号是`\r\n` 

> * 回车符`\r`和换行符`\n` ：
> * 回车符：回到一行的开头（return）
> * 换行符：下一行（newline）
> * 系统中的换行：
> * Windows系统里，每行结尾是 `回车+换行` ，即`\r\n`；
> * Unix系统里，每行结尾只有 `换行` ，即`\n`；
> * Mac系统里，每行结尾是 `回车` ，即`\r`。从 Mac OS X开始与Linux统一

# 字节输入流 InputStream

`java.io.InputStream `抽象类是表示字节输入流的所有类的超类，可以读取字节信息到内存中。它定义了字节输入流的共性方法。

- `public void close()` ：关闭此输入流并释放与此流相关联的任何系统资源。    
- `public abstract int read()`： 从输入流读取数据的下一个字节。 
- `public int read(byte[] b)`： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

> close方法，当完成流的操作时，必须调用此方法，释放系统资源。

## FileInputStream 文件输出类

`java.io.FileInputStream `类是文件输入流，从文件中读取字节。

- 构造方法

	- `FileInputStream(File file)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。 
	- `FileInputStream(String name)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。  

当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出`FileNotFoundException` 。

## 读取字节数据

-  **读取字节**：`read`方法，每次可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回`-1`

> 1. 虽然读取了一个字节，但是会自动提升为int类型。
> 2. 流操作完毕后，必须释放系统资源，调用close()方法

- **使用字节数组读取**：`read(byte[] b)`，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回`-1` 

> 使用数组读取，每次读取多个字节，减少了系统间的IO操作次数，从而提高了读写的效率，建议开发中使用。

# 字符流

当使用字节流读取文本文件时，可能会有一个小问题。就是遇到中文字符时，可能不会显示完整的字符，
那是因为一个中文字符可能占用多个字节存储。所以Java提供一些字符流类，以字符为单位读写数据，专门用于处理文本文件

## 字符输入流Reader

`java.io.Reader`抽象类是表示用于读取字符流的所有类的超类，可以读取字符信息到内存中。它定义了字符输入流的基本共性功能方法

- `public void close()` ：关闭此流并释放与此流相关联的任何系统资源  
- `public int read()`： 从输入流读取一个字符
- `public int read(char[] cbuf)`： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中

# FileReader 文件字符流  

`java.io.FileReader `类是读取字符文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区


> 字符编码：字节与字符的对应规则。Windows系统的中文编码默认是GBK编码表
> 字节缓冲区：一个字节数组，用来临时存储字节数据

- 构造方法

	- `FileReader(File file)`： 创建一个新的 FileReader ，给定要读取的File对象  
	- `FileReader(String fileName)`： 创建一个新的 FileReader ，给定要读取的文件的名称 

当你创建一个流对象时，必须传入一个文件路径。类似于FileInputStream

## 读取字符数据

- **读取字符**：`read`方法，每次可以读取一个字符的数据，提升为int类型，读取到文件末尾，返回`-1`，循环读取

>小贴士：虽然读取了一个字符，但是会自动提升为int类型。

- **使用字符数组读取**：`read(char[] cbuf)`，每次读取b的长度个字符到数组中，返回读取到的有效字符个数，读取到末尾时，返回`-1` 

# Writer 字符输出流

`java.io.Writer `抽象类是表示用于写出字符流的所有类的超类，将指定的字符信息写出到目的地。它定义了字节输出流的基本共性功能方法。

- `void write(int c)` 写入单个字符。
- `void write(char[] cbuf) `写入字符数组。 
- `abstract  void write(char[] cbuf, int off, int len) `写入字符数组的某一部分,off数组的开始索引,len写的字符个数。 
- `void write(String str) `写入字符串。 
- `void write(String str, int off, int len)` 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
- `void flush() `刷新该流的缓冲。  
- `void close()` 关闭此流，但要先刷新它。 

## FileWriter 文件字符输出类

`java.io.FileWriter `类是写出字符到文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。

- 构造方法

	- `FileWriter(File file)`： 创建一个新的 FileWriter，给定要读取的File对象。   
	- `FileWriter(String fileName)`： 创建一个新的 FileWriter，给定要读取的文件的名称。  

当你创建一个流对象时，必须传入一个文件路径，类似于FileOutputStream。

## 基本写出数据

- **写出字符**：`write(int b)` 方法，每次可以写出一个字符数据，代码使用演示：

> 1. 虽然参数为int类型四个字节，但是只会保留一个字符的信息写出。
> 2. 未调用close方法，数据只是保存到了缓冲区，并未写出到文件中。

## 关闭和刷新

因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无法继续写出数据的。如果我们既想写出数据，又想继续使用流，就需要`flush` 方法了。

* `flush` ：刷新缓冲区，流对象可以继续使用。
* `close `:先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。

> 小贴士：即便是flush方法写出了数据，操作的最后还是要调用close方法，释放系统资源。

## 写出其他数据

- **写出字符数组** ：
	- `write(char[] cbuf)` 
	- `write(char[] cbuf, int off, int len)` 
	
	每次可以写出字符数组中的数据，用法类似FileOutputStream

- **写出字符串**：`write(String str)`  `write(String str, int off, int len)`

	每次可以写出字符串中的数据

- **续写和换行**：操作类似于FileOutputStream

> 当我们单纯读或者写文本文件时  使用字符流 其他情况使用字节流

# 属性集

## 概述

`java.util.Properties ` 继承于` Hashtable` ，来表示一个持久的属性集
它使用键值结构存储数据，每个键及其对应值都是一个字符串。该类也被许多Java类使用，
比如获取系统属性时，`System.getProperties` 方法就是返回一个`Properties`对象

## Properties类

- 构造方法

	- `public Properties()` :创建一个空的属性列表

- 基本的存储方法

	- `public Object setProperty(String key, String value)` ： 保存一对属性
	- `public String getProperty(String key) ` ：使用此属性列表中指定的键搜索属性值
- `public Set<String> stringPropertyNames() ` ：所有键的名称的集合

- 与流相关的方法

	- `public void load(InputStream inStream)`： 从字节输入流中读取键值对。 

参数中使用了字节输入流，通过流对象，可以关联到某文件上，这样就能够加载文本中的数据了。文本数据格式:

> 文本中的数据，必须是键值对形式，可以使用空格、等号、冒号等符号分隔。

# 缓冲流

## 概述

缓冲流,也叫高效流，是对4个基本的`FileXXXStream`文件流的增强，所以也是4个流，按照数据类型分类：

- **字节缓冲流**
	- `BufferedInputStream` 字节缓冲输入流
	- `BufferedOutputStream`  字节缓冲输出流
- **字符缓冲流**
	- `BufferedReader` 字符缓冲输入流
	- `BufferedWriter` 字符缓冲输出流

缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的`缓冲区数组`，通过缓冲区读写来减少系统IO次数，从而提高读写的效率。

## 字节缓冲流

- 构造方法

	- `public BufferedInputStream(InputStream in)` ：创建一个 新的缓冲输入流 
	- `public BufferedOutputStream(OutputStream out)`： 创建一个新的缓冲输出流

## 字符缓冲流

- 构造方法

	- `public BufferedReader(Reader in)` ：创建一个 新的缓冲输入流
	- `public BufferedWriter(Writer out)`： 创建一个新的缓冲输出流

- 特有方法

	字符缓冲流的基本方法与普通字符流调用方式一致

	- BufferedReader：`public String readLine()`: 读一行文字。

	- BufferedWriter：`public void newLine()`: 写一行行分隔符,由系统属性定义符号


# 转换流

## 字符编码

计算机中储存的信息都是用二进制数表示的，而我们在屏幕上看到的数字、英文、标点符号、汉字等字符是二进制数转换之后的结果。
按照某种规则，将字符存储到计算机中，称为**编码** 。反之，将存储在计算机中的二进制数按照某种规则解析显示出来，
称为**解码** 。比如说，按照A规则存储，同样按照A规则解析，那么就能显示正确的文本符号。
反之，按照A规则存储，再按照B规则解析，就会导致乱码现象。

编码:字符(能看懂的)--字节(看不懂的)

解码:字节(看不懂的)-->字符(能看懂的)

- **字符编码`Character Encoding`** : 就是一套自然语言的字符与二进制数之间的对应规则。

>编码表:生活中文字和计算机中二进制的对应规则

## 字符集

* **字符集 `Charset`**：也叫编码表。是一个系统支持的所有字符的集合，包括各国家文字、标点符号、图形符号、数字等

计算机要准确的存储和识别各种字符集符号，需要进行字符编码，一套字符集必然至少有一套字符编码。常见字符集有ASCII字符集、GBK字符集、Unicode字符集等

![](img/1_charset.jpg)

可见，当指定了**编码**，它所对应的**字符集**自然就指定了，所以**编码**才是我们最终要关心的

* **ASCII字符集** ：
  * ASCII（American Standard Code for Information Interchange，美国信息交换标准代码）是基于拉丁字母的一套电脑编码系统，用于显示现代英语，主要包括控制字符（回车键、退格、换行键等）和可显示字符（英文大小写字符、阿拉伯数字和西文符号）。
  * 基本的ASCII字符集，使用7位（bits）表示一个字符，共128字符。ASCII的扩展字符集使用8位（bits）表示一个字符，共256字符，方便支持欧洲常用字符。
* **ISO-8859-1字符集**：
  * 拉丁码表，别名Latin-1，用于显示欧洲使用的语言，包括荷兰、丹麦、德语、意大利语、西班牙语等。
  * ISO-8859-1使用单字节编码，兼容ASCII编码。
* **GBxxx字符集**：
  * GB就是国标的意思，是为了显示中文而设计的一套字符集。
  * **GB2312**：简体中文码表。一个小于127的字符的意义与原来相同。但两个大于127的字符连在一起时，就表示一个汉字，这样大约可以组合了包含7000多个简体汉字，此外数学符号、罗马希腊的字母、日文的假名们都编进去了，连在ASCII里本来就有的数字、标点、字母都统统重新编了两个字节长的编码，这就是常说的"全角"字符，而原来在127号以下的那些就叫"半角"字符了。
  * **GBK**：最常用的中文码表。是在GB2312标准基础上的扩展规范，使用了双字节编码方案，共收录了21003个汉字，完全兼容GB2312标准，同时支持繁体汉字以及日韩汉字等。
  * **GB18030**：最新的中文码表。收录汉字70244个，采用多字节编码，每个字可以由1个、2个或4个字节组成。支持中国国内少数民族的文字，同时支持繁体汉字以及日韩汉字等。
* **Unicode字符集** ：
  * Unicode编码系统为表达任意语言的任意字符而设计，是业界的一种标准，也称为统一码、标准万国码。
  * 它最多使用4个字节的数字来表达每个字母、符号，或者文字。有三种编码方案，UTF-8、UTF-16和UTF-32。最为常用的UTF-8编码。
  * UTF-8编码，可以用来表示Unicode标准中任何字符，它是电子邮件、网页及其他存储或传送文字的应用中，优先采用的编码。互联网工程工作小组（IETF）要求所有互联网协议都必须支持UTF-8编码。所以，我们开发Web应用，也要使用UTF-8编码。它使用一至四个字节为每个字符编码，编码规则：
    1. 128个US-ASCII字符，只需一个字节编码。
    2. 拉丁文等字符，需要二个字节编码。 
    3. 大部分常用字（含中文），使用三个字节编码。
    4. 其他极少使用的Unicode辅助字符，使用四字节编码。

## InputStreamReader 字符读取流  

转换流`java.io.InputStreamReader`，是Reader的子类，是从字节流到字符流的桥梁。它读取字节，
并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集

- 构造方法

	- `InputStreamReader(InputStream in)`: 创建一个使用默认字符集的字符流
	-`InputStreamReader(InputStream in, String charsetName)`: 创建一个指定字符集的字符流

## OutputStreamWriter 字符输出流

转换流`java.io.OutputStreamWriter` ，是Writer的子类，是从字符流到字节流的桥梁。
使用指定的字符集将字符编码为字节。它的字符集可以由名称指定，也可以接受平台的默认字符集

- 构造方法

	- `OutputStreamWriter(OutputStream in)`: 创建一个使用默认字符集的字符流 
	- `OutputStreamWriter(OutputStream in, String charsetName)`: 创建一个指定字符集的字符流

## 转换流理解图解

**转换流是字节与字符间的桥梁！**![](img/2_zhuanhuan.jpg)

# 序列化

## 概述

Java 提供了一种对象**序列化**的机制。用一个字节序列可以表示一个对象，该字节序列包含该`对象的数据`、`对象的类型`和`对象中存储的属性`等信息。字节序列写出到文件之后，相当于文件中**持久保存**了一个对象的信息

反之，该字节序列还可以从文件中读取回来，重构对象，对它进行**反序列化**。`对象的数据`、`对象的类型`和`对象中存储的数据`信息，都可以用来在内存中创建对象
![](img/3_xuliehua.jpg)

## ObjectOutputStream 对象序列化流

`java.io.ObjectOutputStream ` 将Java对象的原始数据类型写出到文件,实现对象的持久存储

- 构造方法

	- `public ObjectOutputStream(OutputStream out) `： 创建一个指定OutputStream的ObjectOutputStream

- 序列化操作

	一个对象要想序列化，必须满足两个条件:

	- 该类必须实现`java.io.Serializable ` 接口，`Serializable` 是一个标记接口，不实现此接口的类将不会使任何状态序列化或反序列化，会抛出`NotSerializableException` 。
	- 该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用`transient` 关键字修饰。

- 写出对象方法

	- `public final void writeObject (Object obj)` : 将指定的对象写出。

## ObjectInputStream 对象反序列流

ObjectInputStream反序列化流，将之前使用ObjectOutputStream序列化的原始数据恢复为对象。 

- 构造方法

	- `public ObjectInputStream(InputStream in) `： 创建一个指定InputStream的ObjectInputStream。

- 反序列化操作1

	如果能找到一个对象的class文件，我们可以进行反序列化操作，调用`ObjectInputStream`读取对象的方法：

	- `public final Object readObject ()` : 读取一个对象。


	对于JVM可以反序列化对象，它必须是能够找到class文件的类。如果找不到该类的class文件，则抛出一个 `ClassNotFoundException` 异常

- 反序列化操作2

`Serializable` 接口给需要序列化的类，提供了一个序列版本号。`serialVersionUID` 该版本号的目的在于验证序列化的对象和对应类是否版本匹配

	另外，当JVM反序列化对象时，能找到class文件，但是class文件在序列化对象之后发生了修改，那么反序列化操作也会失败，
	抛出一个“InvalidClassException”异常。发生这个异常的原因如下：	
	(1) 该类的序列版本号与从流中读取的类描述符的版本号不匹配 
	(2) 该类包含未知数据类型 	
	(3) 该类没有可访问的无参数构造方法 

# 打印流

## 概述

平时我们在控制台打印输出，是调用`print`方法和`println`方法完成的，这两个方法都来自于`java.io.PrintStream`类，该类能够方便地打印各种数据类型的值，是一种便捷的输出方式

## PrintStream 打印类

- 构造方法

	- `public PrintStream(String fileName)  `： 使用指定的文件名创建一个新的打印流

- 改变打印流向

`System.out`就是`PrintStream`类型的，只不过它的流向是系统规定的，打印在控制台上。不过，既然是流对象，我们就可以玩一个"小把戏"，改变它的流向


