enum Phone {
    华为, Apple, Mi, 魅族, 三星, 努比亚, 一加, OPPO, VIVO, 锤子,
}


public class Enumeration004 {

    public static void main(String[] args) {
        //可以同时定义多个枚举变量
        Phone p1,p2,p3;
        //为变量赋枚举常量
        p1 = Phone.Mi;
        p2 = Phone.三星;
        p3 = Phone.魅族;
        Phone p4 = Phone.锤子;
        Phone p5 = Phone.锤子;

        //1) ordinal()方法：检索序数值，可获取用于指示枚举常量在常量列表中位置的值，注意是从0开始数数
        int location1 = p1.ordinal();
        int location2 = p2.ordinal();
        int location3 = p3.ordinal();
        System.out.println(location1 + " " + location2 + " " + location3);	// 2 4 3

        //2) compareTo()方法比较相同类型的两个枚举常量的序数值，这是个整数值，将返回两个枚举变量的差值
        System.out.println(p1.compareTo(p4));   // -7
        System.out.println(p3.compareTo(p1));   // 1
        System.out.println(p3.compareTo(p2));   // -1

        System.out.println(p1.compareTo(Phone.Mi));     //0
        System.out.println(p3.compareTo(Phone.Apple));  //2
        System.out.println(p3.compareTo(Phone.锤子));    //-6

        //3) equal()方法比较枚举常量和其他对象的相同性
        boolean tf1 = p1.equals(Phone.Mi);
        boolean tf2 = p2.equals(p1);
        boolean tf3 = p5.equals(p4);
        System.out.println(tf1 + " " + tf2 + " " + tf3); // true false true

    }
}

