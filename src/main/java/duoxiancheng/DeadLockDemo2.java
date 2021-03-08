package duoxiancheng;

/*
    Java多线程的使用有三种方法：
    继承Thread类、
    实现Runnable接口
    使用Callable和Future创建线程
     */

/**
 * 多线程死锁例子
 */
public class DeadLockDemo2 implements Runnable {

    //创建两个锁对象
    private Object lock1 = new Object();
    private Object lock2 = new Object();


    @Override
    public void run() {
        while (true) {
            method1();
            method2();
        }
    }

    public void method1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "获取到lock1");
            try {
                //线程休眠，使cpu得到切换
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "获取到lock2");
            }

        }
        System.out.println(Thread.currentThread().getName() + "end ");
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + "获取到lock2");
            try {
                //线程休眠，使cpu得到切换
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "获取到lock1");
            }

        }
        System.out.println(Thread.currentThread().getName() + "end ");
    }

    public static void main(String[] args) {
        DeadLockDemo2 deadLockDemo2 = new DeadLockDemo2();
        new Thread(deadLockDemo2).start();
        System.out.println("=================");
        new Thread(deadLockDemo2).start();
    }
}
