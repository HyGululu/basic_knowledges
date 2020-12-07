package yuanzidemo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMyTest {
    private static final int THREADS_COUNT = 20;
    public static int count =0;

    public static void increase(){
        count++;

    }

    public static void main(String[] args) {
        //20个线程
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        //每个线程对count变量进行1000次自增操作
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(count);
    }
}
