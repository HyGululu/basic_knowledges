package shejimoshi.singletonpattern;

/*

懒汉式-部分加锁
线程不安全，多线程访问的时候有影响

试图加锁同时提高效率，通过减小同步代码块的方式提高效率
多线程访问下，只有一个实例不可以做到
 */
public class SingleObject2_2 {
    private static SingleObject2_2 instance;
    private SingleObject2_2(){
    }
    //返回单例模式对象
    public static SingleObject2_2 getInstance() {
        if (instance == null){
            //试图加锁同时提高效率，通过减小同步代码块的方式提高效率
            synchronized (SingleObject2_2.class){
            //每次睡10ms
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //如果不是空, 则直接返回实例.
            instance = new SingleObject2_2();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            new Thread(()-> System.out.println(SingleObject2_2.getInstance().hashCode())).start();
        }
    }

}
