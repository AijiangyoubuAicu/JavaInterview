# Stream 流

## 概述
这个**流**并不是I/O中的流，得益于**Lambda**的函数式编程的新特性，引入的一个
全新的 Stream 流。用于解决已有集合类库既有的弊端

几乎所有的集合都支持直接(foreach循环)和间接的遍历操作，而当我们需要对集合汇总的元素
进行操作的时候，除了必要的增删改查，最典型的就是集合遍历；

集合遍历请回顾：
[iterator 迭代器](../iterator/ReadMe.md)

#### 遍历集合的弊端
Java 8 的 Lambda 让我们更加专注于**做什么**，而不是**怎么做**

> for循环的语法就是怎么做，循环体是做什么

为什么要使用循环？<br>
因为要进行遍历，但循环是遍历的唯一方式吗？遍历是指每一个元素逐一进行处理，而不是从第一个到最后一个
顺次处理的循环；前者是目的，后者是方式；

现在我们想要对元素进行筛选过滤：
- 将集合A根据条件一过滤为子集B
- 然后再根据条件二过滤为子集C

```java
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 foreach 循环实现过滤
 */
public class Demo01NormalFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        System.out.println(list);   // [张无忌, 周芷若, 赵敏, 张强, 张三丰]

        /**
         * 过滤出含有“张”的子集
         */
        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);    
            }
        }
        System.out.println(zhangList);  // [张无忌, 张强, 张三丰]

        /**
         * 在上述的子集过滤出含有3个字以上名字的子集
         */
        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                shortList.add(name);
            }
        }
        System.out.println(shortList);  // [张无忌, 张三丰]
    }

}
```

那么上述写法可以使用 Lambda 的 Stream 流语法简化：

```java
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 Stream 流循环实现过滤
 */
public class Demo02StreamFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        System.out.println(list);   // [张无忌, 周芷若, 赵敏, 张强, 张三丰]

        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);
        /*
         * 张无忌
         * 张三丰
         */
        
    }
}

```

## 流式思想
Stream 是一个来自数据源的元素队列，是集合元素的**函数模型**，并不是集合也不是数据结构，其本身并不存储任何元素

- 元素是特定类型的对象，形成一个队列，Java中的 Stream 并不会存储元素，而是**按需计算**
- 数据源流的来源，可以是集合、数组等

和以前的 Collection 操作不同，Stream 操作有两个基础特征：
- Pipelining：中间操作都会返回流对象本身，这样多个操作可以串联成一个管道，如同流式风格；
  这样做可以对操作进行优化，比如延迟执行(laziness)和短路(short-circuiting)
- 内部迭代：以前对集合遍历都是通过**iterator**或**增强for**的方式，显示的在集合外部进行迭代，这叫**外部迭代**，
  Stream提供了**内部迭代**的方式，流可以直接调用遍历方法
  
使用流有三个步骤：
- 1.获取一个数据源(source)
- 2.数据转换
- 3.执行操作想要的结果，每次转换原有的 Stream 对象不改变，返回一个新的 Stream 对象(可多次转换)

> 这就允许对集合操作可以像链条一样排列，变成一个管道

## 获取流
`java.util.stream.Stream<T>`是**JDK8**新加入的最常用的流接口

> 这个并不是一个函数式接口哦

获取一个流的常用方式：
- `Stream`接口的静态方法`of`可以获取数组对应的流
- 所有的`Collection`集合都可以通过`stream`默认方式获取流
- `Map`接口不是`Collection`的子接口，且其 K-V 数据结构不符合流元素的单一特征，所以获取对应
  的流需要分 key、value 或 entry 等情况

```java
import java.util.*;
import java.util.stream.Stream;

/**
 * 容器的获取 Stream 流
 */
public class Demo03GetStream {
    public static void main(String[] args) {
        /**
         * 数组的获取流
         */
        String[] array = {"张无忌", "张翠山", "张三丰", "张一元"};
        Stream<String> stream = Stream.of(array);

        /**
         * List 集合的获取流
         */
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        /**
         * Set 集合的获取流
         */
        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        /**
         * Vector 集合的获取流
         */
        Vector<String> vector = new Vector<>();
        Stream<String> stream3 = vector.stream();

        /**
         * Map 集合的获取流
         */
        Map<String, String> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<String> valueStream = map.values().stream();
        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();

    }
}

```

## Stream 常用方法

- **延迟方法**：返回值类型仍然是`Stream`接口自身类型的方法，因此支持链式调用；除了终结方法外，其余方法均为延迟方法
- **终结方法**：返回值类型不再是`Stream`接口自身类型的方法，因此不再支持类似 StringBuilder 那样的链式调
  用；常用的终结方法包括`count`和`forEach`方法。

### 逐一处理 forEach

    void forEach(Consumer<? super T> action);
    
> java.util.function.Consumer<T> 接口是一个消费型接口，Consumer 接口中包含抽象方法 void accept(T t) 意为消费一个指定泛型的数据 

```java
import java.util.stream.Stream;

public class Demo04StreamForeach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张无忌", "张三丰", "周芷若");
        stream.forEach(name -> System.out.print(name + " "));   // 张无忌 张三丰 周芷若 
    }
}
```

### 过滤 filter
可以使用`filter`方法将一个流根据条件转换成另一个子集流：

    Stream<T> filter(Predicate<? super T> predicate);
    
该接口接收到一个`Predicate`函数式接口参数(可以是一个 Lambda 或方法引用)作为**筛选条件**

> java.util.stream.Predicate 中的有一个抽象方法 boolean test(T t); 代表着指定的条件是否满足；
> 如果结果为 true，那么 Stream 流的 filter 方法将会保留元素，如果结果为 false，那么 filter就会舍弃该元素

```java
import java.util.stream.Stream;

public class Demo05StreamFilter {
    public static void main(String[] args) {
        Stream<String> orginal = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = orginal.filter(s -> s.startsWith("张"));
    }
}
```
### 映射 map
如果需要将流中的元素映射到另一个流中，可以用`map`方法：

    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    
该接口需要一个`Function`函数式接口参数，可以将当前流中的 T 类型转换成另一种 R 类型

> java.util.stream.Function 函数式接口，其中唯一的抽象方法为： R apply(T t); 

这可以将一种 T 类型转换成 R 类型，而这种转换的动作称为**映射**

```java
import java.util.stream.Stream;

public class Demo06StreamMap {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("10", "11", "12");
        Stream<Integer> result = original.map(str -> Integer.parseInt(str));
    }
}
```

在上述代码中，`map`方法的参数通过方法引用，将字符串类型转换成为了 int 类型(并自动封装成 Integer 类对象)

### 统计个数

正如旧集合`Collection`当中的`size()`方法一样，流提供`count`方法来数一数其中的元素个数

    long count();
    
```java
import java.util.stream.Stream;

public class Demo07StreamCount {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = original.filter(s -> s.startsWith("张"));
        System.out.println(result.count()); // 2
    }
}
```

### 取用前几个 limit
`limit`方法可以对流进行截取，只取用前n个

    Stream<T> limit(long maxSize);
    
参数是一个 long 型，如果集合当前长度大于参数则进行截取，否则不进行操作

```java
import java.util.stream.Stream;

public class Demo08StreamLimit {
    public static void main(String[] args) {
        Stream<String> orginal = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = orginal.limit(2);
        System.out.println(result.count()); // 2
    }
}
```

### 跳过前几个 skip
如果希望跳过前几个元素，可以使用`skip`方法获取一个截取之后的新流

    Stream<T> skip(long n);
    
如果流的当前长度大于n，则跳过前n个****，否则将会得到一个长度为0的空流

```java
import java.util.stream.Stream;

public class Demo09StreamSkip {
    public static void main(String[] args) {
        Stream<String> orginal = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = orginal.skip(2);
        System.out.println(result.count()); // 1
    }
}
```

### 组合 concat
如果有两个流，希望合并成一个流，那么可以使用`Stream`接口的静态方法`concat`

    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b);
    
> 这是一个静态方法，与 java.lang.String 当中的 concat 方法不同

```java
import java.util.stream.Stream;

public class Demo10StreamConcat {
    public static void main(String[] args) {
        Stream<String> streamA = Stream.of("张无忌");
        Stream<String> streamB = Stream.of("张翠山");
        Stream<String> result = Stream.concat(streamA, streamB);
        System.out.println(result.count());     // 2
    }
}

```

## 一个案例

现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以
下若干操作步骤：<br>
1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中 <br>
2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中 <br>
3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中 <br>
4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中 <br>
5. 将两个队伍合并为一个队伍；存储到一个新集合中 <br>
6. 根据姓名创建 Person 对象；存储到一个新集合中 <br>
7. 打印整个队伍的Person对象信息 <br>

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo11Demo {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

        // 第一个队伍只要名字为3个字的成员姓名
        // 第一个队伍筛选之后只要前3个
        Stream<String> streamOne = one.stream().filter(s -> s.length() == 3).limit(3);

        // 第二个队伍只要姓张的成员姓名
        // 第二个队伍筛选之后不要前2个
        Stream<String> streamTwo = two.stream().filter(s -> s.startsWith("张")).skip(2);

        // 将两个队伍合并成一个队伍
        // 根据姓名创建Person对象
        // 打印整个队伍的Person对象信息
        Stream.concat(streamOne, streamTwo).map(Person_Stream::new).forEach(System.out::println);
        /*
        Person_Stream{name='宋远桥'}
        Person_Stream{name='苏星河'}
        Person_Stream{name='石破天'}
        Person_Stream{name='张天爱'}
        Person_Stream{name='张二狗'}
         */
    }
}

```