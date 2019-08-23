# RandomAccessFile类 基于指针的随机访问
## 概述
Java提供了可以对文件随机访问的操作访问包括**读read**和**写write**类为`RandomAccessFile`
该类的读写是基于**指针**的操作

## 只读模式
`RandomAccessFile`在对文件进行随机访问操作时有两个模式分别是
- 只读模式(只读取文件数据)
- 读写模式(对文件数据进行读写)

只读模式在创建`RandomAccessFile`时，其构造方法要求我们传入**访问模式**：

- `public RandomAccessFile(File file, String mode)`;
- `public RandomAccessFile(String filename, String mode)`;

其中构造方法的第⼀个参数是需要访问的文件，而第二个参数则是访问模式；**r**是字符串学表示对该文件的访问是只读

## 读写模式
创建⼀个基于文件访问的读写模式的RandomAccess㲏我们只需要在第⼆个参数传入**rw**即可

RandomAccessFile raf = new RandomAccessFile(file, "rw");

那么这时在使⽤RandomAccessFile对文件的访问就是可读又可写的：
