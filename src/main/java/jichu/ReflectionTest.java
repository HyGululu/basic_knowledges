package jichu;

/**
 * 反射
 */
public class ReflectionTest extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("jichu.User");
        System.out.println(c1);


        Class c2 = Class.forName("jichu.User");
        Class c3 = Class.forName("jichu.User");
        Class c4 = Class.forName("jichu.User");
        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都会被封装到Class对象中
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());

    }

}

//实体类 pojo/entity
class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

//Java反射机制
//静态VS动态语言，
//动态语言eg，Object-C；C#，JavaScript；PHP，Python
//静态语言eg，Java；C；C++；Java不是动态语言，但是称为"准动态语言"，反射机制

//Class c = Class.forName("java.lang.String")

//正常方式：引入需要的"包类"名称-->通过new实例化-->获取实例化对象
//反射方式：实例化对象-->getClass()方法-->得到完整的"包类"名称

//java代码在计算机中经历的三个阶段
//source源码阶段----类加载器ClassLoader---->Class类对象阶段--->Runtime运行时阶段

//优点：实现动态创建对象和编译；缺点：影响性能，告诉JVM，操作慢

//反射相关主要API
//java.lang.Class  代表一个类
//java.lang.reflect.Method  代表类的方法
//java.lang.reflect.Field  代表类的成员变量
//java.lang.reflect.Constructor  代表类的构造器

/**
 *Class
 * Class本身是个类
 * Class对象只能由系统创建对象
 * 一个加载的类在JVM中只会有一个Class实例
 * 一个Class对象对应的是一个加载到JVM中的一个.class文件
 * */