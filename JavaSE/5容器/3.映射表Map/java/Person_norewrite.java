import java.io.Serializable;

/**
 * 未重写的 hashCode() 和 equals() 方法的类
 */
public class Person_norewrite implements Serializable {

    private static final long serialVersionUID = -2771779762477937721L;

    private String name;
    private Integer age;

    public Person_norewrite() {
    }

    public Person_norewrite(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person_norewrite{" +
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
