package shejimoshi;

import java.lang.reflect.Constructor;

public class LazyMan {
    //SingletonPatternTest01懒汉式单例模式
    //构造器私有
    private LazyMan() {
        System.out.println(Thread.currentThread().getName() + "ok");

    }

    //双重检测锁+原子性操作 volatile
    private volatile static LazyMan lazyMan;

    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                //加锁+双重检测的懒汉模式 简称DCL懒汉式
                if (lazyMan == null) {
                    //lazyMan = new LazyMan();不是原子性操作，需要三步：1、分配内存空间；2、执行构造方法，初始化对象；3、把对象指向这个空间
                    //可能指令重拍，本来预期123，但是可能是132
                    //避免指令重拍，加上volatile
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }


    public static void main(String[] args) throws NoSuchMethodException {
/*        //单线程下ok
        //多线程-并发下不ok，开10个线程
        //多线程并发，后面需要加锁和双重检测
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazyMan.getInstance();
            }).start();
        }*/
        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);

    }
}
