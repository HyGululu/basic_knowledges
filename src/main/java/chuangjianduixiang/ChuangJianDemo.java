package chuangjianduixiang;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
Java创建对象有5种方式
用new语句创建对象。
使用反射，使用Class.newInstance()创建对象/调用类对象的构造方法——Constructor
调用对象的clone()方法。
运用反序列化手段，调用java.io.ObjectInputStream对象的readObject()方法.
使用Unsafe

使用new关键字	} → 调用了构造函数
使用Class类的newInstance方法	} → 调用了构造函数
使用Constructor类的newInstance方法	} → 调用了构造函数
使用clone方法	} → 没有调用构造函数
使用反序列化	} → 没有调用构造函数
 */
public class ChuangJianDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
     //1
        Son son = new Son();
        System.out.println("================");
        //2
        Son son1 = (Son)Class.forName("chuangjianduixiang.Son").newInstance();
        Son son2 = Son.class.newInstance();
        System.out.println("================");
        //3
        Constructor<Son> constructor = Son.class.getConstructor();
        Son son3 = constructor.newInstance();
        System.out.println("================");
        //4
        //Son son4 = son2.clone();
        //5
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("chuangjianduixiang.Son"));
        Son son5 =(Son)in.readObject();


    }
}
