public class TestLoop {
    public static void main(String[] args) {
//        int j = 0;
//        for (int i = 1; i <= 10; i++) {
//            // 第四次循环后打断循环
//            if (i == 4) {
//                break;
//            }
//            j++;
//        }
//        System.out.println("总共循环了："+ j + "次");

        int j = 0;
        int t = 0;
        for (int i = 1; i <= 10; i++) {
            // 第四次循环后打断循环
            if (i == 4) {
                t = i;
                continue;
            }
            j++;
        }
        System.out.println("总共循环了：" + j + "次，跳出了" + t + "次");
    }
}
