package jichu.Thread.syn;


/**
 * 不安全的买票
 *
 * 会出现-1
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "苦逼的我").start();
        new Thread(buyTicket, "牛逼的你").start();
        new Thread(buyTicket, "可恶的黄牛党").start();
    }

}

class BuyTicket implements Runnable {
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

    private void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        //模拟延时
        Thread.sleep(500);
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到了" + ticketNums--);
    }
}
