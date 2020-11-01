package jiheya;

import java.util.concurrent.CountDownLatch;

/**
 * StringBuffer 线程安全   synchronized
 * StringBuilder 线程非安全
 */
public class testStringBuilderAndStringBuffer {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        //CountDownLatch计数器  计数器初始化
        CountDownLatch countDownLatch1 = new CountDownLatch(1000);
        CountDownLatch countDownLatch2 = new CountDownLatch(1000);

        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        stringBuilder.append(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //任务线程执行完毕，就将计数器减1
                        countDownLatch1.countDown();
                    }
                }
            }).start();
            }
        for (int j = 0; j < 10000; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        stringBuffer.append(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //任务线程执行完毕，就将计数器减1
                        countDownLatch2.countDown();
                    }
                }
            }).start();
        }
        try {
            //当计数器的值变为0时，在CountDownLatch上 await() 的线程就会被唤醒
            countDownLatch1.await();
            System.out.println(stringBuilder.length());
            countDownLatch2.await();
            System.out.println(stringBuffer.length());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
