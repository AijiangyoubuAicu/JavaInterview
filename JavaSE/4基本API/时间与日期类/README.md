[TOC]

# Date时间类

## 概述
`java.util.Date`表示特定的瞬间，精确到**毫秒**

```
特定的瞬间：一个时间点,一刹那时间
2088-08-08 09:55:33:333 瞬间
2088-08-08 09:55:33:334 瞬间
2088-08-08 09:55:33:335 瞬间
...
```

`Date`拥有多个构造函数，可以把毫秒转成日期对象

- `public Date()` 分配`Date`对象并初始化此对象，以表示分配它的时间(精确到毫秒)

- `public Date(long date)` 分配`Date`对象并初始化此对象，以表示自从**标准基准时间**，即**1970年1月1日00:00:00 GMT**以来的指定**毫秒值**

```java
import java.util.Date;

public class Demo {
    public static void main(String[] args){  
        Date date = new Date();
        System.out.println(date);	// Thu Aug 22 17:29:58 CST 2019

        date = new Date(0L);
        System.out.println(date);	// Thu Jan 01 08:00:00 CST 1970

        date = new Date(1566465065245L);
        System.out.println(date);	// Thu Aug 22 17:11:05 CST 2019

    }
}
```

毫秒值的作用:可以对时间和日期进行计算：如**2099-01-03**到**2088-01-01**中间一共有多少天，可以日期转换为毫秒进行计算，计算完毕，在把毫秒转换为日期

使用其无参构造，可以自动设置当前系统时间的毫秒时刻；指定 long 类型的构造参数，可以自定义毫秒时刻。

### 时间上的注意事项	 
- 中国处于冬八区，基准时间为**1970年1月1日8时0分0秒**，会把时间增加8个小时
- 把毫秒转换为日期：1天 = 24 × 60 × 60 = 86400 秒  = 86400 x 1000 = 86400000毫秒
- 时间原点(0毫秒):**1970 年 1 月 1 日 00:00:00(英国格林威治)**

```java
public class Demo {
    public static void main(String[] args) {
        //获取当前系统时间到1970 年 1 月 1 日 00:00:00经历了多少毫秒
        System.out.println(System.currentTimeMillis());	// 1566465065245
    }
}
```

>在使用 println 方法时，会自动调用 Date 类中的 toString() 方法，Date 类对 Object 类中
的 toString() 方法进行了重写，所以结果为指定格式的字符串

## 常用方法

- `public long getTime()` 把日期对象转换成对应的时间毫秒值

```java
import java.util.Date;

public class Demo {
    public static void main(String[] args){
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time); // 1566466277656
    }
}
```

# DateFormat 时间格式类

## 概述

`java.text.DateFormat`是日期/时间格式化子类的抽象类，通过这个类可以帮助我们完成日期和文本之间的
转换，也就是可以在 Date 对象与 String 对象之间的来回转换

>格式化：按照指定的格式，从 Date 对象转换为 String 对象(日期 -> 文本)
>解析：按照指定的格式，从 String 对象转换成 Date 对象（文本-> 日期）

由于 `DateFormat` 为抽象类，不能直接使用，经常需用使用它的实现类`java.text.SimpleDateFormat`；这个类需要一个模式
来指定格式化或解析的标准

## 构造方法：

- `public SimpleDateFormat(String pattern)` 用给定的模式和默认语言环境的日期格式符号构造`SimpleDateFormat`

  ```
  模式：区分大小写的
      y   年
      M   月
      d   日
      H   时
      m   分
      s   秒
  写对应的模式，会把模式替换为对应的日期和时间
      "yyyy-MM-dd HH:mm:ss"
  注意：
      模式中的字母不能更改，连接模式的符号可以改变
      "yyyy年MM月dd日 HH时mm分ss秒"
  ```

## 常用的方法：

- `public String format(Date date)` 将 Date 对象格式化为字符串
- `public Date parse(String source)` 将字符串解析为 Date 对象

```java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        try {
            Date date = sdf.parse("2018年08月22日 17时51分54秒");
            /**
             * 必须严格遵守上述的模式声明，
             * 错误的写法比如惯性的将 08月省略掉0，是不可取的
			 */
            System.out.println(date); // Wed Aug 22 17:51:54 CST 2018
            
            String str = sdf.format(date);
            System.out.println(str); // 2018年08月22日 17时51分54秒
            
        // DateFormat声明了一个"解析异常"
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
```

# Calender 日历类

## 概念

`java.util.Calender`是**日历类**，是 Date 后出现的，替换掉了许多 Date 的方法，该类将所有可能会用到的时间信息封装成了静态成员变量，方便获取。日历类就是方便获取各个时间属性。

获取方式：Calender 为**抽象类**，由于语言敏感，Calender 类在创建对象时并非直接创建，而是通过静态方法创建，返回子类对象。

## Calender 静态方法
- `public static Calender getInstance()` 使用默认时区和语言环境来获得一个日历

## Calender 常用的方法

- `public int get(int field)` 返回给定日历字段的值

- `public void set(int filed, int value)` 将给定的日历字段设置为给定值

- `public abstract void add(int field, int amount)` 根据日历的规则，为给定的日历字段添加或减去指定的时间量

- `public Date getTime()` 返回一个表示此 Calendar 时间值（从历元到现在的毫秒偏移值）的 Date 对象

  | 字段值       | 含义                      |
  | ------------ | ------------------------- |
  | YEAR         | 年                        |
  | MONTH        | 月（从0开始，可以+1使用） |
  | DAY_OF_MONTH | 月中的天（几号）          |
  | HOUR         | 时（12小时制）            |
  | HOUR_OF_DAY  | 时（24小时制）            |
  | MINUTE       | 分                        |
  | SECOND       | 秒                        |
  | DAY_OF_WEEK  | 周中的天（周几，周日      |

- `getting()与setting()`

  `getting()`方法用来获取指定字段的值，`setting()`方法用来设置指定字段的值

- `add()`

  `add()`方法可以对指定日历字段的值进行加减操作，如果第二个参数为整数则加上偏移值，如果是负数则减去偏移值

- `getTime()`

  `Calenda`中的`getTime()`方法并不是获取毫秒时刻，而是拿到对应的`Date`对象

>西方星期的开始为周日，中国为周一。
在Calendar类中，月份的表示是以0-11代表1-12月
日期是有大小关系的，时间靠后，时间越大

------

[回到顶部](#Date时间类)

[返回上一页](../../../KnowledgePoint.md)