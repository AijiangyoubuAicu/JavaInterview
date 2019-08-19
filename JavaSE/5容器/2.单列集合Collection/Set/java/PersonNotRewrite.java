import java.io.Serializable;

/**
 * 一个POJO类
 * 没有重写hashCoe()和equals()方法
 */
public class PersonNotRewrite implements Serializable {

    private static final long serialVersionUID = 5213680465162282272L;

    private String name;    // 姓名
    private Integer age;    // 年龄

    public PersonNotRewrite() {
    }

    public PersonNotRewrite(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonNotRewrite{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
