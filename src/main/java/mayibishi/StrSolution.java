package mayibishi;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class StrSolution {


    //给定一个字符串，统计字符出现次数
    public static void main(String[] args) {
        // 录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        // 创建HashMap集合，键是Character,值是Integer
        //结果不排序
        //			HashMap<Character, Integer> hs = new HashMap<>();

        // TreeMap结果排序
        TreeMap<Character, Integer> hs = new TreeMap<>();

        // 遍历字符串，拿到每一个字符
        for (int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);

            // 拿到每一个字符作为键到HashMap集合中去找对应的值，看其返回值
            Integer value = hs.get(key);

            if (value == null) {
                // 如果值是null，说明字符在HashMap集合中不存在，把字符作为键，1作为存储值
                hs.put(key, 1);
            } else {
                // 如果返回值不是null，则字符在HashMap集合中存在，则把该值加1，重新存储
                value++;
                hs.put(key, value);
            }
        }

        // 遍历HashMap集合，得到键和值，按照要求进行拼接
        StringBuilder sb = new StringBuilder();

        Set<Character> keySet = hs.keySet();
        for (Character key : keySet) {
            Integer value = hs.get(key);
            //				System.out.println(key+"("+value+")");
            sb.append(key).append("(").append(value).append(")");
        }
        String result = sb.toString();
        System.out.println(result);
    }


}
