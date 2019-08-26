import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的第一种遍历方式：使用 Entry 对象遍历
 *
 * Map集合中的方法：
 *      Set<Map.Entry<E, V>> entrySet() 返回此映射中包含关系的 Set 视图
 *
 * 步骤：
 *  1.使用 Map 集合中的方法 keySet()，把Map集合中所有的 key 取出来，存储到 Set 集合中
 *  2.遍历 Set 集合，获取每一个 Entry 对象
 *  3.使用 Entry 对象中的方法 getKey() 和 getValue() 获取键与值
 */
public class Demo01_KeySet {
    public static void main(String[] args) {
        // 创建Map集合对象
        Map<String, Integer> map = new HashMap<>();
        map.put("赵丽颖", 168);
        map.put("杨颖", 165);
        map.put("林志玲", 178);

        /**
         * 迭代器遍历
         */
        // 1.使用Map集合中的方法entrySet()，把Map集合中的Entry对象取出来存储到一个Set集合中
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        // 2.通过迭代器遍历Set集合，获取Map集合中的每一个key
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            // 3.通过Entry集合中的方法getKey()和getValue()方法获取键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "：" + value);
        }

        /**
         * 增强 for 循环
         */
        for (Map.Entry<String, Integer> entry: set) {
           String key = entry.getKey();
           Integer value = entry.getValue();
           System.out.println(key + "：" + value);
        }
    }
}