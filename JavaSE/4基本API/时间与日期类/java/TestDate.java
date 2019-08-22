import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        Date date = new Date();
        System.out.println(date);

        date = new Date(0L);
        System.out.println(date);

        date = new Date(1566465065245L);
        System.out.println(date);

        date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }
}
