package jichu.Thread;


/**
 * 多个线程同时操作同一个对象
 * 买火车票
 */

//发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱

/**
 * 小明拿到了第：10张票
 * 黄牛党拿到了第：9张票
 * 老师拿到了第：9张票
 * 黄牛党拿到了第：8张票
 * 小明拿到了第：6张票
 * 老师拿到了第：7张票
 * 小明拿到了第：5张票
 * 黄牛党拿到了第：5张票
 * 老师拿到了第：5张票
 */
public class ThreadTest05 implements Runnable {
    //票数
    private int ticketNums = 10;


    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //没拿到一张票就减一
            System.out.println(Thread.currentThread().getName() + "拿到了第：" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        ThreadTest05 threadTest05 = new ThreadTest05();

        new Thread(threadTest05, "小明").start();
        new Thread(threadTest05, "老师").start();
        new Thread(threadTest05, "黄牛党").start();
    }
}
