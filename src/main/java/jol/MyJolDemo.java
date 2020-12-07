package jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.Date;
import java.util.HashMap;

public class MyJolDemo {
    public static void main(String[] args) {
        Object obj = generate();
        //查看对象内部信息
        print(ClassLayout.parseInstance(obj).toPrintable());
        //查看对象外部信息
        print(GraphLayout.parseInstance(obj).toPrintable());
        //获取对象信息大小
        print("size : " + GraphLayout.parseInstance(obj).totalSize());
    }

    static void print(String message){
        System.out.println(message);
        System.out.println("#################");
    }

    static Object generate() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("a",new Integer(1));
        map.put("b","b");
        map.put("c",new Date());

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i),String.valueOf(i));
        }
        return map;
    }
}
