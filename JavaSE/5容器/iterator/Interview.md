## ConcurrentModificationException异常出现的原因
```java
import java.util.ArrayList;
import java.util.Iterator;

public class ExceptionDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                list.remove(integer);
                // 改为iterator.remove()
            }
        }
    }
}
```
为什么上述会抛出`java.util.ConcurrentModificationException(并发修改异常)`异常？
- 原因：因为调用了`list.remove()`方法导致`modCount`和`expectedModCount`的值不一致
- 解决办法：想要在迭代器中删除元素的话，需要调用`Iterator`类的`remove`方法

即 `list.remove(integer)` --> `iterator.remove()` 