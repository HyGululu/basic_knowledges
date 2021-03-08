package duoxiancheng;

/*
    Java多线程的使用有三种方法：
    继承Thread类、
    实现Runnable接口
    使用Callable和Future创建线程
     */

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用JUC包中的Lock接口提供的tryLock方法
 * 使用tryLock 来避免死锁
 */
public class TryLockDeadlock implements Runnable {
    /*
    线程1 如果拿到了锁1 , 那么就在指定的800毫秒内去尝试拿到锁2,
    如果两把锁都拿到了 , 那么就释放这两把锁.
    如果在指定的时间内, 没有拿到锁2 , 那么就释放锁1

    线程2 与线程1相反, 先去尝试拿到锁2, 如果拿到了, 就去在3s内尝试拿到锁1,
    如果拿到了, 那么就释放锁1和2,
    如果3s内没有拿到锁1, 那么释放锁2
     */

    int flag = 1;

    //为可重入锁
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (flag == 1) {
                //先获取锁1  再获取锁2
                try {
                    //给锁1 800毫秒来获取锁, 如果拿到锁, 返回true, 反之返回false
                    if (lock1.tryLock(800, TimeUnit.MICROSECONDS)) {
                        System.out.println("线程1 获取到了锁1");
                        //随机休眠
                        Thread.sleep(new Random().nextInt(1000));
                        if (lock2.tryLock(800, TimeUnit.MICROSECONDS)) {
                            System.out.println("线程1 获取到了锁2");
                            System.out.println("线程1 成功获取了两把锁");
                            //释放两把锁，退出循环
                            lock2.unlock();
                            lock1.unlock();
                            break;
                        } else {
                            System.out.println("线程1 尝试获取锁2 失败，已经重试");
                            //释放锁1
                            lock1.unlock();

                            //随机休眠
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println("线程1 尝试获取锁1 失败，已经重试");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (flag == 0) {
                try {
                    //先获取锁2  再获取锁1. 并且尝试获取锁的时间变长 ,改成3s
                    if (lock2.tryLock(3000, TimeUnit.MICROSECONDS)) {
                        System.out.println("线程2 获取到了锁2");
                        //随机的休眠
                        Thread.sleep(new Random().nextInt(1000));
                        if (lock1.tryLock(3000, TimeUnit.MICROSECONDS)) {
                            System.out.println("线程2 获取到了锁1");
                            System.out.println("线程2 成功获取了两把锁");
                            //释放两把锁，退出循环
                            lock2.unlock();
                            lock1.unlock();
                            break;
                        } else {
                            System.out.println("线程2 尝试获取锁1 失败，已经重试");
                            //释放锁2
                            lock2.unlock();

                            //随机休眠
                            Thread.sleep(new Random().nextInt(1000));

                        }
                    } else {
                        System.out.println("线程2 尝试获取锁2 失败，已经重试");

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void main(String[] args) {
        //创建两个线程 给出不同的flag 并启动
        TryLockDeadlock r1 = new TryLockDeadlock();
        TryLockDeadlock r2 = new TryLockDeadlock();

        r1.flag = 1;
        r2.flag = 0;
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
