import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo11Demo {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

        // 第一个队伍只要名字为3个字的成员姓名
        // 第一个队伍筛选之后只要前3个
        Stream<String> streamOne = one.stream().filter(s -> s.length() == 3).limit(3);

        // 第二个队伍只要姓张的成员姓名
        // 第二个队伍筛选之后不要前2个
        Stream<String> streamTwo = two.stream().filter(s -> s.startsWith("张")).skip(2);

        // 将两个队伍合并成一个队伍
        // 根据姓名创建Person对象
        // 打印整个队伍的Person对象信息
        Stream.concat(streamOne, streamTwo).map(Person_Stream::new).forEach(System.out::println);
        /*
        Person_Stream{name='宋远桥'}
        Person_Stream{name='苏星河'}
        Person_Stream{name='石破天'}
        Person_Stream{name='张天爱'}
        Person_Stream{name='张二狗'}
         */
    }
}
