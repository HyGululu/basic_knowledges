package mapmapmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 开多个线程不断进行put操作，HashMap与AtomicInteger都是全局共享的
 *
1、hashmap不是线程安全的
2、如何线程安全的使用HashMap

 三种线程安全使用方式
 Hashtable（使用synchronized）
 ConcurrentHashMap（Java8中使用CAS算法比较并替换）
 synchronized Map

 */
public class HashMapTest {
    public static void main(String[] args) {
        //开多个线程
        HashMapThread thread0 = new HashMapThread();
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        /*
        2、线程安全的使用HashMap
         */
        //1、Hashtable
        //HashTable使用synchronized来保证线程安全的，所有线程竞争同一把锁，效率低
        Map<String, String> hashtable = new Hashtable<>();
        //2、ConcurrentHashMap
        //使用锁分段技术：它包含一个segment数组，将数据分段存储，给每一段数据配一把锁，效率高
        //Java8中使用CAS算法 compareAndSwap
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        //3、synchronized Map
        //调用synchronizedMap()方法后会返回一个SynchronizedMap类的对象,
        // 而在SynchronizedMap类中使用了synchronized同步关键字来保证对Map的操作是安全的。
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<String, String>());
    }

}

class HashMapThread extends Thread {
    //HashMap与AtomicInteger都是全局共享的
    //原子类AtomicInteger();
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void run() {
        while (ai.get() < 100000000) {
            //不断进行put操作
            map.put(ai.get(), ai.get());
            //incrementAndGet返回的是加1后的值
            ai.incrementAndGet();
        }
    }
}