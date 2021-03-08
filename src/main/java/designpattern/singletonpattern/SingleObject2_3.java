package designpattern.singletonpattern;

/*

懒汉式-双重判断

 */
public class SingleObject2_3 {
    //volatile,线程可见性  防止指令重排，没有初始化，就返回？ jit优化
    private static  volatile SingleObject2_3 instance;
    private SingleObject2_3(){
    }
    public static SingleObject2_3 getInstance() {
        if (instance == null) {
                synchronized (SingleObject2_2.class) {
                    //双重判断
                    if (instance == null) {
                    //每次睡10ms
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //如果不是空, 则直接返回实例.
                    instance = new SingleObject2_3();
                }
            }
        }
        return instance;
    }

    //测试类，多线程
    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            //100个线程，不同对象的hash码不同
            new Thread(()-> System.out.println(SingleObject2_3.getInstance().hashCode())).start();
        }
    }

}
