package duoxiancheng;

/**
 * Java多线程：线程之间通信的四种方式
 * 1、同步
 * 指多个线程通过synchronized关键字这种方式来实现线程间的通信
 * 本质上就是“共享内存”式的通信
 * 2、while轮询?
 * 3、wait/notify机制
 * 4、管道通信?
 */
class MyObject {
    synchronized public void methodA() {
    }

    synchronized public void methodB() {
    }
}

class ThreadA extends Thread {
    private MyObject object;

    public ThreadA(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}

class ThreadB extends Thread {
    private MyObject object;

    public ThreadB(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}

public class MyRun {
    public static void main(String[] args) {
        MyObject object = new MyObject();

        //线程A与线程B 持有的是同一个对象:object
        ThreadA a = new ThreadA(object);
        ThreadB b = new ThreadB(object);
        a.start();
        b.start();
    }
}
/*
由于线程A和线程B持有同一个MyObject类的对象object，
尽管这两个线程需要调用不同的方法，
但是它们是同步执行的，
比如：线程B需要等待线程A执行完了methodA()方法之后，
它才能执行methodB()方法。
这样，线程A和线程B就实现了 通信。

这种方式，本质上就是“共享内存”式的通信。
多个线程需要访问同一个共享变量，
谁拿到了锁（获得了访问权限），
谁就可以执行。
 */