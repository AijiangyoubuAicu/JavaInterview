import java.util.ArrayList;
import java.util.List;

/**
 * 使用 foreach 循环实现过滤
 */
public class Demo01NormalFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        System.out.println(list);   // [张无忌, 周芷若, 赵敏, 张强, 张三丰]

        /**
         * 过滤出含有“张”的子集
         */
        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }
        System.out.println(zhangList);  // [张无忌, 张强, 张三丰]

        /**
         * 在上述的子集过滤出含有3个字以上名字的子集
         */
        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                shortList.add(name);
            }
        }
        System.out.println(shortList);  // [张无忌, 张三丰]
    }

}
