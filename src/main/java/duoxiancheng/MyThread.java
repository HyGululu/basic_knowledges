package duoxiancheng;

import java.util.concurrent.Callable;

/**
 * 多线程创建方式
 * 方式一：继承Thread类创建线程类
 * 方式二：通过Runnable接口创建线程类
 * 方式三：通过Callable和Future创建线程
 */
public class MyThread {

}

class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread3 implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}