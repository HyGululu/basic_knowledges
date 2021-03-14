package omylisto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList线程安全处理四种方式：
 * 1、Collections.synchronizedList
 * 2、为list.add()方法加锁synchronized？
 * 3、CopyOnWriteArrayList
 * 4、使用ThreadLocal？
 *
 * */
public class MyList2 {

    public static void main(String[] args) throws InterruptedException {

        final List<Integer> list = new ArrayList<>();

        //方式1、通过 Collections 的 synchronizedList 方法将 ArrayList 转换成线程安全的容器后再使用
        //List<Object> list = Collections.synchronizedList(new ArrayList<>());
        //方式3、使用线程安全的 CopyOnWriteArrayList 代替线程不安全的 ArrayList
        //List<Integer> list = new CopyOnWriteArrayList<>();
        //方式4、使用ThreadLocal？
        /*ThreadLocal<List<Integer>> threadList = new ThreadLocal<List<Integer>>(){
            @Override
            protected List<Integer> initialValue() {
                return new ArrayList<Integer>();
            }
        };*/


        //线程A将1--1000添加到列表
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    //方式2、为list.add()方法加锁synchronized？
                        list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //线程B将1001--2000添加到列表
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1001; i < 2000; i++) {
                    list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(1000);
        //打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素" + list.get(i));
        }
    }
}

