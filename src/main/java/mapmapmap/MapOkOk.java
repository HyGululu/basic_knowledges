package mapmapmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapOkOk {

    //遍历map
    @Test
    public void testMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("姓名", "ghy");
        map.put("年龄", 18);

        /*
        方式1
         */
        //1、遍历key
        for (String str : map.keySet()) {
            System.out.println("遍历key，结果 ： " + str);
        }

        //2、遍历value
        for (Object obj : map.values()) {
            System.out.println("遍历value,结果： " + obj);
        }

        /*
        方式2，通过entry
         */
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("遍历entry,结果： " + entry);
        }

        /*
        方式3，通过Iterator遍历
         */
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }
        /*
        方式4，通过Iterator遍历
         */
        for (String strKey : map.keySet()) {
            //key是s
            //值是map.get(s)
            Object value = map.get(strKey);
            System.out.println("iterator,结果： " + value);
        }

    }
}
