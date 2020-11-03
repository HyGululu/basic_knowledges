package jichu.Thread;

/**
 * 线程强制执行join  测试想象插队
 * 现实场景中少使用，会让线程阻塞
 */
public class ThreadJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip插队来了："+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if (i==200){
                thread.join();//vip插队
            }
            System.out.println("main线程："+i);
       }
    }
}
