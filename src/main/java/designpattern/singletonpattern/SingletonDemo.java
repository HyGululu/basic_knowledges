package designpattern.singletonpattern;

public class SingletonDemo {
    private static final SingletonDemo instance = new SingletonDemo();

    //私有化构造方法
    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        return instance;
    }


}




