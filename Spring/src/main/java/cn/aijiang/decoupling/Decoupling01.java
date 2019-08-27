package cn.aijiang.decoupling;

/**
 * 一个老师的接口，拥有教书的功能
 */
interface Teacher {

    String teach();

}

/**
 * 实现了老师的接口的实现类并重写教书的方法
 */
class ComputerTeacher implements Teacher {

    @Override
    public String teach() {
        return "老师在教Java语言！";
    }
}

/**
 * 一个学生类
 */
class Student {
    // 依赖于老师接口
    private Teacher t;
    // 注入接口
    public Student(Teacher t) {
        this.t = t;
    }

    public void Listening() {
        System.out.println("学生们正在听" + t.teach());
    }

}

public class Decoupling01 {
    public static void main(String[] args) {
        /**
         * 通过接口类型实例化接口实现类
         * 这样，我们就可以不特指任何一名老师
         */
        Teacher t = new ComputerTeacher();
        Student stu = new Student(t);
        stu.Listening();    // 学生们正在听老师正在教Java语言
    }
}