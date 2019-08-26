import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo01_Collection {

    public static void main(String[] args) {
        List<Demo01_Person> list = new ArrayList<>();

        // 使用Collections.addAll(...)方法往集合中添加多个元素
        Collections.addAll(list,
                new Demo01_Person("王刚", 21),
                new Demo01_Person("王云", 18),
                new Demo01_Person("王宏", 25));
        System.out.println(list);

        Collections.sort(list, new Comparator<Demo01_Person>() {

            @Override
            public int compare(Demo01_Person p1, Demo01_Person p2) {
//                return p1.getAge() - p2.getAge(); // 按照年龄“升序”排序
//                return p2.getAge() - p1.getAge(); // 按照年龄“降序”排序
                return 0;   // 不排序

            }
        });

        System.out.println(list);
    }
}
