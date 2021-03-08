package jichu;

/**
 * Class类创建方式有哪些
 */
public class ReflectionTest02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);

        //方式一：调用对象的getClass()方法：通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二:使用Class类中forName静态方法：forName获得
        //类的全路径，，建议使用这个方式
        Class c2 = Class.forName("jichu.Student");
        System.out.println(c2.hashCode());

        //方式三：调用某个类的class属性：通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);


    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student(){
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher(){
        this.name = "老师";
    }
}

//获取Class类的实例
//        Class c1 = person.getClass();
//        Class c2 = Class.forName("jichu.Student");
//        Class c3 = Student.class;

