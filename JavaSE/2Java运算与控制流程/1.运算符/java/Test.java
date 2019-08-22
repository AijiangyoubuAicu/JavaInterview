public class Test {
    public static void main(String[] args) {
//        int num = 10;
//        System.out.println(num);    // 10
//        ++ num;
//        System.out.println(num);    // 11
//        num ++;
//        System.out.println(num);    // 12
//
//        int num2 = 20;
//        System.out.println(++num2); // 21
//        System.out.println(num2);   // 21
//
//
//        int num3 = 30;
//        System.out.println(num3++); // 30
//        System.out.println(num3);   // 31
//
//        int num4 = 40;
//        int result = num4 --;
//        System.out.println(result); // 40
//        System.out.println(num4);   // 39
//
//        int x = 10;
//        int y = 20;
//        // 此刻 x = 11，y = 20
//        int result2 = ++x + y--;
//        System.out.println(result2);// 31
//        System.out.println(x);      // 11
//        System.out.println(y);      // 19

//        int a = 10;
//        System.out.println(3 > 4 && ++a < 10);  // false
//        System.out.println(a);  // 10
//
//        int b = 20;
//        System.out.println(3 < 4 && ++b < 100); // true
//        System.out.println(b);  // 21

        int a = 10;
        int b = 20;

        int max = a > b ? a : b;
        System.out.println(max);    // 10

        // 错误写法
        // int result = 3 > 4 ? 2.5 : 10;
        // 应进行类型转换
        int result = 3 < 4 ? (int) 2.5 : 10;
        System.out.println(result); // 2

    }
}
