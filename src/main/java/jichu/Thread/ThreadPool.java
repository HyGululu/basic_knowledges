package jichu.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1、创建服务，创建线程池
        ExecutorService service =  Executors.newFixedThreadPool(10) ;
        //newFixedThreadPool参数为线程池大小

        //执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //2、关闭连接
        service.shutdown();
    }


}

class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
