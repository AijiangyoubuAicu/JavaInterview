import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * java.util.Iterator接口：迭代器(对集合进行遍历)
 *
 * 有两个常用方法：
 *     1) boolean hasNext() 如果仍有元素可以迭代，则返回 true
 *        判断集合中还有没有下一个元素，有就返回true，没有就返回false
 *     2) E next() 返回迭代的下一个元素
 *        取出集合中的下一个元素
 *
 * Iterator 迭代器，是一个接口，我们无法直接使用，需要使用Iterator接口的实现类对象，获取实现类的方式较为特殊
 * Collection 接口有一个方法：
 *          Iterator<E> iterator()
 *       这个方法返回的就是迭代器的实现类对象
 *
 * 迭代器的使用步骤：
 *      1) 使用集合中的方法 iterator() 获取迭代器的实现类对象，使用 Iterator 接口接收(多态)
 *      2) 使用 Iterator 接口中的方法 hasNext() 判断还有没有下一个元素
 *      3) 使用 Iterator 接口中的方法 next() 取出元素的下一个元素
 *
 */
public class Demo01 {

    public static void main(String[] args) {
        // 创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        // 往集合中添加元素
        coll.add("姚明");
        coll.add("科比");
        coll.add("麦迪");
        coll.add("詹姆斯");
        coll.add("艾弗森");
        System.out.println(coll);   // [姚明, 科比, 麦迪, 詹姆斯, 艾弗森]

        Iterator<String> iterator = coll.iterator();
        System.out.println(iterator);     // java.util.ArrayList$Itr@2d98a335

        /**
         * 使用 Lambda 表达式简化迭代器的书写
         */
        iterator.forEachRemaining(element -> System.out.println(element));

    }

}
