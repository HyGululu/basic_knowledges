package collections;

import java.util.*;

public class MyCollectionsDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(3);
        System.out.print("排序前：");
        for (Integer temp : list) {
            System.out.print(temp.toString() + " ");
        }
        //使用默认排序
        System.out.println();
        Collections.sort(list);
        System.out.print("排序后1：");
        for (Integer temp : list) {
            System.out.print(temp.toString() + " ");
        }


        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("zs",20);
        map.put("ls",28);
        map.put("ww",19);
        map.put("zl",20);
        map.put("qq",25);

        List<Map.Entry<String, Integer>> list2 = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        //自定义排序1
        System.out.println();
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue().compareTo(o2.getValue()));
            }
        };
        System.out.print("自定义排序后1：");
        Collections.sort(list2,comparator);
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i));
        }


        List<Map.Entry<String, Integer>> list3 = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        //自定义排序2
        System.out.println();
        list3.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getKey().compareTo(o2.getKey()));
            }
        });
        System.out.print("自定义排序后2：");
        for (int i = 0; i < list3.size(); i++) {
            System.out.print(list3.get(i));
        }


    }

}
/*
Java中Collections.sort()的使用
对一些数据进行排序的操作。然而那些数据一般都是放在一个集合中如：Map ，Set ，List 等集合中。
他们都提共了一个排序方法 sort()，要对数据排序直接使用这个方法就行，但是要保证集合中的对象是 可比较的。

怎么让一个对象是 可比较的，那就需要该对象实现 Comparable<T> 接口啦。然后重写里面的
compareTo()方法。我们可以看到Java中很多类都是实现类这个接口的 如：Integer，Long 等等。。。
Integer extends Number implements Comparable<Integer>

比较器 ：Comparator
Comparator 的使用有两种方式：
Collections.sort(list,Comparator<T>）;
list.sort(Comparator<T>);
 */