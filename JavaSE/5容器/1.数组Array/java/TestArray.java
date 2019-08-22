import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        int[] intArray = {10, 20, 30};
        String intStr = Arrays.toString(intArray);
        System.out.println(intStr);     // [10, 20, 30]

        int[] array1 = {2, 1, 3, 10, 6};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));    // [1, 2, 3, 6, 10]

        String[] array2 = {"bbb", "aaa", "AAA", "ccc"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));    // [AAA, aaa, bbb, ccc]
    }
}
