# List 集合概述

`java.util.List`继承继承自Collection接口，是单列集合一个重要的分支，习惯性地会实现了
List接口对象称为"List集合"，特点：

- 在List集合中允许出现**重复**的元素
- 所有的元素都以一种**线性**的方式进行存储的
- 在程序中可以通过**索引**来访问集合中的指定元素
- 元素**有序**，即元素的存入顺序和取出顺序一致

## List 接口中常用的方法	
`List`接口作为`Collection`集合的子接口，不但继承了 Collection 接口中的全部方法，而且
还增加了一些根据元素**索引**来操作集合的特有方法

- `public void add(int index, E element)` 将指定的元素，添加到集合中的指定位置上
- `public E get(int index)` 返回集合中指定位置的元素
- `public E remove(int index)` 移除列表中指定位置的元素，返回的是被移除的元素
- `public E set(int index, E element)` 用指定的元素替换集合中指定位置的元素，返回值更新前的元素

```java 
import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List;

public class Demo01_List {
    public static void main(String[] args) {

        /**
         * public void add(E e)
         * Collection 接口的 add(E e) 抽象方法
         */
        // 创建一个List集合对象，多态
        List<String> list = new ArrayList<>();
        // 使用add()方法往集合中添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        // 输出集合
        System.out.println(list);   // [a, b, c, d, a]

        /**
         * public void add(int index, E element)
         * 将指定的元素，添加到该集合中的指定位置上
         */
        list.add(3, "cat");
        System.out.println(list);   // [a, b, c, cat, d, a]

        /**
         * public E remove(int index)
         * 移除列表中指定位置的元素，返回的是被移除的元素
         */
        String removeE = list.remove(2);
        System.out.println("被移除的元素：" + removeE); // 被移除的元素：c
        System.out.println(list);   // [a, b, cat, d, a]

        /**
         * public E set(int index, E element)
         * 用指定元素替换集合中指定位置的元素，返回值为更新前的元素
         */
        String setE = list.set(4, "A");     // 被替换的元素:a
        System.out.println("被替换的元素:" + setE);
        System.out.println(list);          // [a, b, cat, d, A]

        /**
         * list集合遍历有3种方式
         */
        // 使用普通的for循环
        System.out.print("使用for循环遍历的结果为：");
        for (int i = 0; i < list.size(); i++) {
            // public E get(int index) 返回集合种指定索引的元素
            String s = list.get(i);
            System.out.print(s + " ");  // a b cat d A
        }
        // 使用迭代器
        System.out.println();
        Iterator<String> it = list.iterator();
        System.out.print("使用迭代器遍历的结果为：");
        while (it.hasNext()) {
            String s = it.next();
            System.out.print(s + " ");  // a b cat d A
        }
        System.out.println();
        // 使用增强for循环
        System.out.print("使用增强for循环遍历的结果为：");
        for (String s : list) {
            System.out.print(s + " ");  // a b cat d A
        }
        System.out.println();
        /**
         * 注意：操作索引的时候，一定要防止引发越界异常
         * 3种常见越界异常
         *  - IndexOutOfBoundException 集合索引越界异常
         *  - ArrayIndexOutOfBoundException 数组索引越界异常
         *  - StringIndexOutOfBoundException 字符串索引越界异常
         */
        try {
            String r = list.get(5);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getClass().getName() + "：索引越界异常");
        }
    }
} 
```

# List 的子类

### ArrayList 集合
`java.util.ArrayList`是**大小可变**的数组，集合数据存储的结构是**数组**，特点是元素**长度可变**、**增删慢**、**查找快**，
由于日常开发使用最多的功能便是查询数据和遍历数据，利用索引使用ArrayList是最常用的集合

### 构造方法

- `public ArrayList()` 构造一个内容为空的集合

### 常用方法

- `public boolean add(E e)` 将指定的元素添加到此集合的尾部
- `public E remove(int index)` 移出此集合中指定位置上的元素，返回被删除的元素
- `public E get(int index)` 返回此集合中指定位置上的元素，返回获取的元素
- `public int size()` 返回此集合中的元素数，遍历集合时就可以控制索引范围，防止越界

## LinkedList 集合
java.util.LinkedList集合数据存储的是"链表"结构，方便元素的添加、删除的集合

![](../../img/双向链表.png)

实际开发中对一个集合元素的添加和删除经常涉及到首位操作，而LinkedList提供了大量的首尾操作：
- `public void addFirst(E e)` 将指定的元素插入到此列表的开头
- `public void addLast(E e)` 将指定的元素插入到此列表的末尾
- `public E getFirst()` 返回此列表的第一个元素
- `public E getLast()` 返回此列表的最后一个元素
- `public E removeFirst()` 移除并返回此列表的第一个元素
- `public E removeLast()` 移除并返回此列表的最后一个元素
- `public E pop()` 从此列表所表示的堆栈弹出一个元素
- `public void push(E e)` 将元素推入到此列表所表示的堆栈
- `public boolean isEmpty()` 如果此列表不包含元素，则返回true

```java
package linkedList;

import java.util.LinkedList;

public class Demo01_LinkedList {

    public static void main(String[] args) {
        show01();
        show02();
        show03();
    }

    /**
     * LinkedList 特有的"添加"方法
     *
     * public void addFirst(E e) 将指定的元素插入到此列表的开头
     * public void addLast(E e)  将指定的元素添加到此列表的结尾
     * public void push(E e) 将元素推入到此列表所表示的堆栈
     */
    private static void show01() {
        // 创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        // 使用add()方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);     // [a, b, c]
        // 使用addFirst()方法将指定元素插入此列表的开头
        linked.addFirst("www");
        // 使用push()方法将指定元素推入到此列表所表示的堆栈，作用与addFirst()相同
        linked.push("eee");         // [eee, www, a, b, c]
        System.out.println(linked);
        // 使用addLast()方法将指定的元素添加到此列表的结尾，作用与add()方法相同
        linked.addLast("com");
        System.out.println(linked);    // [eee, www, a, b, c, com]
    }

    /**
     * LinkedList 特有的获取元素的方法
     *
     * public E getFirst() 返回此列表的第一元素
     * public E getLast() 返回此列表中的最后一个元素
     *
     * 注意：为了避免发生 NoSuchElementException 未找到元素异常，在获取方法建议使用
     *  isEmpty()方法进行判断集合是否为空
     */
    private static void show02() {
        // 创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        // 使用add()方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);     // [a, b, c]
        // 使用isEmpty()方法判断集合是否为空
        if (!linked.isEmpty()) {
            // 使用getFirst()获取此列表的第一个元素
            String first = linked.getFirst();
            System.out.println(first);      // a
            // 使用getLast()获取此列表的最后一个元素
            String last = linked.getLast();
            System.out.println(last);       // c
            System.out.println(linked);     // [a, b, c]
        }
    }

    /**
     * LinkedList 特有的"移除"元素的方法
     *
     * public E removeFirst() 移除并返回此列表的第一个元素
     * public E removeLast() 移除并返回此列表的最后一个元素
     * public E pop() 从此列表所表示的堆栈处弹出第一个元素
     */
    private static void show03() {
        // 创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        // 使用add()方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);     // [a, b, c]
        // 使用removeFirst()方法移除此列表的第一个元素，pop()方法与其同理
        String first = linked.removeFirst();
        System.out.println("被移除的第一个元素：" + first);   // 被移除的第一个元素：a
        // 使用removeLast()方法移除此列表的最后一个元素
        String last = linked.removeLast();
        System.out.println("被移除的最后一个元素：" + last);   // 被移除的最后一个元素：c
        System.out.println(linked);
    }

}
```

## Vector 集合
Vector类可以实现可增长的对象数组，与数组一样，包含了可以使用整数索引进行访问的组件，
Vector的大小可以根据需要增大或索引，以适应创建Vector后进行添加和移除项的操作

Vector是同步的，可用于多线程；

# 附录：ArrayList源代码分析
- ArrayList 基于数组实现，所以支持快速随机访问
ArrayList 接口标识着该类支持快速随机访问
	
- ArrayList 序列化：
ArrayList 基于数组实现，并且具有动态扩容特性，因此保存元素的数组不一定会被使用，
那么就没必要全部序列化
可见 elementData 属性，它作为真正存放元素的数组，被 transient 无需序列化关键字标识
			
- ArryList的内部实现的数组默认长度为10
源码中 DEFAULT_CAPACITY 属性赋值为10，代表着其默认长度为10
		
- ArrayList使用着一个缓存的数组作为真正存放数组对象的属性
源码中 transient Object[] = elementData 
被 transient 关键字标识着不参与序列化，这是一个运行时属性
		
- ArrayList有三个构造方法
public ArrayList() 默认无参构造，它将调用数组的默认长度10
public ArrayList(int initialCapacity) 设置初始长度的构造方法，
应每次大概的设置其长度，避免ArryaList经常被扩容操作
public ArrayList(collection<? extends E> c) 基于传入集合的元素的构造器
		
- ArrayList 的继承父类 AbstractList 中有一个记录操作数的属性 modCount
即 protected transient int modCount = 0;
该属性用于记录集合被操作了多少次
modCount 用于记录 ArrayList 结构发生变化的次数，此处的结构改变指
添加和删除至少一个元素的所有操作，或者是调整内部数组的大小，仅仅设置元素的值不算结构变化

		