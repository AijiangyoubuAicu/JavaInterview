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
