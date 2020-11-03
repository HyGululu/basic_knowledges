package jichu;

public class ReflectionTest04 {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);

        /**
         * 1、加载到内存，会产生一个类对应的Class对象
         * 2、链接，链接结束后m=0
         * 3、初始化
         *  <clinit>()
                {
                    System.out.println("A类静态代码块初始化");
                    m = 300;
                    m = 100;
                    }

            m = 100
         */
    }
}

class A{
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }
    static int m = 100;

    public A(){
        System.out.println("A类的无参构造初始化");
    }
}


/**
 *Java内存：堆；栈；方法区
 * 堆：存放new的对象和数组
 *    可以被所有线程共享，不会存放别的对象的引用
 * 栈：存放基本变量类型（会包含这个基本类型的具体数值）
 *    引用对象的变量（会存放这个引用在堆里面的具体地址）
 * 方法区：可以被所有线程共享
 *      包含了所有的class和static变量;jdk1.7永生代  jdk1.8元数据
 * */

/**
 * 类的加载过程
 * 加载：将class文件字节码内容加载到内存中
 * 链接：将Java类的二进制代码合并到JVM的运行中状态的过程
 * 初始化
 */