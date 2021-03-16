package designpattern.singletonpattern;

/*
测试多线程调单例模式
 */
public class SingletonTest {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run(){
                SingleObject2 instance = SingleObject2.getInstance();
                int hashCode = instance.hashCode();
                System.out.println(Thread.currentThread().getName()+": "+hashCode);
            }
        };
        thread.start();
        Thread thread2 = new Thread() {
            @Override
            public void run(){
                SingleObject2 instance = SingleObject2.getInstance();
                int hashCode = instance.hashCode();
                System.out.println(Thread.currentThread().getName()+": "+hashCode);
            }
        };
        thread2.start();
    }
}
