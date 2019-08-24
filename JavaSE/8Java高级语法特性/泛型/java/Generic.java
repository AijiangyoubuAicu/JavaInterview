import java.util.ArrayList;
import java.util.List;

class Stats<T extends Number> {
    T[] nums;

    Stats(T[] nums) {
        this.nums = nums;
    }

    double average() {
        double sum = 0.0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    //常规下的泛型设计
//	boolean sameAvg(Stats<T> ob) {
//		if(average() == ob.average()) {
//			return true;
//		}
//		return false;
//	}
    // 通配符下的泛型设计
    boolean sameAvg(Stats<?> dob) {
        if(average() == dob.average()) {
            return true;
        }
        return false;
    }
}

public class Generic {

    public static void main(String[] args) {
        Integer[] inums = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<Integer>(inums);		  //3.0
        double v = iob.average();
        System.out.println(v);

        Double[] dnums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<Double>(dnums);		 //3.3
        double w = dob.average();
        System.out.println(w);

        Float[] fnums = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
        Stats<Float> fob = new Stats<Float>(fnums);			//3.0
        double x = fob.average();
        System.out.println(x);

        // iob和dob在之前已被类型转换，在此因无法再进行类型转换而编译报错
        // 有通配符下的泛型设计后，不会再影响能够创建什么类型的Stats对象
        // 这是由Stats声明的extends子句控制的，通配符只是简单地匹配所有有效的Stats对象！
        if (iob.sameAvg(dob)) {
            System.out.println("True");
        } else {
            System.out.println("False");						//False
        }

        if (iob.sameAvg(fob)) {
            System.out.println("True");
        } else {
            System.out.println("False");						//True
        }
    }
}
