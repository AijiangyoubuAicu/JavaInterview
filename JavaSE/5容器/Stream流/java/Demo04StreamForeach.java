import java.util.stream.Stream;

public class Demo04StreamForeach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张无忌", "张三丰", "周芷若");
        stream.forEach(name -> System.out.print(name + " "));   // 张无忌 张三丰 周芷若
    }
}
