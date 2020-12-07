import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Properties;


public class ShaTanShang {
    //比较两个版本大小
    public int compareVersion(String version1, String version2) {
        //字符串截取
        //String[] splits = version1.split("[.]");
        String[] splits = version1.split("[.]");
        String[] splits2 = version2.split("[.]");
        int len1 = splits.length;
        int len2 = splits2.length;
        //循环长度看哪个大
        int max = Math.max(len1, len2);
        int i1, i2;
        for (int i = 0; i < max; i++) {
            //如果长度小，补全一个0
            i1 = i < len1 ? Integer.parseInt(splits[i]) : 0;
            i2 = i < len2 ? Integer.parseInt(splits2[i]) : 0;
            //比较大小
            if (i1 != i2) {
                System.out.println("两数分别是： " + i1 + " " + i2);
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }

    @Test
    public void compVerTest() {
        String str1 = "2.0.3.3";
        String str2 = "2.0.3";
        int ver = compareVersion(str1, str2);
        System.out.println("版本大小比较: " + ver);
    }

    public static void main(String[] args) {
        //String 搞一搞
        System.out.println("String 搞一搞***************");
        String str = "123.123.abc";
        System.out.println("第二个下标的字符是：" + str.charAt(1));
        String[] split2 = str.split("[.]");
        for (int i = 0; i < split2.length; i++) {
            System.out.println("切割字符串：" + split2[i].toString());
        }
        System.out.println("2字符的下标：" + str.indexOf("2"));
        System.out.println("字符串长度：" + str.length());
        System.out.println("字符串是否为空：" + str.isEmpty());
    }

    public void test() {
        //获取所有的属性
        Properties properties = System.getProperties();
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            //输出对应的键和值
            System.out.println(key + "=" + properties.getProperty(key));
        }
        System.out.println("env =" + System.getProperties().getProperty("env"));

    }

    //统计字符串中含有多少个子串
    public int getSubStrs(String str, String tarStr) {
        //按照目标子串的长度，截取子串
        int subLen = tarStr.length();
        String substring;
        int count = 0;
        //字符串不为空
        if (str == null || str.trim().isEmpty() || tarStr == null || tarStr.trim().isEmpty()) {
            return -1;
        } else {
            //在字符串中的下标
            int indexOf = str.indexOf(tarStr);
            //存在子串
            if (indexOf!=-1){
                for (int i = 0; i < str.length(); i++) {
                    substring = str.substring(indexOf + subLen);
                    str = substring;

                    if (str.indexOf(tarStr)!=-1){
                        System.out.println("子串是："+str);
                    count++;}
                }

            }
            return count;
        }
    }

    @Test
    public void getSubStrsTest() {
        String str = "abcdabde";
        int num = getSubStrs(str, "ab");
        System.out.println("字符串里有多少个子串？ " + num);
    }

    //两数之和
    // 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //如果数组为空，或者数组长度是0，直接返回
        if (null==nums||nums.length==0){
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return null;
    }
    @Test
    public void twoSumTest() {
        int[] nums = new int[]{1,2,3,4,5,6};
        int[] ints = twoSum(nums, 5);
        System.out.println("结果是？ "+ints);
    }
}
