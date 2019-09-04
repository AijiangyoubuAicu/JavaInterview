import java.util.stream.Stream;

public class Demo10StreamConcat {
    public static void main(String[] args) {
        Stream<String> streamA = Stream.of("张无忌");
        Stream<String> streamB = Stream.of("张翠山");
        Stream<String> result = Stream.concat(streamA, streamB);
        System.out.println(result.count());     // 2
    }
}
