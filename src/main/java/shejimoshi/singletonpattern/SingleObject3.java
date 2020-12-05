package shejimoshi.singletonpattern;

/*
完美写法
懒加载-静态内部类
JVM保证单例，加载class时候只加载一次
加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class SingleObject3 {

    //让构造函数为 private，这样该类就不会被实例化
    //单例模式的构造方法都是私有的, 防止其他对象new
    private SingleObject3() {
        //完成初始化等操作...
    }

    private static class SingleObject3Holder {
        private final static SingleObject3 INSTANCE = new SingleObject3();
    }


    //返回单例模式对象
    public static SingleObject3 getInstance() {
        return SingleObject3Holder.INSTANCE;
    }

    //测试类，多线程
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //100个线程，不同对象的hash码不同
            new Thread(() -> System.out.println(SingleObject3.getInstance().hashCode())).start();
        }
    }

}
