package algorithm.stringokok;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang.StringUtils.isEmpty;

public class StringSolution {
    /*
    字符串排序：
    方法1：键索引计数法
    方法2：低位优先的字符串排序
    方法3：高位优先的字符串排序
     */

    /**
     * 方法1：键索引计数法：
     * 1、计算出现频率
     * 2、将频率转换为索引
     * 3、将元素分类
     * 4、回写
     */
    public static void main(String[] args) {
        String[] arrStr = new String[0];
        //字符串数组长度

        /*
        String 类的常用方法都有那些呢？
indexOf()：返回指定字符的索引。
charAt()：返回指定索引处的字符。
replace()：字符串替换。
trim()：去除字符串两端空白。
split()：分割字符串，返回一个分割后的字符串数组。
getBytes()：返回字符串的 byte 类型数组。
length()：返回字符串长度。
toLowerCase()：将字符串转成小写字母。
toUpperCase()：将字符串转成大写字符。
substring()：截取字符串。
equals()：字符串比较。
         */
        String str = "abc";
        int a = str.indexOf("b");
        char c = str.charAt(2);
        String replace = str.replace("abc", "bca");
        String trim = " abc ".trim();
        String s = str.toLowerCase();
        String s1 = str.toUpperCase();

        /*
        字符串反转
         */
        String stra = "abcd";
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < stra.length(); i++) {
            stb.append(stra.charAt(i));
        }
        System.out.println(stb.toString());
        System.out.println(new StringBuffer(stra).reverse().toString());
    }
    /*
        字符串替换，有三种

     */

    //leetcode-3-无重复字符的最长字串
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int res = 0;
        //子串的开始位置
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                //如果没有取最大值会报错，不如abba,本来结果应该为2，却输出3
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            res = Math.max(res, end - start + 1);
        }
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        return res;
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        int i = lengthOfLongestSubstring("abcabcabcdabcde");
        System.out.println("结果是:" + i);

    }

    /*反转字符串*/
    //1. 利用 StringBuffer 或 StringBuilder 的 reverse 成员方法:
    public String reverseString1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    //2. 利用 String 的 toCharArray 方法先将字符串转化为 char 类型数组，然后将各个字符进行重新拼接:
    public String reverseString2(String str) {
        char[] chars = str.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        return reverse;
    }

    //　3. 利用 String 的 CharAt 方法取出字符串中的各个字符:
    public String reverseString3(String str) {
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }

    @Test
    public void reverseStringTest() {
        String s = "abc123";

        System.out.println("变换前: " + s);
        System.out.println("变换后: " + reverseString1(s));
        System.out.println("变换后: " + reverseString2(s));
        System.out.println("变换后: " + reverseString3(s));
    }

    /*统计子串出现次数*/
    //1、利用 Apache 的 Commons Lang 库：
    public int countSubString1(String str, String subStr) {
        int count = org.apache.commons.lang.StringUtils.countMatches(str, subStr);
        return count;
    }

    //2、用 Spring Framework 提供的接口：
    public int countSubString2(String str, String subStr) {
        int occurrence = StringUtils.countOccurrencesOf(str, subStr);
        return occurrence;
    }

    //3、从指定的索引开始，返回第一次出现的指定子字符串在此字符串内的索引实现子串出现次数的统计。
    public int countSubString3(String str, String subStr) {
        if (subStr == null || "".equals(subStr)) return 0;
        int count = 0;
        int fromIndex = 0;
        while (true) {
            int index = str.indexOf(subStr, fromIndex);
            if (index == -1) {
                break;
            }
            fromIndex = index + 1;
            count++;
        }
        return count;
    }

    @Test
    public void countSubStringTest() {
        String str = "abcdefgabcabcefgefgerty1234589";
        String subStr = "abc";

        System.out.println(countSubString1(str, subStr));
        System.out.println(countSubString2(str, subStr));
        System.out.println(countSubString3(str, subStr));

    }
}
