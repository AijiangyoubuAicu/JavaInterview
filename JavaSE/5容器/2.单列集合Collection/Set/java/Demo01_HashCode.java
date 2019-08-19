/**
 * 哈希值：是一个十进制的整数，由系统随机给出(就是对象的地址值，是一个
 *  逻辑地址，是模拟出来得到的地址，不是数据实际存储的物理地址)在Object类中
 *  由一个方法，可以获取对象的哈希码值
 *      int hashCode() 返回该对象的哈希码值
 *
 *  hashCode()方法的源码：
 *      public native int hashCode();
 *      native：代表着该方法调用的是本地操作系统的方法
 */
public class Demo01_HashCode extends Object {
    public static void main(String[] args) {
        // Demo01_Collection继承(默认)了Object类，可以使用Object类的hashCode()方法
        Person p1 = new Person();
        int h1 = p1.hashCode();
        System.out.println(h1);     // 381259350

        Person p2 = new Person();
        int h2 = p2.hashCode();
        System.out.println(h2);     // 2129789493

        /**
         * toString()方法源码：
         *  public String toString() {
         *      return getClass.getName() + "@" + Integer.toHexString(hashCode());
         *  }
         *
         */
        System.out.println(p1);     // collection.Set.Person@16b98e56
        System.out.println(p2);     // collection.Set.Person@7ef20235
        System.out.println(p1 == p2);   // false

        // collection.Set.Person 可以重写hashCode()的方法，但需要注意的是即使哈希码值相同，两个对象也是不相同的，因为对象的地址值实际与哈希码值无关

        /**
         * String类的哈希值
         *  String类重写了Objcet类的hashCode()方法
         */
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode());  // 96354
        System.out.println(s2.hashCode());  // 96354
        System.out.println(s1 == s2);       // false

        String s3 = "重地";
        String s4 = "通话";
        System.out.println(s3.hashCode());  // 1179395
        System.out.println(s4.hashCode());  // 1179395
        System.out.println(s3 == s4);       // false

    }

}
