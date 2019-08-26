# Iterator迭代器
	
## Iterator接口
	
在程序开发中，经常要遍历集合中的所有元素，针对这种需求，JDK专门提供了一个接口 java.util.Iterator ,
Iterator 接口也是Java集合中的一员，但它与 Collection、Map 接口有所不同，，Collection 接口与 Map 接口
主要用于存储元素，而 Iterator 主要用于迭代访问(即遍历) Collection 中的元素，因此 Iterator 也称为迭代器；
	
想要遍历 Collection 集合，那么就要获取该集合迭代器完成迭代操作，获取迭代器的方法：
		
	public Iterator collection.iterator()：获取集合对应的迭代器，用来遍历集合中的元素的
	
迭代：即 Collection 集合元素的通用获取方式，在取元素之前要判断集合中有没有元素，如果有，就把这个元素取出来，继续判断
如果还有就再取出来，一直把集合中的所有元素全部取出，这种取出方式专业术语就叫做"迭代"；

## Iterator 常用的方法：
		
	- public E next() 返回迭代的下一个元素
	- public boolean hasNext() 如果仍有元素可以迭代，则返回true
	- public void remove() 从迭代器指向的 Collection 中移除迭代器返回的最后一个操作(可选操作)

## 获取迭代器：
Iterator 迭代器，是一个接口，我们无法直接使用，需要使用Iterator接口的实现类对象，获取实现类的方式较为特殊
	
Collection 接口有一个方法：

	Iterator<E> iterator()
	
这个方法返回的就是迭代器的实现类对象

```java
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
        Iterator<String> iterator = coll.iterator();
        System.out.println(iterator);     // java.util.ArrayList$Itr@2d98a335

        /**
         * 发现使用迭代器取出集合元素中的代码，是一个重复的过程
         * 所以我们可以使用循环来优化，不知道集合中有多少个元素，使用 while 循环
         * 循环结束的条件，hasNext() 方法返回 false
         */
        // 2.使用集合中 Iterator 接口中的方法 hasNext() 判断还有没有下一个元素
        while (it.hasNext()) {
            // 3.使用 Iterator 接口中的方法 next() 取出集合中的下一个元素
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
    }
}
```
	 
## 迭代器的使用步骤：

- 使用集合中的方法 iterator() 获取迭代器的实现类对象，使用 Iterator 接口接收(多态)
- 使用 Iterator 接口中的方法 hasNext() 判断还有没有下一个元素
- 使用 Iterator 接口中的方法 next() 取出元素的下一个元素

## 迭代器的执行原理
		
1) 获取迭代器的实现类 iterator() ，同时会把指针(索引)指向集合的 -1 索引
			 (此处要记得"迭代器"的判断与取出是针对"下一个元素"，所以操作的是索引0的元素)
2) hasNext() 方法判断"下一个元素"是否存在
3) next() 方法取出"下一个元素"时还会把指针向后移动一位

![](02_迭代器的实现原理(1).bmp)

## 增强 for 循环
		
增强 for循环 (也成为foreach循环)是JDK1.5之后推出的一个高级for循环，专门用来遍历数组和集合的，它的
内部原理其实也是个 Iterator 迭代器，所以在遍历的过程中，不能对集合的元素进行增删操作

格式：
	
	for(元素的数据类型 变量 : Collection集合or数组) {
	  // 写操作代码
	}
			
它用来遍历 Collection 和数组，通常只进行遍历元素，不要再遍历的过程中对集合元素进行增删操作；
		
- 注意1：foreach循环需要实现 Iterable<T> 接口，该接口有获取迭代器的抽象方法，
		只有实现了该接口才会被编译器认可使用foreach循环
		
- 注意2：新for循环必须有被遍历的目标，目标只能是Collection或者是数组，新式for仅仅作为遍历操作出现

```java
/**
 * 增强for循环：底层使用的也是迭代器，使用for循环的格式，简化了迭代器的书写，是JDK1.5之后推出的新特性
 *
 * 格式：
 *      for(集合/数组的数据类型 变量名 : 集合名/数组名) {
 *          System.out.println(变量名);
 *      }
 */
public class Demo02 {

    public static void main(String[] args) {
        demo01();   // 1 2 3 4 5
        System.out.println();
        demo02();   // aaa bbb ccc ddd
    }

    // 使用增强for循环遍历数组
    private static void demo01() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // 使用增强for循环遍历集合
    private static void demo02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
```

### JDK8 Lambda 简化书写

在JDK8中，甚至不用写循环，可以直接调用`forEachRemaining`方法并提供一个
lambda表达式即可(它会处理一个元素)，将对迭代器的每一个元素调用这个 lambda表达式，直到没有元素

```java
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
```
