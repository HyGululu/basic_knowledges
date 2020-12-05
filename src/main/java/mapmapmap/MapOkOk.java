package mapmapmap;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapOkOk {

    //遍历map
    public void testMap() {
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

        //第一种：普遍使用，二次取值
        System.out.println("方式一：通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            //System.out.println("遍历key，结果 ： " + key);
            System.out.println("key= "+key+" and value= "+map.get(key));
        }

        /*
        方式2，通过Iterator迭代器遍历
         */
        System.out.println("方式二 通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            System.out.println("key= "+entry.getKey() + "and value= " + entry.getValue());
        }
        /*
        方式3，通过entrySet,推荐，尤其是容量大时
         */
        System.out.println("通过Map.entrySet遍历key和value ");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种、遍历value
        System.out.println("方式4 通过Map.values()遍历所有的value，但不能遍历key");
        for (Object obj : map.values()) {
            System.out.println("遍历value,结果： " + obj);
        }

    }
}
