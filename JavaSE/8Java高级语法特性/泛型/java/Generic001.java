
/**
 *  实例化泛型类，并在实例时确定泛型的数据类型为Integer
 *
 * Integer是传递给Gen的类型参数，对T的所有引用都被转换为对Integer的引用
 *  在进行转换为Integer操作中，编译器移除所有泛型类型信息，进行必要的类型转换，犹如创建了一个新版的Gan类，但实际上只有一个版本哦！仅仅只做“擦除”之后“类型转换”两个操作
 *  移除泛型类型信息的过程被称为“擦除”
 *
 * @author uid
 *
 */
public class Generic001 {
    public static void main(String[] args) {

        /**
         * new操作之后Gen赋值也必须指定<Integer>，因为只是new返回的引用也必须是<Integer>
         *
         * @warming 此处在JDK7之后可省略了 Gen<Integer> i = new Gen<>(88);
         *   		发生了自动装箱操作，显式代码为：Gen<Integer> i = new Gen<Integer>(new Inerger(88))，但是无任何好处哦~~
         */
        Gen<Integer> i = new Gen<Integer>(/* new Integer(88) */ 88);
        //调用一般方法
        i.showType();	 //泛型T的类型是：java.lang.Integer
        //自动拆装箱机制赋值
        //方法getValue在当Gen类被自动转换为Integer类型时，那么方法的返回类型也是Integer类型，不需要将方法强制转换为Integer！这是自动装拆箱机制带来的好处之一
        int v = i.getValue();
        //你甚至可以手动拆装箱，不利用自动拆装箱特性
        //int v = i.getValue().intValue();
        System.out.println(v);					//88
        System.out.println("---------华丽的分割线1---------");

        //实例化泛型类，并在实例时确定泛型的数据类型为Double
        Gen<String> s = new Gen<String>("Decade");
        s.showType();							//泛型T的类型是：java.lang.String
        String t = s.getValue();
        System.out.println(t);					//Decade
        System.out.println("---------华丽的分割线2---------");
    }
}

// 定义一个泛型类
// <T> T是类型参数Type的名称，这个名称是实际类型的“占位符”
class Gen<T> {
    // 定义泛型变量
    T value;
    // 定义有参泛型构造函数
    Gen(T value) {
        this.value = value;
    }
    // 定义泛型访问器
    T getValue() {
        return value;
    }
    // 定义展示输出数据类型的一般方法
    void showType() {
        System.out.println("泛型T的类型是：" + value.getClass().getName());
    }
}

























