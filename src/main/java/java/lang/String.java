package java.lang;

/**
 * 双亲委派机制
 * 例子，定义String
 * 1、app应用程序-->Exc扩展-->Boot根(最终执行)
 *
 *
 * 错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
 *    public static void main(String[] args)
 * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
 *
 *
 */
public class String {
    @Override
    public String toString() {
        return "hello ";
    }

    public static void main(String[] args) {
        String s = new String();
        System.out.println(s.getClass().getClassLoader());
        s.toString();


        new Thread().start();
    }
}

/*
    1、类加载器，搜到类加载的请求
    2、将请求向上委托给父类加载器，一直向上委托，app-exc-boot，直到启动类（根）加载器
    3、启动类加载器检查是否能加载，就加载结束；否则，就抛出异常，通知子加载器进行加载

    class not found

    null,java调用不到，C或者C++写的
    java底层是c++，去掉了C++的指针；内存管理交给jvm
    */