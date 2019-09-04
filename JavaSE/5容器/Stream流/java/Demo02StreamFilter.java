import java.util.ArrayList;
import java.util.List;

/**
 * 使用 Stream 流循环实现过滤
 */
public class Demo02StreamFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        System.out.println(list);   // [张无忌, 周芷若, 赵敏, 张强, 张三丰]

        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);
        /*
         * 张无忌
         * 张三丰
         */

    }

}
