import java.util.*;
import java.util.stream.Stream;

/**
 * 容器的获取 Stream 流
 */
public class Demo03GetStream {
    public static void main(String[] args) {
        /**
         * 数组的获取流
         */
        String[] array = {"张无忌", "张翠山", "张三丰", "张一元"};
        Stream<String> stream = Stream.of(array);

        /**
         * List 集合的获取流
         */
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        /**
         * Set 集合的获取流
         */
        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        /**
         * Vector 集合的获取流
         */
        Vector<String> vector = new Vector<>();
        Stream<String> stream3 = vector.stream();

        /**
         * Map 集合的获取流
         */
        Map<String, String> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<String> valueStream = map.values().stream();
        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();

    }
}
