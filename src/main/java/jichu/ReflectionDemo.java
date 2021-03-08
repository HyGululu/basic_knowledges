package jichu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 1、正向使用一个类的方法
 * 2、反向反射方式使用一个类的方法
 *
 *
    JDBC的使用，如创建一个链接
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //正向
        ArrayList list = new ArrayList(); //实例化
        list.add("reflection");  //执行方法
        System.out.println("正向使用一个类的方法："+list.get(0));

        //反向
        Class<?> clz = Class.forName("java.util.ArrayList");
        Method method_add = clz.getMethod("add", Object.class);
        Constructor constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        method_add.invoke(object, "reflection");

        Method method_get = clz.getMethod("get", int.class);
        System.out.println("反向反射方式使用一个类的方法"+method_get.invoke(object, 0));



    }

    //JDBC的使用，如创建一个链接
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        //初始化驱动类
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://url\",\"root\", \"admin");
        return conn;
    }
    /*
    程序员a提供接口：Oracle公司提供了JDBC标准（接口）
    程序员b提供实现：各个数据库厂商提供针对自家数据库的实现
    程序员c写客户端：java coder在Java中写代码访问数据库

    反射作用：
    动态代理，不改变目标对象方法的情况下对方法进行增强，比如使用AOP拦截某些方法打印日志？
    注解，获取注解并执行对于行为？
     */

   /*
   java.lang.reflect类库提供反射支持
    Field：使用get和set方法读取和修改对象的属性
    Method：使用invoke（）方法调用对象中的方法
    Constructor：用newInstance（）创建新的对象
    */
}
