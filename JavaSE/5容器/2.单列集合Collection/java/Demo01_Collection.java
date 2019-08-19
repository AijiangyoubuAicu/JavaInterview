import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection接口
 * 所有单列集合的最顶级的接口，定义了所有单列集合共性的方法
 * 任意的单列集合都可以使用Collection接口中的方法
 *
 * 所有的共性方法：
 *      - public boolean add(E e) 把给定的对象添加到当前对象中
 * 		- public void clear() 清空集合中所有的元素
 * 		- public boolean remove(E e) 把给定的对象在当前集合中删除
 * 		- public boolean contains(E e) 判断当前集合中是否包含给定的对象
 * 		- public int size() 返回集合中的个数
 * 		- public Object[] toArray() 把集合中的元素，存储到数组中
 */
public class Demo01_Collection {

    public static void main(String[] args) {
        // 创建集合对象，可以使用多态
        Collection<String> coll = new ArrayList<>();
        // 重写了toString()方法，返回了一个 []
        System.out.println(coll);   // []

        /**
         * public boolean add(E e) 把给定的对象添加到当前集合中
         * 返回值是一个boolean值，一般都会返回true，所以可以不用接收
         */
        boolean b1 = coll.add("张三");
        System.out.println("b1:" + b1);     // b1:true
        System.out.println(coll);           // [张三]
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        coll.add("田七");                     // [张三, 李四, 王五, 赵六, 田七]
        System.out.println(coll);

        /**
         * public boolean remove(E e) 把给定的元素在当前集合中删除
         * 返回值是一个boolean值，集合中存在元素，删除元素，返回true；集合中不存在元素，删除失败，则返回false
         */
        boolean b2 = coll.remove("赵六");
        System.out.println("b2:" + b2);     // b2:true
        boolean b3 = coll.remove("赵四");
        System.out.println("b3:" + b3);     // b3:false
        System.out.println(coll);           // [张三, 李四, 王五, 田七]

        /**
         * public boolean contains(E e) 判断当前集合中是否包含给定的对象
         * 包含返回true，不包含则返回false
         */
        boolean b4 = coll.contains("李四");
        System.out.println("b4:" + b4);     // b4:true
        // 返回一个不存在的
        boolean b5 = coll.contains("赵四");
        System.out.println("b5:" + b5);     // b5:false

        /**
         * public boolean isEmpty()
         * 判断当前集合是否为空，集合为空返回true，集合不为空则返回false
         */
        boolean b6 = coll.isEmpty();
        System.out.println("b6:" + b6);     // b6:false

        /**
         * public int size()
         * 返回集合中元素的个数
         */
        int size = coll.size();
        System.out.println(size);           // 4

        /**
         * public Object[] toArray()
         * 把集合中的元素，存储到数组中
         */
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            /*
              张三
              李四
              王五
              田七
            */
        }

        /**
         * public void clear()
         * 清空集合中所有的元素，但是不删除集合，集合还存在
         */
        coll.clear();
        System.out.println(coll);   // []
    }
}
