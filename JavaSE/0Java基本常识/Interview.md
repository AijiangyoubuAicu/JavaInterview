# 简单的说一下什么是跨平台

由于各种操作系统所支持的**指令集**不是完全一致的，就会让我们的程序在不同的操作系统上执行不同的程序代码。
Java开发了适用于不同**操作系统**及**位数**的Java虚拟机来屏蔽系统之间的差异，提供统一的接口；对于我们Java
开发者来说，只需在不同的系统上安装对应的Java虚拟机并遵循Java的规范，就可以在所有的操作系统上运行Java程序的了；

# Oracle JDK 和 OpenJDK 的对比

1.OracleJDK 版本每三年分步一次，而 OpenJDK 每三个月发布一次；<br>

2.OpenJDK是一个参考模型并且是完全开源的，而Oracle
JDK是OpenJDK的一个实现，并不是完全开源的；<br> 

3.Oracle JDK 比
OpenJDK更稳定。OpenJDK和Oracle JDK的代码几乎相同，但Oracle
JDK有更多的类和一些错误修复。因此，如果您想开发企业/商业软件，我建议您选择Oracle
JDK，因为它经过了彻底的测试和稳定<br>

4.在响应性和JVM性能方面，Oracle JDK与OpenJDK相比提供了更好的性能<br>

5.Oracle JDK不会为即将发布的版本提供长期支持，用户每次都必须通过更新到最新版本获得支持来获取最新版本<br>

6.Oracle JDK根据**二进制代码许可协议**获得许可，而OpenJDK根据**GPL
v2**许可获得许可<br>