import java.math.BigDecimal;

/**
 * BigDecimal运算测试
 */
public class Demo01_BigDecimal {

    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal(0.005);
        BigDecimal num2 = new BigDecimal(1000000);
        BigDecimal num3 = new BigDecimal(-100000);
        // 尽量用字符串的形式初始化
        BigDecimal num12 = new BigDecimal("0.005");
        BigDecimal num22 = new BigDecimal("1000000");
        BigDecimal num32 = new BigDecimal("-1000000");

        // 加法
        BigDecimal result1 = num1.add(num2);
        BigDecimal result12 = num12.add(num22);
        System.out.println(result1);    // 1000000.005000000000000000104083408558608425664715468883514404296875
        System.out.println(result12);   // 1000000.005

        //减法
        BigDecimal result2 = num1.subtract(num2);
        BigDecimal result22 = num12.subtract(num22);
        System.out.println(result2);    // -999999.994999999999999999895916591441391574335284531116485595703125
        System.out.println(result22);   // -999999.995

        //乘法
        BigDecimal result3 = num1.multiply(num2);
        BigDecimal result32 = num12.multiply(num22);
        System.out.println(result3);    // 5000.000000000000104083408558608425664715468883514404296875000000
        System.out.println(result32);   // 5000.000

        //绝对值
        BigDecimal result4 = num3.abs();
        BigDecimal result42 = num32.abs();
        System.out.println(result4);    // 100000
        System.out.println(result42);   // 1000000

        //除法
        BigDecimal result5 = num2.divide(num1,20,BigDecimal.ROUND_HALF_UP);
        BigDecimal result52 = num22.divide(num12,20,BigDecimal.ROUND_HALF_UP);
        System.out.println(result5);    // 199999999.99999999583666365766
        System.out.println(result52);   // 200000000.00000000000000000000

    }
}
