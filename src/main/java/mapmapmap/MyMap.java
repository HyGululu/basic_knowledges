package mapmapmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyMap {
    /*
    hashmap四种遍历方式
     */

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        //在map里放2000个元素
        for (int i = 0; i < 2000; i++) {
            map.put(i, "ha,第" + i + "个");
        }

        //方式1 通过Map.entrySet遍历key和value
        long s1 = System.nanoTime();
        Object[] objects = map.entrySet().toArray();
        for (int i = 0; i < map.size(); i++) {
            map.get(objects[i]);
        }
        long e1 = System.nanoTime();

        //方式2 通过entrySet,推荐，尤其是容量大时
        long s2 = System.nanoTime();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            entry.getValue();
        }
        long e2 = System.nanoTime();

        //方式3 通过Iterator迭代器遍历
        long s3 = System.nanoTime();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            map.get(next);
        }
        long e3 = System.nanoTime();

        //方式4 通过Map.keySet遍历key和value
        long s4 = System.nanoTime();
        for (Integer key : map.keySet()) {
            map.get(key);
        }
        long e4 = System.nanoTime();

        System.out.println("第一种方法耗时：" + (e1 - s1) / 1000 + "微秒");
        System.out.println("第二种方法耗时：" + (e2 - s2) / 1000 + "微秒");
        System.out.println("第三种方法耗时：" + (e3 - s3) / 1000 + "微秒");
        System.out.println("方式4 通过Map.keySet遍历key和value 耗时：" + (e4 - s4) / 1000 + "微秒");


        MyMap myMap = new MyMap();
        myMap.put("zhangsan", "zhangsan");
        myMap.put("lisi", "lisi");
        myMap.put("wangwu", "wangwu");
        myMap.put("zhaoliu", "zhaoiu");
        myMap.put("qianqi", "qianqi");
        //System.out.println(myMap.get("zhangsan"));

        //数组：采用一连串的存储空间来存储数据；查询快，插入慢
        Integer[] integers = new Integer[10];
        integers[0] = 0;
        integers[1] = 1;
        integers[2] = 2;
        integers[9] = 9;

        //链表
        Node node = new Node(15);
        node.next = new Node(1);
        node.next.next = new Node(9);

        //哈希算法（散列）

    }

    static class Node {
        public Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
        //链表：物理存储单元上非连续，非顺序的存储结构；插入快，查找慢
    }


    /***
     * 实现put原理
     * 输出  key value hashcode 等 hash算法
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        //hash函数
        System.out.printf("key:%s,hash值:%s,存储位置:%s\r\n", key, key.hashCode(), Math.abs(key.hashCode() % 15));


    }

}
