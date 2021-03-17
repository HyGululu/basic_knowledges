package collections;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * map不安全
 */
public class MapUnSafeTest {
    public static void main(String[] args) {

        //HashMap<String, String> map = new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        //Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());

        for (int i = 0; i <=30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();

            /*
            上面使用lambda表达式new的线程
            下面是之前的方式，有个匿名内部类
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                    System.out.println(map);
                }
            },String.valueOf(i)).start();*/

        }
    }

}
;