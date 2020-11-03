package jichu.Thread;


/**
 * 创建线程方式一：继承Thread类，重现run方法，调用start开启线程
 *
 * 总结：线程开启不一定执行，由cup调度执行
 */
public class ThreadTest01 extends Thread{
    //线程入口点
    @Override
    public void run(){
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("看代码： "+i);
        }

    }

    public static void main(String[] args) {
        //main主线程

        //创建一个线程对象
        ThreadTest01 threadTest01 = new ThreadTest01();
        //调用start（）方法开启线程
        //threadTest01.start();
        threadTest01.run();

        for (int i = 0; i < 1000; i++) {
            System.out.println("学习多线程： "+i);
        }
    }
}
/**
 **调用run（）：只有主线程一条执行路径
 * 调用start（）：多条执行路径，主线程和子线程并行交替执行
 */