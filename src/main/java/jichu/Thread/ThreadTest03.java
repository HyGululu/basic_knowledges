package jichu.Thread;

/**
 * 创建线程方式2：实现Runnable接口，重现run方法，执行线程需要丢入Runnable接口实现类，调用start方法
 */
public class ThreadTest03 implements Runnable{
    //线程入口点
    public void run(){
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("看代码： "+i);
        }

    }

    public static void main(String[] args) {
        //main主线程

       //创建Runnable接口的实现类对象
        ThreadTest03 threadTest03 = new ThreadTest03();
         /*//创建线程对象，通过线程对象来开启线程，代理
        Thread thread = new Thread(threadTest03);
        thread.start();*/

        new Thread(threadTest03).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("学习多线程： "+i);
        }
    }
}
