package jichu;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 */
public class ReflectionTest11 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("jichu.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for(Annotation annotation :annotations){
            System.out.println(annotation);
        }

        //获得注解的value值
        Tablebiao tablebiao = (Tablebiao)c1.getAnnotation(Tablebiao.class);
        String value = tablebiao.value();
        System.out.println(value);

        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        Filedbiao annotation = f.getAnnotation(Filedbiao.class);
        System.out.println(annotation.columName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

    }


}

@Tablebiao("db_student")
class Student2{

    @Filedbiao(columName = "db_id",type = "int",length = 10)
    private int id;
    @Filedbiao(columName = "db_age",type = "int",length = 10)
    private int age;
    @Filedbiao(columName = "db_name",type = "int",length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablebiao{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Filedbiao{
    String columName();
    String type();
    int length();
}

/**
 * ORM
 * 对象关系映射  Object relationship Mapping
 * 类和表结构对应
 * 属性和字段对应
 * 对象和记录对应
 * 利用注解和反射完成类和表结构的映射关系
 */
