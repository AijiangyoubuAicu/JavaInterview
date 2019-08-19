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
