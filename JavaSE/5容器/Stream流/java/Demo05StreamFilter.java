import java.util.stream.Stream;

public class Demo05StreamFilter {
    public static void main(String[] args) {
        Stream<String> orginal = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = orginal.filter(s -> s.startsWith("张"));
    }
}
