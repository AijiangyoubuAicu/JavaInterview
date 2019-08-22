import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用DateFormat类中的方法parse,把文本解析为日期
 *
 * 注意：parse方法声明了一个异常叫ParseException
 *  public Date parse(String source) throws ParseException
 *
 */
public class TestDate02 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        try {

            Date date = sdf.parse("2018年08月22日 17时51分54秒");
            System.out.println(date);   // Wed Aug 22 17:51:54 CST 2018

            String str = sdf.format(date);
            System.out.println(str);

        // DateFormat声明了一个"解析异常"
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
