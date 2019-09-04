import java.util.stream.Stream;

public class Demo06StreamMap {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("10", "11", "12");
        Stream<Integer> result = original.map(str -> Integer.parseInt(str));
    }
}
