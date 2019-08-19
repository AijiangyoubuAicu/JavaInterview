import java.util.HashSet;

/**
 * Set集合不允许存储重复元素的原理
 *  前提与必须：存储的元素必须重写了 hashCode() 和 equals() 方法
 */
public class Demo02_Set {

    public static void main(String[] args) {
        // 创建HashSet集合对象
        HashSet<String> set = new HashSet<>();
        /**
         * "哈希冲突"hashCode()判断元素是否相同
         *
         * add()方法会调用类的hashCode()方法，计算出hashCode的值，当前已
         * 存储了s1这个元素的哈希码值，所以s2进行比较时发现已存在该哈希码则拒绝添加
         */
        String s1 = new String("abc");
        System.out.println(s1.hashCode());      // 96354
        String s2 = new String("abc");
        System.out.println(s2.hashCode());      // 96354
        set.add(s1);
        // 添加失败
        set.add(s2);

        /**
         * "哈希冲突"与equals()方法判断元素是否相同
         *
         * 此处造成了"哈希冲突"，哈希值是相同，但是两个元素在内部还会进行
         * 一次equals()方法的比较，此处两个字符串比较返回true，则会添加
         * 到同哈希码值下的链表中
         */
        String s3 = "重地";
        set.add(s3);
        System.out.println(s3.hashCode());      // 1179395
        String s4 = "通话";
        // 添加成功
        set.add(s4);
        System.out.println(s4.hashCode());      // 1179395

        // 拒绝添加
        set.add("abc");
        System.out.println("abc".hashCode());   // 96354
        System.out.println(set);    // [重地, 通话, abc]
    }
}
