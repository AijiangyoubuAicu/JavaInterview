import java.util.ArrayList;

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
