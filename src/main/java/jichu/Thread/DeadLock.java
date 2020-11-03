package jichu.Thread;

/**
 * 死锁：多个线程互相抱着对方需要的资源，然后形成僵持
 *
 * 产生死锁的四个必要条件：
 * 互斥条件：一个资源每次都只能被一个进程使用
 * 请求和保持条件：一个进程因请求资源而阻塞时，已经获得的资源保持不放
 * 不剥夺条件：进程已经获得资源，在未使用完之前，不能强行剥夺
 * 循环等待条件：若干个进程之前形成一种头尾相连的循环等待资源的关系
 *
 *
 * 只有想办法破坏其中任意一个或者多个条件，就能避免死锁发生
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑娘");
        Makeup g2 = new Makeup(2, "睡美人");

        g1.start();
        g2.start();
    }
}


//口红
class Lipstick {

}

//镜子
class Mirror {

}

//化妆
class Makeup extends Thread {
    //需要的资源只有一份，用static来保证一份
    static Lipstick lipStick = new Lipstick();

    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人

    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;

    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //锁，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            /*synchronized (lipStick) {//说的口红的锁
                System.out.println(this.girlName + " 获得口红的锁");
                Thread.sleep(1000);

                这样会死锁
                synchronized (mirror) {//一秒钟后获得镜子
                    System.out.println(this.girlName + " 获得镜子的锁");

                }
            }*/
            synchronized (lipStick) {//说的口红的锁
                System.out.println(this.girlName + " 获得口红的锁");
                Thread.sleep(1000);

            }
            //这样不会死锁
            synchronized (mirror) {//一秒钟后获得镜子
                System.out.println(this.girlName + " 获得镜子的锁");

            }
        } else {
            synchronized (mirror) {//说的镜子的锁
                System.out.println(this.girlName + " 获得镜子的锁");
                Thread.sleep(1000);

                /*放到里面会死锁，两个人同时抱一把锁，会死锁
                synchronized (lipStick) {//一秒钟后获得口红
                    System.out.println(this.girlName + " 获得口红的锁");

                }*/
            }
            //放到外面不会死锁
            synchronized (lipStick) {//一秒钟后获得口红
                System.out.println(this.girlName + " 获得口红的锁");

            }
        }
    }
}