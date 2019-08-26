import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个实现了 Comparable 接口的类
 * 重写排序的接口
 */
class Demo01_Person implements Comparable<Demo01_Person> {

    private String name;
    private int age;

    public Demo01_Person() {
    }

    public Demo01_Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 务必重写 toString() 方法，否则将返回地址值
     * @return 返回集合的属性
     */
    @Override
    public String toString() {
        return "Demo01_Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 实现排序规则的方法
     * @param p
     * @return 返回正负数决定排序规则，如果是0则默认相同不排序，当前为按年龄升序进行排序
     * 降序：p.getAge() - this.getAge()
     */
    @Override
    public int compareTo(Demo01_Person p) {
        return this.getAge() - p.getAge();
    }
}


public class Demo01_Collections {
    public static void main(String[] args) {
        List<Demo01_Person> list = new ArrayList<>();

        // 使用Collections.addAll(...)方法往集合中添加多个元素
        Collections.addAll(list,
                new Demo01_Person("王刚",21),
                new Demo01_Person("王云",18),
                new Demo01_Person("王宏",25));

        System.out.println(list);
        // [Demo01_Person{name='王刚', age=21}, Demo01_Person{name='王云', age=18}, Demo01_Person{name='王宏', age=25}]

        Collections.sort(list);
        System.out.println(list);
        // [Demo01_Person{name='王云', age=18}, Demo01_Person{name='王刚', age=21}, Demo01_Person{name='王宏', age=25}]

    }
}
