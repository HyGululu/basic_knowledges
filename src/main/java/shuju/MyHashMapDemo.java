package shuju;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashMapDemo {
    /*
    hashmap四种遍历方式
     */

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 2000; i++) {
            map.put(i, "ha,第" + i + "个");
        }
        long s1 = System.nanoTime();
        Object[] objects = map.entrySet().toArray();
        for (int i = 0; i < map.size(); i++) {
            map.get(objects[i]);
        }
        long e1 = System.nanoTime();

        long s2 = System.nanoTime();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            entry.getValue();
        }
        long e2 = System.nanoTime();

        long s3 = System.nanoTime();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            map.get(next);
        }
        long e3 = System.nanoTime();

        long s4 = System.nanoTime();
        for (Integer key : map.keySet()) {
            map.get(key);
        }
        long e4 = System.nanoTime();

        System.out.println("第一种方法耗时：" + (e1 - s1) / 1000 + "微秒");
        System.out.println("第二种方法耗时：" + (e2 - s2) / 1000 + "微秒");
        System.out.println("第三种方法耗时：" + (e3 - s3) / 1000 + "微秒");
        System.out.println("第四种方法耗时：" + (e4 - s4) / 1000 + "微秒");

    }
}
