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

        /**
         * 1.使用集合中的方法 Iterator<E> iterator() 获取迭代器的实现类对象，使用 Iterator 接口接收(多态)
         *   注意：
         *     Iterator<E> 也是有泛型的，迭代器的泛型跟着集合走，集合是什么泛型，迭代器就是什么泛型
         */
        Iterator<String> it = coll.iterator();
        System.out.println(it);     // java.util.ArrayList$Itr@2d98a335

        /**
         * 发现使用迭代器取出集合元素中的代码，是一个重复的过程
         * 所以我们可以使用循环来优化，不知道集合中有多少个元素，使用 while 循环
         * 循环结束的条件，hasNext() 方法返回 false
         */
        while (it.hasNext()) {
            String e = it.next();
            System.out.println(e);
            /*
            姚明
            科比
            麦迪
            詹姆斯
            艾弗森
             */
        }

        /**
         * 2.使用集合中 Iterator 接口中的方法 hasNext() 判断还有没有下一个元素
         */
//        boolean b = it.hasNext();
//        System.out.println(b);      // true
        /**
         * 3.使用 Iterator 接口中的方法 next() 取出集合中的下一个元素
         */
//        String s = it.next();
//        System.out.println(s);      // 姚明
//        System.out.println(coll);   // [姚明, 科比, 麦迪, 詹姆斯, 艾弗森]
//
//        // 遍历完所有元素，再次调用 hasNext() 方法进行判断
//        b = it.hasNext();
//        System.out.println(b);      // true
//        s = it.next();
//        System.out.println(s);      // 科比
//
//        b = it.hasNext();
//        System.out.println(b);      // true
//        s = it.next();
//        System.out.println(s);      // 麦迪
//
//        b = it.hasNext();
//        System.out.println(b);      // true
//        s = it.next();
//        System.out.println(s);      // 詹姆斯
//
//        b = it.hasNext();           // true
//        System.out.println(b);
//        s = it.next();              // 艾弗森
//        System.out.println(s);
//        // 已经遍历完元素，再次调用方法
//        b = it.hasNext();
//        System.out.println(b);      // false
//        System.out.println(coll);   // [姚明, 科比, 麦迪, 詹姆斯, 艾弗森]
//        // 再取一次，会抛出异常
//        try {
//            s = it.next();
//        } catch (NoSuchElementException e) {
//            System.err.println(e.getClass().getName() + "：没有匹配的元素异常");
//            // java.util.NoSuchElementException：没有匹配的元素异常
//        }
//
    }

}
