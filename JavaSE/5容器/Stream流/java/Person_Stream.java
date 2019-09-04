import java.io.Serializable;
import java.util.Objects;

public class Person_Stream implements Serializable {

    private static final long serialVersionUID = 3180986054961782484L;

    private String name;

    public Person_Stream(String name) {
        this.name = name;
    }

    public Person_Stream() {
    }

    @Override
    public String toString() {
        return "Person_Stream{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person_Stream that = (Person_Stream) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


