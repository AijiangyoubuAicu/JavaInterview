import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * java.util.LinkedSet集合 extends HashSet集合
 *
 * LinkedHashSet集合特点：
 *      底层是一个哈希表(数组+链表/红黑树) + 链表；
 *      多了一条链表(记录元素的存储顺序)，保证元素有序
 */
public class Demo04_Set {

    public static void main(String[] args) {
        /**
         * 无序的，不允许重复
         */
        HashSet<String> set = new HashSet<>();
        set.add("www");
        set.add("abc");
        set.add("abc");
        set.add("itcast");
        System.out.println(set);    // [abc, www, itcast]

        /**
         * 有序的，不允许重复
         */
        LinkedHashSet<Object> linked = new LinkedHashSet<>();
        linked.add("www");
        linked.add("abc");
        linked.add("abc");
        linked.add("itcast");       // [www, abc, itcast]
        System.out.println(linked);

    }
}
