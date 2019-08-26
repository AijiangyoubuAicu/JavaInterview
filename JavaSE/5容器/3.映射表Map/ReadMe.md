# Map

## 概述

`java.util.Map<k, v>`将键映射到值的对象，一个映射不能含有重复的键，每个键最多只能映射一个到一个值；

特点:
- 双列集合，一个元素包含两个值(一个key，一个value)
- key和value的数据类型可以相同，也可以不同
- key不允许重复，value可以重复
- key与value是一一对应的关系

该接口取代了`Dictionary`类，该类是一个抽象类，而不是接口，其映射表类`HashTable`就是实现该抽象类；
> 线程安全的类不再使用`HashTable`，而是使用`Map`接口下的`ConcurrentHashMap`实现类

![](../img/Collection与Map.bmp)

- `Collection`中的集合，元素是孤立存在的，向集合中存储元素采用的是一个个元素的方式存储
- `Map`中的集合，元素是成对存在的，每个元素由`键`和`值`两个部分组成，通过键可以找到对应的值
- `Collection`中的集合称为`单例集合`，`Map`中的集合称为`双列集合`
- 需注意的是：`Map`中的集合不能包含重复的键，值可以重复，每个键只能对应一个值

## 常用实现类
- HashMap<K, V>
  存储数据采用的是**哈希表**+**链表**+**红黑树(链表长度超过8)**(JDK8以前是**哈希表**+**链表**)结构，元素的存储顺序不能保证一致，通过哈希表可以保证键的唯一且不重复，需要传入键的对象值重写`hashCode()`和`equals()`方法
  
- LinkedHashMap<K, V>
  HashMap下有个子类`LinkedListHash`，存储的数据采用的**哈希表**+**链表**结构，通过链表结构可以保证元素的**存取顺序**一致；通过哈希表可以保证键的唯一且不重复，需要传入键的对象重写`hashCode()`和`equals()`方法
  
## 常用方法
- `public V put(K key, V value)` 把指定的键与指定的值添加到Map集合中
- `public V remove(Object key)`
  把指定的键多对应的键值对元素在Map集合中删除，返回被删除元素的值
- `public V get(Object key)` 根据指定的键，在Map集合中获取对应的值
- `public boolean containsKey(Object key)` 判断集合中是否包含指定的键
- `public Set<K> keySet()` 获取Map集合中的所有的键，存储到Set集合中
- `public Set<Map.Entry<K, V>> entrySet()`
  获取Map集合中所有的键值对对象的集合(Set集合)
  
```java
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
     *      存储键值对的时候，key重复，会使用新的value覆盖map中重复的value，返回被替换的value值
     */
    private static void show01() {
        // 创建Map集合对象，以多态的形式
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
```

## Map遍历方式

## 键找值方式

键找值方式：即通过元素中的键，获取键所对应的值

步骤：

1.获取 Map 中的所有的键，由于键是唯一的，所以可以使用方法`keySet()`返回一个 Set
集合存储的所有的键<br> 2.遍历键的Set集合，得到每一个键<br> 3.根据键，通过`get(K
key )`获取键对应的值

![](../img/Map集合遍历方式一.bmp)

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的第一种遍历方式：通过键找值的方式
 * 方法：Set<K> key() 返回此映射中包含的键的Set视图
 *
 * 步骤：
 *  1.使用Map集合中的方法keySet()，把Map集合中所有的key取出来，存储到Set集合中
 *  2.遍历Set集合，获取Map集合中的每一个key
 *  3.通过Map集合中的方法 get(key)，通过 key 找到 value
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
        // 1.使用Map集合中的方法keySet()，把Map集合中的key取出来存储到一个Set集合中
        Set<String> set = map.keySet();

        // 2.通过迭代器遍历Set集合，获取Map集合中的每一个key
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            // 3.通过Map集合中的方法get(key)，通过key找到value
            Integer value = map.get(key);
            System.out.println(key + "：" + value);
        }

        /**
         * 增强 for 循环
         */
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + "：" + value);
        }
    }
}
```

### Entry 键值对对象及遍历 Map 集合

#### Entry 对象

`Map.Entry(K,
V)`是`Map`接口中的**内部接口**，作用是：当`Map`集合一创建时，那么就会在`Map`集合中创建一个
Entry 对象，用来记录和键与值(映射项)

`Map`中存放的是两种对象，一种称为`key(键)`，一种称为`value(值)`，在`map`中是一一对应关系，
这一对对象又称为`map`中的一个`Entry(项)`，`Entry`将键值对的对应关系封装成了对象，即**键值对对象**；
这样我们在遍历`Map`集合时，就可以从每一个键值对`Entry`对象中获取对应的键和对应的值

`Entry`对象获取对应键和对应值的方法 
- `public K getKey()` 获取 Entry 对象中的键
- `public V getValue()` 获取 Entry 对象中值

在 Map 集合中也提供了获取对应的 Entry 对象的方法：
- `public Set<Map.Entry<K, V>> entrySet()` 获取到 Map
  集合中所有的键值对对象的集合(Set集合)
  
#### 遍历

键值对的方式：即通过集合中每个键值对`Entry`对象，获取键值对`Entry`对象中的键与值

步骤： 

1.获取Map集合中的所有的键值对Entry对象，通过`entrySet()`方法以Set集合的形式返回<br>
2.遍历包含键值对Entry对象的Set集合，得到每一个键值对Entry对象<br>
3.通过键值对Entry对象，通过`getKey()与getValue()`获取Entry对象中的键与值

![](../img/Map集合遍历方式二.bmp)

```java
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
```
