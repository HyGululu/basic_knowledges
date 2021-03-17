package collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * set不安全
 */
public class SetUnSafeTest {
    public static void main(String[] args) {

       // Set<String> set = new HashSet<String>();
        //Set<String> set  = Collections.synchronizedSet(new HashSet<String>());
        Set<String> set = new CopyOnWriteArraySet<>(new HashSet<String>());

        for (int i = 0; i <3000 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();

        }
    }
}
