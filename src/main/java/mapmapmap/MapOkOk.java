package mapmapmap;


import org.junit.jupiter.api.Test;
import rpcdemo.rpc1.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapOkOk {

    //遍历map
    public void oMap() {
        Map<Long, Integer> oMap = new HashMap<>(1);
        Map<Long, Integer> oMap1 = new HashMap<>(1);
        Map<Long, Map<Long, List<User>>> oMap2 = new HashMap<>(1);
        Map<Long, String> oMap3 = new HashMap<>(64);
        Map<String, String> oMap4 = new ConcurrentHashMap<>(32);

        oMap.get(123L);
        oMap.put(123L, 123);
        boolean flag = oMap.containsKey(123L);

        HashMap<String, Object> map = new HashMap<>();
        map.put("姓名", "ghy");
        map.put("年龄", 18);

        /*map.clear();
        map.clone();
        map.containsKey();
        map.containsValue();
        map.entrySet();//对map进行遍历
        map.get();
        map.isEmpty();
        map.keySet();
        map.put();
        map.putAll();
        map.remove();
        map.size();
        map.values();*/


        Map<Integer, String> hashMap = new HashMap<>();
        //在map里放2000个元素
        for (int i = 0; i < 2000; i++) {
            hashMap.put(i, "ha,第" + i + "个");
        }
        hashMap.keySet();
        hashMap.values();
        hashMap.entrySet();
        hashMap.entrySet().iterator();
        for (Integer key : hashMap.keySet()) {
        }

        /**
         hashmap四种遍历方式
         */

        //第一种：普遍使用，二次取值
        System.out.println("方式一：通过Map.keySet遍历key和value：");
        long s1 = System.nanoTime();
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }
        long e1 = System.nanoTime();

        /*
        方式2，通过Iterator迭代器遍历
         */
        System.out.println("方式二 通过Map.entrySet使用iterator遍历key和value：");
        long s2 = System.nanoTime();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            System.out.println("key= " + entry.getKey() + "and value= " + entry.getValue());
        }
        long e2 = System.nanoTime();
        /*
        方式3，通过entrySet,推荐，尤其是容量大时
         */
        System.out.println("通过Map.entrySet遍历key和value ");
        long s3 = System.nanoTime();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        long e3 = System.nanoTime();

        //第四种、遍历value
        System.out.println("方式4 通过Map.values()遍历所有的value，但不能遍历key");
        long s4 = System.nanoTime();
        for (Object obj : map.values()) {
            System.out.println("遍历value,结果： " + obj);
        }
        long e4 = System.nanoTime();


        System.out.println("通过Map.keySet耗时：" + (e1 - s1) / 1000 + "微秒");
        System.out.println("通过Map.entrySet使用iterator耗时：" + (e2 - s2) / 1000 + "微秒");
        System.out.println("通过Map.entrySet耗时：" + (e3 - s3) / 1000 + "微秒");
        System.out.println("通过Map.values()耗时：" + (e4 - s4) / 1000 + "微秒");

    }

    @Test
    public void testMap() {
        oMap();
    }
}
