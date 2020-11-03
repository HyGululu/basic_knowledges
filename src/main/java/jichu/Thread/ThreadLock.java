package jichu.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试Lock锁
 */
public class ThreadLock {

    public static void main(String[] args) {
        ThreadLock2 threadLock2 = new ThreadLock2();

        new Thread(threadLock2,"小明").start();
        new Thread(threadLock2,"小红").start();
        new Thread(threadLock2,"小刚").start();

    }
}

class ThreadLock2 implements Runnable {
    int ticketNums = 10;

    //定义Lock锁
    private final ReentrantLock lock = new ReentrantLock();

    public void run() {

        while (true) {
            lock.lock();//加锁
            try {
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                } else {
                    break;
                }

            } finally {
                //解锁
                lock.unlock();
            }


        }
    }
}