/**
 * 强制类型转换
 *
 * 1. 特点：代码需要进行特殊的格式处理，不能自动完成。
 * 2. 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
 */
public class Demo02_BasicDataType {

    public static void main(String[] args) {
//        show01();
        show02();
    }

    /**
     * 强制类型转换一
     */
    private static void show01() {
        /**
         * 左右类型不一样，long 的类型范围大于 ing
         * 需要强制转换
         */
        int num = (int)100L;
        System.out.println(num);
    }

    /**
     * 精度丢失情况一
     *
     * 长数值丢失，数据溢出
     */
    private static void show02() {
        int num2 = (int) 6000000000L;
        System.out.println(num2);   // 1705032704
    }

    /**
     * 精度丢失情况二
     *
     * 浮点数转换为整数，丢失小数
     */
    private static void show03() {
        int num3 = (int) 3.99;
        System.out.println(num3);
    }

    /**
     * 强制类型转换二
     *
     * short、byte、char之间的变量计算需要转换
     */
    private static void show04() {
        byte b1 = 30;
        byte b2 = 40;
        // 需要加上(byte)，否则编译不通过，可尝试去掉看报错
        byte b3 = (byte) (b1 + b2);
        System.out.println(b3);

        short s1 = 4;
        short s2 = 6;
        // 同理如上
        short s3 = (short) (s1 + s2);
        System.out.println(s3);

        char c1 = 30;
        char c2 = 12;
        // 同理如上
        char c3 = (char) (c1 + c2);
        System.out.println(c3);
    }


}
