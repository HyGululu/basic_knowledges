package duoxiancheng;

public class DeadLockDemo {
    /*
    Java多线程的使用有三种方法：
    继承Thread类、
    实现Runnable接口
    使用Callable和Future创建线程
     */

    /**
     * 多线程死锁例子
     */
    //创建两个锁对象
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread1 get lock1");
                    try {
                        //线程休眠，使cpu得到切换
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("Thread1 get lock2");
                    }

                }
                System.out.println("Thread1 end ");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("Thread2 get lock2");
                    try {
                        //线程休眠，使cpu得到切换
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("Thread2 get lock1");
                    }

                }
                System.out.println("Thread2 end ");
            }
        }.start();
    }

}
