package jichu.Thread;


/**
 * 模拟网路延时:放大问题的发生性
 */
public class ThreadSleep implements Runnable{
    //票数
    private int ticketNums = 10;


    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //没拿到一张票就减一
            System.out.println(Thread.currentThread().getName() + "拿到了第：" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        ThreadSleep threadSleep = new ThreadSleep();

        new Thread(threadSleep, "小明").start();
        new Thread(threadSleep, "老师").start();
        new Thread(threadSleep, "黄牛党").start();
    }
}
