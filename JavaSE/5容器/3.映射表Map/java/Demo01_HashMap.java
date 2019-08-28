import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * HashMap 存储自定义类型键值时，要保证 key 值是唯一的
 *
 * 保证 key 值是唯一的条件：作为 key 的元素必须重写 hashCode() 和 equals() 方法，以保证 key 唯一
 */
public class Demo01_HashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("c", "c");
        map.put("b", "b");
        map.put("a", "d");
        // key 值不允许重复，无序集合
        System.out.println(map);    // {a=d, b=b, c=c}

        Map<String, String> linked = new LinkedHashMap<>();
        linked.put("a", "a");
        linked.put("c", "c");
        linked.put("b", "b");
        linked.put("a", "d");
        // key 值不允许重复，有序集合
        System.out.println(linked); // {a=d, c=c, b=b}

    }
}
