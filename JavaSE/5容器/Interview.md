## Java中数组是不是对象
数组是指具有相同类型的数据的集合，具有固定的长度并且在内存占据连续的空间；
在Java中，数组拥有与对象一样的特征，如有自己的属性(length属性)，也有一些方法
可以被调用(clone()方法)，并且每个数组类型都有其对应的类型，可通过 instanceof 来判断数据的类型

## length 属性与 length() 方法有什么区别？
在Java中的数组提供了length属性来获取数组的长度；
而length()方法是针对字符串而言的，String 提供了 length() 方法来计算字符串的长度

## ArrayList与Linked的区别
1.ArrayList是实现了基于**动态数组**的数据结构，因为地址是连续的，数据一旦存储好了，查询操作效率会比较高<br>
2.LinkedList基于**链表**的数据结构，地址是任意的，所以在开辟内存空间的时候不需要等一个连续地址，对于新增和删除的add和remove方法LinkedList是占优势的<br>
3.因为ArrayList的地址是连续的，ArrayList要移动数据，所以插入和删除操作效率较低
4.因为LinkedList要移动指针，所以查询操作性能较低

适用场景：<br>
当需要对数据进行对此访问的情况下选用ArrayList，当需要对数据多次增加删除修改采用LinkedList

## HashSet与TreeSet的比较
1.TreeSet是**二叉树**实现的，TreeSet的数据是自动排序好且不允许存入null值<br>
2.HashSet是**哈希表**实现的，HashSet中的数据是无序的，可以放入null且只能放一个null，这是因为在Set集合中不允许存入重复值，null也如此<br>
3.HashSet要求放入的对象必须实现HashCode()方法，放入的对象是以hashCode码作为标识的，而具有相同内容的String对象，hashCode是一样的，所以放入的内容
不能重复；但是同一个类的对象可以放入不同的实例<br>

适用场景：<br>
HashSet是基于Hash算法的，器性能通常优于TreeSet，我们通常都应该使用HashSet；但我们需要排序功能时才会使用TreeSet

## HashMap和ConcurrentHashMap的区别
1.HashMap不是线程安全的，而ConcurrentHashMap是线程安全的<br>
2.ConcurrentHashMap采用了**锁分段**技术，将整个**Hash桶**进行了分段**segment**，也就是大
的数组分成了几个小的片段的**segment**，而且每个**segment**都有锁存在，那么在插入元素的时候就
需要先找到应该插入那一个片段**segment**，然后再这个片段上面进行插入，而且这里还需要获取**segment**锁<br>
3.ConcurrentHashMap让锁的**粒度**更精细一点，并发性能更好<br>

## HashTable和ConcurrentHashMap的区别
都用于多线程的环境下，但是当HashTable的大小增加到一定的时候，性能就会急剧下降，因为迭代时需要被
锁定很长的时间。ConcurrentHashMap引入了**分割**，不论它变得多么大，仅仅需要锁定map的某个部分，
而其他的线程就不需要等到迭代完成才能访问map；<br>

简而言之，在迭代的过程中，ConcurrentHashMap仅仅锁定map的某个部分，而HashTable则会锁定整个map

## 如何让Map集合保证线程安全又效率高
在JDK5中提供了`ConcurrentHashMap`，它是`HashTable`的替代，比`HashTable`扩展性更好

`ConcurentHashMap`将整个Map分为N个segment(类似HashTable)，可以提供相同的线程安全，但是
效率比HashTable提高了N倍，默认N为16

## 怎么样让HashMap同步

调用语句`Map m = Collections.synchronizeMap(hashMap)`;

