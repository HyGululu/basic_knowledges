package duoxiancheng;

/**
 * synchronized关键字
 * 分为两类：
 * 对象锁：方法锁；同步代码块
 * 类锁
 */
/*
这里就是同步代码块
 */
public class MySyn implements Runnable {
    static int a = 0;
    Object object =new Object();


    @Override
    public void run() {
        //同步代码块,使用了synchronized锁住了run方法中的代码块
        synchronized (object){
            for (int i = 0; i < 1000; i++) {
                a++;

            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MySyn syn = new MySyn();
        Thread t1 = new Thread(syn);
        Thread t2 = new Thread(syn);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(a);
    }
}
/*
thread1对a进行增加，一直到1000，
thread2再对a进行增加，一直到2000。
不过如果我们运行过之后我们就会发现，
最后的输出值总是小于2000，这是为什么呢？

在执行a++的时候其实包含了以下三个操作：
（1）线程1读取a
（2）线程1将a加1
（3）将a的值写入内存

出错原因的关键就在于第二操作和第三个操作之间，
此时线程1还没来得及把a的值写入内存，
线程2就把旧值读走了，这也就造成了a加了两次，
但是内存中的a的值只增加了1。这也就是不同步现象

 */