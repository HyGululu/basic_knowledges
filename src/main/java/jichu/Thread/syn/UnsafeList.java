package jichu.Thread.syn;


import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全的集合
 * 如ArrayList
 */
public class UnsafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

 /*       try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(list.size());
    }
}
