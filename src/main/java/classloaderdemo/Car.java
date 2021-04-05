package classloaderdemo;

/**
 * 类加载器、双亲委派机制
 */
public class Car {

    public int age;

    public static void main(String[] args) {

        //类是模板是抽象的，对象是具体的，是抽象的实例化  new 关键词
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.age=1;
        car1.age=2;
        car1.age=3;

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        //一个模板里new的三个对象，获取class对象
        Class<? extends Car> aClass1 = car1.getClass();
        Class<? extends Car> aClass2 = car2.getClass();
        Class<? extends Car> aClass3 = car3.getClass();

        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());

        //获取classLoader
        ClassLoader classLoader = aClass1.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader
        System.out.println(classLoader.getParent());//sun.misc.Launcher$ExtClassLoader  /jre/lib/ext
        System.out.println(classLoader.getParent().getParent());//null  不存在，获取是java程序获取不到，rt.jar


        /**
         * classloader等级
         1、虚拟机自带的加载器
         2、启动类（根）加载器
         3、扩展类加载器
         4、应用程序加载器

         null,java调用不到，C或者C++写的
         java底层是c++，去掉了C++的指针；内存管理交给jvm

         */


    }
}
