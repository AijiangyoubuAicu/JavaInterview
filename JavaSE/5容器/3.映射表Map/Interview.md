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

