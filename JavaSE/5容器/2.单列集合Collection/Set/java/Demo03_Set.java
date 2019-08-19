import java.util.HashSet;

/**
 * HashCode 存储自定义类型元素
 *
 * Set集合报错元素唯一：
 *      存储的元素(String, Integer, .... Student, Person ....)
 *      必须重写hashCode()方法和equals()方法
 *
 * 要求：
 *      同名同年龄的人，视为同一个人，只能存储一次
 *
 *
 */
public class Demo03_Set {

    public static void main(String[] args) {
        test01();
        test02();
    }

    /**
     * Person未重写了hashCode()和equals()方法
     */
    private static void test01() {
        // 创建HashSet()集合存储Person
        HashSet<PersonNotRewrite> set = new HashSet<>();
        PersonNotRewrite nr01 = new PersonNotRewrite("美少女", 18);
        PersonNotRewrite nr02 = new PersonNotRewrite("美少女", 18);
        PersonNotRewrite nr03 = new PersonNotRewrite("美少女", 19);
        /**
         * 未重写hashCode()方法，将会导致哈希码值不相同
         */
        int hash01 = nr01.hashCode();
        System.out.println(hash01);     // 381259350
        int hash02 = nr02.hashCode();   // 2129789493
        System.out.println(hash02);
        System.out.println(hash01 == hash02);   // false
        /**
         * 两个String的地址值也不相同
         */
        System.out.println(nr01.equals(nr02));  // false
        set.add(nr01);
        set.add(nr02);
        set.add(nr03);
        System.out.println(set);    // [PersonNotRewrite{name='美少女', age=19}, PersonNotRewrite{name='美少女', age=18}, PersonNotRewrite{name='美少女', age=18}]

    }

    /**
     * Person未重写了hashCode()和equals()方法
     */
    private static void test02() {
        // 创建HashSet()集合存储Person
        HashSet<PersonRewrite> set = new HashSet<>();
        PersonRewrite r01 = new PersonRewrite("美少女", 18);
        PersonRewrite r02 = new PersonRewrite("美少女", 18);
        PersonRewrite r03 = new PersonRewrite("美少女", 19);
        int hash01 = r01.hashCode();
        System.out.println(hash01);     // 996155971
        int hash02 = r02.hashCode();
        System.out.println(hash02);     // 996155971
        System.out.println(hash01 == hash02);   // true
        set.add(r01);
        set.add(r02);
        set.add(r03);
        System.out.println(set);    // [PersonRewrite{name='美少女', age=18}, PersonRewrite{name='美少女', age=19}]

    }
}
