package shejimoshi.singletonpattern;

public class SingletonThread  {
    public static void main(String[] args) {
//        LazySingleton lazySingleton = LazySingleton.getInstance();
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("=========");
    }
}

class T implements Runnable {
    @Override
    public void run() {
        SingleObject2 obj = SingleObject2.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + obj);
    }
}

