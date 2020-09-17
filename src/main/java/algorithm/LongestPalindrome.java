package algorithm;

/**
 * 最长回文子串---》双指针，中心扩展
   遍历字符串的每一个字符，以之为中心求可扩展的最长长度的回文字符串
 * 回文串就是正着读和反着读都一样的字符串
 */
public class LongestPalindrome {

    String longestPalindrome(String s) {
        return "";
    }

    /*
    寻找回文串：从中间开始向两边扩散来判断回文串

    for 0 <= i < len(s):
    # 找到以 s[i] 为中心的回文串
    palindrome(s, i, i)
    # 找到以 s[i] 和 s[i+1] 为中心的回文串
    palindrome(s, i, i + 1)
    更新答案

     */
    String longestPalindrome01(String str) {
        //空字符串
        if (str == null || str.length() < 1) {
            return "字符串为空";
        }
        int left = 0;
        int right = 0;

        //遍历字符串
        for (int i = 0; i < str.length(); i++) {
            // 找到以 s[i] 为中心的回文串
            int len1 = palindrome(str, i, i);
            // 找到以 s[i] 和 s[i+1] 为中心的回文串
            int len2 = palindrome(str, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return str.substring(left, right + 1);
    }

    int palindrome(String str, int left, int right) {
        int L = left, R = right;
        // 防止索引越界
        while (L > 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
            // 向两边展开
            L--;
            R++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return (R - 1) - (L + 1) + 1;
    }


}
