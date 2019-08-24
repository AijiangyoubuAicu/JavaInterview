[TOC]

## 概述

`java.lang.Math`类包含用于执行基本数学运算的方法，包括初等指数、对数、平方根和
三角函数，类似这样的工具类，其所有方法均属于静态方法，并且不会创建对象，调用起来非常简单

## 两个数学类属性

- `E`自然对数
	
	`double`值比其他任何一个都更接近`e`，自然对数的基数

- `PI`圆周率
	
	`double`值比任何其他更接近`pi`，圆周长与其直径的比率

## 常用的方法

- `static double abs(double e)`
	
	返回值为`double`的绝对值

- `static double sqrt(double e)`

	返回的正确舍入正平方根`double`值

- `static double max(double a, double b)`
	
	返回两个`double`值中的较大值

- `static double min(double a, double b)`

	返回两个`float`的较小值

- `static double random()`
	
	返回一个`double`值为正好，大于等于0.0，小于1.0，返回值是从该范围(大约)
	均匀分布而伪随机选择的

- `static double pow(double a, double b)`
	
	将第一个参数的值返回到第二个参数的幕

- `static double ceil(double e)`

	返回大于或等于参数的最小(最接近负无穷大)`double`值，等于
	一个数学整数

- `static double floor(double e)`
	
	返回小于或等于参数的最大(最接近正无穷大)`double`值，
	等于一个数学整数

- `static double round(double a)`
	
	返回参数中最接近的`long`，其中`long`四舍五入为正无穷大
	
## 其他的方法

- `sin(double a)`返回角的三角正弦。
- `cos(double a)`返回角的三角余弦。
- `tan(double a)`返回角的三角正切。
- `log(double a)`返回`double`值的自然对数（底数是 e）。
- `log10(double a)`返回`double`值的底数为 10 的对数。
- `acos(double a)`返回一个值的反余弦；返回的角度范围在 0.0 到 pi 之间。
- `asin(double a)`返回一个值的反正弦；返回的角度范围在 -pi/2 到 pi/2 之间。
- `atan(double a)`返回一个值的反正切；返回的角度范围在 -pi/2 到 pi/2 之间。
- `atan2(double y, double x)`将矩形坐标`(x, y)`转换成极坐标`(r, theta)`，返回所得`theta`。

------

[返回顶部](#概述)

[返回上一页](../../../KnowledgePoint.md)