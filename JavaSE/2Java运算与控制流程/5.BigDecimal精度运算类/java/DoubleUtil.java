import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 封装BigDecimal了的一个工具
 */
public class DoubleUtil implements Serializable {

    private static final long serialVersionUID = -6198279108839679132L;

    // 默认除法运算精度
    private static final Integer DEF_DIV_SCALE = 2;

    /**
     * 提供精确的加法运算。
     *
     * @param value1
     *            被加数
     * @param value2
     *            加数
     * @return 两个参数的和
     */
    public static Double add(Number value1, Number value2) {
        if (value1==null) value1 = 0;
        if (value2==null) value2 = 0;
        BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
        BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算。
     * @param value1
     * @return
     */
    public static Double adds(Number... value1) {
        Double value2=0.0;
        for (Number value : value1) {
            if (value==null) value = 0;
            BigDecimal b1 = new BigDecimal(Double.toString(value.doubleValue()));
            BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
            value2=b1.add(b2).doubleValue();
        }
        return value2;
    }

    /**
     * 提供精确的减法运算。
     *
     * @param value1
     *            被减数
     * @param value2
     *            减数
     * @return 两个参数的差
     */
    public static double sub(Number value1, Number value2) {
        if (value1==null) value1 = 0;
        if (value2==null) value2 = 0;
        BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
        BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param value1
     *            被乘数
     * @param value2
     *            乘数
     * @return 两个参数的积
     */
    public static Double mul(Number value1, Number value2) {
        if (value1==null || value2==null){
            return 0D;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
        BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时， 精确到小数点以后10位，以后的数字四舍五入。
     *
     * @param dividend
     *            被除数
     * @param divisor
     *            除数
     * @return 两个参数的商
     */
    public static Double div(Number dividend, Number divisor) {
        if (dividend==null) dividend = 0;
        if (divisor==null) divisor = 0;
        BigDecimal dividendBig = new BigDecimal(Double.toString(dividend.doubleValue()));
        BigDecimal divisorBig = new BigDecimal(Double.toString(divisor.doubleValue()));

        return div(dividendBig, divisorBig, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param dividend
     *            被除数
     * @param divisor
     *            除数
     * @param scale
     *            表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static Double div(Number dividend, Number divisor, Integer scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }

        if (dividend==null) dividend = 0;
        if (divisor==null) divisor = 0;

        BigDecimal dividendBig = new BigDecimal(Double.toString(dividend.doubleValue()));
        BigDecimal divisorBig = new BigDecimal(Double.toString(divisor.doubleValue()));
        return dividendBig.divide(divisorBig, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param value
     *            需要四舍五入的数字
     * @param scale
     *            小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static Double round(Double value, Integer scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(value));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 获取百分比
     * @param num
     * @param total 总数，不能为0
     * @return
     */
    public static double ratio(Number num,Number total) {
        if (num==null||total==null||total.intValue()==0) {
            return 0;
        }
        BigDecimal b1 = new BigDecimal(num.toString());
        BigDecimal b2 = new BigDecimal(total.toString());
        BigDecimal b3 = new BigDecimal(100);
        double d=b1.divide(b2,4, BigDecimal.ROUND_HALF_UP).multiply(b3).doubleValue();
        return d;
    }

    /**
     * 金额，元转换为分
     * 四舍五入
     *
     * @param amount
     * @return
     */
    public static long amount2Cent(Number amount) {
        if (amount==null) return 0;
        return Math.round(mul(amount, 100));
    }

    public static double amount2Yuan(Long amount,   int scale) {
        if (amount==null) return 0;
        BigDecimal b1 = new BigDecimal(amount);
        BigDecimal b2 = new BigDecimal(100);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double amount2Yuan(Long amount) {
        return amount2Yuan(amount,DEF_DIV_SCALE);
    }

    /**
     * 获取绝对值
     * @param amount
     * @return
     */
    public static double abs(Double amount) {
        if (amount==null) return 0;
        return  (amount < 0) ? -amount : amount;
    }

}

