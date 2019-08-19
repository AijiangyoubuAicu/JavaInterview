import java.util.HashMap;
import java.util.Map;

/**
 * Map接口的常用方法
 *
 */
public class Demo02_map {

    public static void main(String[] args) {
        show01();
        show02();
        show03();
        show04();
    }

    /**
     * public V put(K key, V value) 把指定的键与指定的值添加到Map集合中
     *  返回值：V value
     *      存储键值对的时候，key不重复，返回值value是null
     *      存储键值对的时候，key重复，会使用新的value替换map中重复的value，返回被替换的value值
     */
    private static void show01() {
        // 创建Map集合对象
        Map<String, String> map = new HashMap<>();
        String v1 = map.put("李晨", "范冰冰1");
        System.out.println("v1:" + v1);     // v1:null
        System.out.println(map);            // {李晨=范冰冰1}
        String v2 = map.put("李晨", "范冰冰2");
        System.out.println("v2:" + v2);     // v2:范冰冰1
        System.out.println(map);            // {李晨=范冰冰2}

        map.put("冷锋", "龙小云");
        map.put("杨过", "小龙女");
        System.out.println(map);            // {杨过=小龙女, 李晨=范冰冰2, 冷锋=龙小云}
    }

    /**
     * public V remove(Object key) 把指定的键所对应的键值对元素在Map集合中删除，返回被删除元素的值
     *  返回值：V value
     *      key存在，value返回被删除的值
     *      key不存在，value返回null
     */
    private static void show02() {
        Map<String, Integer> map = new HashMap<>();
        map.put("赵丽颖", 168);
        map.put("杨毅", 165);
        map.put("林志玲", 178);
        System.out.println(map);            // {杨毅=165, 林志玲=178, 赵丽颖=168}

        Integer v1 = map.remove("林志玲");
        System.out.println("v1:" + v1);     // v1:178
        System.out.println(map);            // {杨毅=165, 赵丽颖=168}

        Integer v2 = map.remove("林志疑");
        System.out.println("v2:" + v2);     // v2:null
        System.out.println(map);            // {杨毅=165, 赵丽颖=168}
    }

    /**
     * public V get(Object key) 根据指定的键，在Map集合中获取对应的值
     *  返回值：
     *      key不存在，返回对应的value值
     *      key不存在，返回null
     */
    private static void show03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("赵丽颖", 168);
        map.put("杨毅", 165);
        map.put("林志玲", 178);
        System.out.println(map);            // {杨毅=165, 林志玲=178, 赵丽颖=168}

        Integer v1 = map.get("林志玲");
        System.out.println("v1:" + v1);     // v1:178

        Integer v2 = map.get("林志林");
        System.out.println("v2:" + v2);     // v2:null
    }

    /**
     * public boolean containsKey(Object key) 判断集合中是否包含指定的值
     *  包含返回true，不包含则返回false
     */
    private static void show04() {
        Map<String, Integer> map = new HashMap<>();
        map.put("赵丽颖", 168);
        map.put("杨毅", 165);
        map.put("林志玲", 178);
        System.out.println(map);            // {杨毅=165, 林志玲=178, 赵丽颖=168}

        boolean b1 = map.containsKey("赵丽颖");    // true
        System.out.println(b1);

        boolean b2 = map.containsKey("赵颖");     // false
        System.out.println(b2);
    }
}
