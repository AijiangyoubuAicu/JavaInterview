enum ClothesMeasurement {
    // 使每个衣服的码数对应最合适身高
    S(162), M(165),
    L(168), XL(171),
    XXL(173), XXXL(176);

    // 定义一个枚举的成员变量
    private int heightPerson;

    // 定义一个构造器
    ClothesMeasurement(int heightPerson) {
        this.heightPerson = heightPerson;
    }

    // 定义一个空参函数，对于没有相对应合适的身高的尺寸衣服适合，将回返回一个-1值表示该值还不存在
    ClothesMeasurement() {
        heightPerson = -1;
    }

    // 定义一个访问器
    public int getHeightPerson() {
        return heightPerson;
    }
}

public class TestEnum {
    public static void main(String[] args) {
        // 调用枚举的构造方法和访问器
        int i = ClothesMeasurement.valueOf("S").getHeightPerson();
        System.out.println("S码衣服尺寸的合适身高为：" + i);

        System.out.println("所有衣服的身高尺寸参数：");
        for (ClothesMeasurement cm : ClothesMeasurement.values()) {
            System.out.println("衣服的尺寸：" + cm + " 对应的身高为：" + cm.getHeightPerson());
        }
    }
}