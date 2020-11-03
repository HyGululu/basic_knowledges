package jichu.Thread.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 测试JUC安全类型的集合
 */
public class JUCTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            //用Lambda表达式写线程体
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(list.size());
        }
    }
}
