import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set集合
 *  1.不允许存储重复的元素
 *  2.没有索引，没有带索引的方法，也不能使用普通的for循环遍历，只能用迭代器
 *  3.是一个无序的集合，存储元素和取出元素的顺序可能不一致
 *  4.底层是一个哈希表结构(查询速度非常快)
 */
public class Demo01_Set {
    public static void main(String[] args) {
        // 使用HashSet()实现类
        Set<Integer> set = new HashSet<>();
        // 使用add()方法往集合中添加元素
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1); // 重复元素
        System.out.println(set);        // [1, 2, 3]
        // 使用迭代器遍历set集合
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer n = it.next();
            System.out.print(n + " ");  // 1 2 3
        }
        // 还可以使用增强for循环遍历
        System.out.println();
        System.out.println("-----------");
        for (Integer i : set) {
            System.out.print(i + " ");  // 1 2 3
        }
    }
}
