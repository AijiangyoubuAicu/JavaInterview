## HashSet与TreeSet的比较
1.TreeSet是**二叉树**实现的，TreeSet的数据是自动排序好且不允许存入null值<br>
2.HashSet是**哈希表**实现的，HashSet中的数据是无序的，可以放入null且只能放一个null，这是因为在Set集合中不允许存入重复值，null也如此<br>
3.HashSet要求放入的对象必须实现HashCode()方法，放入的对象是以hashCode码作为标识的，而具有相同内容的String对象，hashCode是一样的，所以放入的内容
不能重复；但是同一个类的对象可以放入不同的实例<br>

适用场景：<br>
HashSet是基于Hash算法的，器性能通常优于TreeSet，我们通常都应该使用HashSet；但我们需要排序功能时才会使用TreeSet
