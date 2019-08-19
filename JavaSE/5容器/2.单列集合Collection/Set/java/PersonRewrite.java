import java.io.Serializable;
import java.util.Objects;

/**
 * 一个普通的POJO类
 * 重写了hashCode()方法和equals()方法
 */
public class PersonRewrite implements Serializable {

    private static final long serialVersionUID = -8359862483093627493L;

    private String name;    // 姓名
    private Integer age;    // 年龄

    public PersonRewrite() {
    }

    public PersonRewrite(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonRewrite{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonRewrite that = (PersonRewrite) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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
