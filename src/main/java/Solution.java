/*
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public boolean isAnagram(String s, String t) {
        //解法1，排序
        if(s.length()!=t.length()){
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1,str2);

        //解法2，一个长度为26的小写字母数组，s数组元素是对应小写字母出现下标+1，t数组元素出现下班-1，最后判断数组里元素出现次数0
        //解法3，两个长度为26的小写字母数组，统计字母出现次数，最后判断是否相等

    }

    @Test
    public void isAnagramTest() {
        String str1 = "anagram";
        String str2 = "nagaram";
        boolean b = isAnagram(str1,str2);
        System.out.println(b);
    }
}
*/
