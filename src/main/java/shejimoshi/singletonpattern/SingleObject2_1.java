package shejimoshi.singletonpattern;

/*

懒汉式
线程不安全，多线程访问的时候有影响
加锁synchronized，效率降低了，能保证一个实例
 */
public class SingleObject2_1 {
    private static SingleObject2_1 instance;
    private SingleObject2_1(){
    }
    //加锁synchronized，效率降低了
    public static synchronized SingleObject2_1 getInstance() {
        ////懒汉式,  检查是否为空,如果是空, 再初始化
        if (instance == null){
            //每次睡10ms
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //如果不是空, 则直接返回实例.
            instance = new SingleObject2_1();
        }
        return instance;
    }

    //测试类，多线程不安全
    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            //100个线程，不同对象的hash码不同
            new Thread(()-> System.out.println(SingleObject2_1.getInstance().hashCode())).start();
        }
    }

}
