import java.util.stream.Stream;

public class Demo08StreamLimit {
    public static void main(String[] args) {
        Stream<String> orginal = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = orginal.limit(2);
        System.out.println(result.count()); // 2
    }
}
