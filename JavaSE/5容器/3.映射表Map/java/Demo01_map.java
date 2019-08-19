/**
 * jav.util.Map<k, V>集合
 * 特点：
 *  1.Map集合是一个双列集合，一个元素包含两个值(一个key，一个value)
 *  2.Map集合中的元素，key和value的数据类型可以相同，也可以不同
 *  3.Map集合中的元素，key是不允许重复的，value是可以重复的
 *  4.Map集合中的元素，key与value是一一对应的
 *
 * java.util.HashMap<k, V>集合 implements Map<k, V>接口
 * HashMap集合的特点：
 *  1.HashMap集合底层是"哈希表"：查询的速度非常的快
 *      JDK1.8之前：数组 + 单向链表
 *      JDK1.8之后：数组 + 单向链表/红黑树(链表的长度超过8之后转换)：为了提供查询的速度
 *  2.hashMap集合是一个无序的集合，存储元素的取出元素的顺序有可能不一致
 *
 * java.util.LinkedHashMap(k, V)集合 extends HashMap(k, V)集合
 * LinkedHashMap的特点：
 *  1.LinkedHashMap集合底层是哈希表 + 链表(保证迭代的顺序)
 *  2.LinkedHashMap集合是一个有序的集合，存储元素和取出元素的顺序是一致的
 */
public class Demo01_map {
    public static void main(String[] args) {

    }
}
