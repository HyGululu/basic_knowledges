package jichu.Thread.syn;


/**
 * 安全取钱
 *
 */
public class SafeBank1 {
    public static void main(String[] args) {
        //账户
        Account1 account = new Account1(1000, "结婚基金");

        Drawing1 you = new Drawing1(account, 50, "你");
        Drawing1 girlFriend = new Drawing1(account, 100, "girlFriend");

        you.start();
        girlFriend.start();
    }
}


//账户
class Account1 {
    int money;//余额
    String name;//卡名

    public Account1(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行，模拟取款
class Drawing1 extends Thread {
    Account1 account;//账户
    //取了多少钱
    int drawingMoney;
    //现在手上有多少钱
    int nowMoney;

    public Drawing1(Account1 account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }


    //synchronized 默认值是this
    //取钱
    @Override
    public void run() {
        //锁account，account进行了增删改成的操作；锁的对象是变化的量，增删改，查不需要锁
        synchronized (account){

            //判断有没有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "银行账户钱不够，取不到");
                return;
            }

            //sleep放大问题的发生性
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡内余额 = 余额-你取得钱
            account.money = account.money - drawingMoney;
            //你手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为：" + account.money);
            //Thread.currentThread().getPriority() 等于  this.getName()
            System.out.println(this.getName() + "手里的钱：" + nowMoney);
        }

    }
}