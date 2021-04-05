package classloaderdemo;

/**
 * 双亲委派机制
 *
 * boot-->exe-->app
 */
public class Student {
    @Override
    public String toString() {
        return "hello ";
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getClass().getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(student.toString());
    }
}
