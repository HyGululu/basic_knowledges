package duoxiancheng;

public class DeadLockDemo3 {
    /*
    Java多线程的使用有三种方法：
    继承Thread类、
    实现Runnable接口
    使用Callable和Future创建线程
     */

    /**
     * 多线程死锁解决方式，注释部分，
     * 不要在同一代码块中，同时持有多个对象锁。
     * 我们只要把synchronized 代码块中的第二个锁往外移一下就可以了
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
                    /*synchronized (lock2) {
                        System.out.println("Thread1 get lock2");
                    }*/

                }
                synchronized (lock2) {
                    System.out.println("Thread1 get lock2");
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
                    /*synchronized (lock1) {
                        System.out.println("Thread2 get lock1");
                    }*/

                }
                synchronized (lock1) {
                    System.out.println("Thread2 get lock1");
                }
                System.out.println("Thread2 end ");
            }
        }.start();
    }

}
