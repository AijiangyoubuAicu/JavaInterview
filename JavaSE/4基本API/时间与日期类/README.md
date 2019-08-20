# Date时间类
## 概述
`java.util.Date`表示特定的瞬间，精确到毫秒

Date 拥有多个构造函数，可以把毫秒转成日期对象

- `public Date()` 分配 Date 对象并初始化此对象，以表示分配它的时间(精确到毫秒)

- `public Date(long date)` 分配 Date 对象并初始化此对象，以表示自从`标准基准时间`，即`1970年1月1日00:00:00 GMT`
	 以来的指定毫秒值
	 
>由于我们处于冬八区，基准时间为1970年1月1日8时0分0秒

使用其无参构造，可以自动设置当前系统时间的毫秒时刻；指定 long 类型的构造参数，可以自定义毫秒时刻；

>在使用 println 方法时，会自动调用 Date 类中的 toString() 方法，Date 类对 Object 类中
的 toString() 方法进行了重写，所以结果为指定格式的字符串

## 常用方法

- `public long getTime()` 把日期对象转换成对应的时间毫秒值

# DateFormat 时间格式类

## 概述

`java.text.DateFormat`是日期/时间格式化子类的抽象类，通过这个类可以帮助我们完成日期和文本之间的
转换，也就是可以在 Date 对象与 Stirng 对象之间的来回转换

>格式化：按照指定的格式，从 Date 对象转换为 String 对象
>解析：按照指定的格式，从 String 对象转换成 Date 对象

## 构造方法
由于 DateFormat 为抽象类，不能直接使用，经常需用使用它的实现类`java.text.SimpleDateFormat`；这个类需要一个模式
来指定格式化或解析的标准

构造方法：

- `public SimpleDateFormat(String pattern)` 用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat

常用的方法：

- `public String format(Date date)` 将 Date 对象格式化为字符串
- `public Date parse(String source)` 将字符串解析为 Date 对象

# Calender 日历类
`java.util.Calender` 是日历类，是 Date 后出现的，替换掉了许多 Date 的方法，该类将所有可能会用到的
时间信息封装成了静态成员变量，方便获取。日历类就是方便获取各个时间属性

获取方式：Calender 为抽象类，由于语言敏感，Calender 类在创建对象时并非直接创建，而是通过静态方法创建，返回
子类对象

Calender 静态方法
- `public static Calender getInstance()` 使用默认时区和语言环境来获得一个日历

Calender 常用的方法
- `public int get(int field)` 返回给定日历字段的值
- `public void set(int filed, int value)` 将给定的日历字段设置为给定值
- `public abstract void add(int field, int amount)` 根据日历的规则，为给定的日历字段添加或减去指定的时间量
- `public Date getTime()` 返回一个表示此 Calendar 时间值(从历元到现在的毫秒偏移值)的 Date 对象


		字段值	        含义
		YEAR	         年
		MONTH	         月（从0开始，可以+1使用）
		DAY_OF_MONTH	 月中的天（几号）
		HOUR	         时（12小时制）
		HOUR_OF_DAY	 时（24小时制）
		MINUTE	         分
		SECOND	         秒
		DAY_OF_WEEK	 周中的天（周几，周日

- `getting()与setting()` getting方法用来获取指定字段的值，setting方法用来设置指定字段的值
- `add()` add()方法可以对指定日历字段的值进行加减操作，如果第二个参数为整数则加上偏移值，如果是负数则减去偏移值
- `getTime()` Calendar 中的 getTime() 方法并不是获取毫秒时刻，而是拿到对应的 Date 对象

>西方星期的开始为周日，中国为周一。
 在Calendar类中，月份的表示是以0-11代表1-12月。
 日期是有大小关系的，时间靠后，时间越大。
