## 既然Java反射可以访问和修改私有成员变量，那封装成private还有意义么

private想表达的不是“安全性”的意思，而是OOP的封装概念，是一种编译器可以帮助你的设计上的私有化；
又比如 JavaBean
的规范要求我们私有化属性，这是一套规范：许多框架都是要我们按照JavaBean的规范来设计类，如果不遵守无法达成框架约定就无法使用；