package jichu.Thread;

/**
 * 守护线程
 * 线程分为两种：用户线程vs守护线程
 * 虚拟机必须保证用户线程执行完毕，如main线程
 * 虚拟机不必等待守护线程执行完毕，如gc线程不用等，如下面的上帝作为守护线程，等虚拟机停止，守护线程也停止
 * 作用：后台记录操作日志；监控内存；垃圾回收等
 * <p>
 * 人生不过三万天
 * <p>
 * 测试守护线程
 * 上帝守护你
 */
public class ThreadDaemon {
    public static void main(String[] args) {
        God god = new God();
        You1 you1 = new You1();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认是false，表示是用户线程，正常的线程都是用户线程……

        thread.start();//上帝守护线程启动

        new Thread(you1).start();//你 用户线程启动……

    }
}


//上帝，守护线程
class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝浪味仙啊");
        }

    }
}


//你,用户线程
class You1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的或者");
        }
        System.out.println("=======goodbye world！==========");
    }
}
