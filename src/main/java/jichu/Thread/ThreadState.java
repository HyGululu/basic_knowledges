package jichu.Thread;


/**
 * 观测测试线程的状态
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {

        //线程体
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("+++++++++++++=");
        });


        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//NEW


        //观察启动后
        thread.start();//启动线程
        state = thread.getState();
        System.out.println(state);//RUN

        //只要线程不终止，就一直输出状态
        while (state!= Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();//更新线程状态
            System.out.println(state);  //输出状态
        }

        //thread.start(); //死亡之后的线程不能再启动了
    }
}
