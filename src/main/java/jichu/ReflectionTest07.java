package jichu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获得类的信息
 */
public class ReflectionTest07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("jichu.User");

        //User user = new User();
        //c1 = user.getClass();

        //获得类的名字
        System.out.println(c1.getName());  //获得包名+类名
        System.out.println(c1.getSimpleName());  //获得类名

        //获得类的属性
        System.out.println("===============");
        Field[] fields =c1.getFields();  //只能找到public属性
        //for (Field field:fields){  打印不出来
        //    System.out.println(field);
        //}

        fields =c1.getDeclaredFields();//找到全部的属性
        for (Field field:fields){
            System.out.println(field);
        }

        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("============");
        Method[] methods = c1.getMethods();//获得本类和其父类的全部public方法
        for(Method method : methods){
            System.out.println("正常的："+method);//获得本类的所有方法
        }
        methods = c1.getDeclaredMethods();
        for(Method method : methods){
            System.out.println("getDeclaredMethods："+method);
        }

        //获得指定方法
        //重载
        Method getName = c1.getMethod("getName",null);
        Method setName = c1.getMethod("setName",String.class);
        System.out.println(getName);
        System.out.println(setName);

        //获得指定的构造器
        System.out.println("=============");
        Constructor[] constructors = c1.getConstructors();//获得public
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }

        constructors = c1.getDeclaredConstructors();  //获得本类的
        for(Constructor constructor : constructors){
            System.out.println("getDeclaredConstructors "+constructor);
        }

        //获得指定的构造器
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定构造器："+constructor);
    }
}


