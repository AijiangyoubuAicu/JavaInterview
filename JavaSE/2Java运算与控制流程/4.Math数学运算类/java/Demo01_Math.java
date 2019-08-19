/**
 * 常用方法测试
 */
public class Demo01_Math {

    public static void main(String[] args) {
        // 求绝对值
        System.out.println(Math.abs(-2.0));     // 2.0
        // 求立方根
        System.out.println(Math.sqrt(64.0));    // 8.0
        // 求两数的较大值与较小值
        System.out.println(Math.max(56, 78));   // 78
        System.out.println(Math.min(56, 78));   // 56
        // 取[0,1]的一个随机数
        System.out.println(Math.random());      // 0.1275766217502683
        // 求幕,a的b次幂,即b个a相乘, 例如2的3次幂,即3个2相乘,2^=2x2x2=8
        System.out.println(Math.pow(2, 3));     // 8.0
        // 向上取整与乡下取整
        System.out.println(Math.ceil(18.36));   // 19.0
        System.out.println(Math.floor(18.36));  // 18.0
        // 四舍五入
        System.out.println(Math.round(11.5));   // 12
        System.out.println(Math.round(-11.5));  // -11
    }
}
