package jichu.Thread.syn;


/**
 * 安全的买票
 *
 */
public class SafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket1 buyTicket = new BuyTicket1();

        new Thread(buyTicket, "苦逼的我").start();
        new Thread(buyTicket, "牛逼的你").start();
        new Thread(buyTicket, "可恶的黄牛党").start();
    }

}

class BuyTicket1 implements Runnable {
    //票
    int ticketNums = 10;
    boolean flag = true;//外部停止方式

    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized 同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        //模拟延时
        //Shread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到了" + ticketNums--);
    }
}
