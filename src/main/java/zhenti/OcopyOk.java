package zhenti;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class OcopyOk {

    /**
     * 统计字符串中含有多少个子串
     */
    public int countSubString(String str, String subStr) {
        //计数
        int count = 0;
        //子串出现的索引
        int index;
        //字符串和子串不为空
        if (StringUtils.isNotEmpty(str) && StringUtils.isNotEmpty(subStr)) {
            //子串的长度
            int subLength = subStr.length();
            //第一次出现的索引，-1时候索引越界了
            while ((index = str.indexOf(subStr)) != -1) {
                str = str.substring(index + subLength);
                count++;
            }
            return count;
        } else {
            return -1;
        }
    }

    @Test
    public void countSubStringTest() {
        /*String str = "abcabc";
        String subStr = "ab";*/

        String str = "abcabc";
        String subStr = "a";

        //int i = countSubString(str, subStr);
        int i = countSubString2(str, subStr);
        System.out.println("统计出现个数：" + i);
    }

    public int countSubString2(String str, String subStr) {

        //计数使用
        int count = 0;
        //字符串中包含子串的下标，为-1时候表示下标越界
        int index;
        if (StringUtils.isNotEmpty(str) && StringUtils.isNotEmpty(subStr)) {
            //知道子串的长度，
            int subLen = subStr.length();

            while ((index = str.indexOf(subStr)) != -1) {
                //字符串截取新的字符串
                str = str.substring(index + subLen);
                count++;
            }
            return count;
        } else {
            return -1;
        }
    }

    /**
     * 字符串间隔反转
     */
    public String reverseLen(String str, int len) {
        //校验字符串不为空，不为null，空格虽然没有意义，但是就不校验了，空格也行吧；
        // 校验间隔长度大于0，间隔间隔长度小于等于字符串长度
        if (StringUtils.isNotEmpty(str) && str.length() > len && len > 0) {
            String revStr = "";
            for (int i = 0; i < str.length(); i = i + len) {
                //判断i+len会不会超过字符串长度，如果没超过尾部就是i+len，超过了就是字符串的长度str.length()
                if (i + len < str.length()) {
                    revStr = revStr + new StringBuilder(str.substring(i, i + len)).reverse().toString();
                } else {
                    revStr = revStr + new StringBuilder(str.substring(i, str.length())).reverse().toString();
                }
            }

            return revStr;
        } else {
            return "参数不合法！！";
        }
    }

    @Test
    public void reverseLenTest() {
        String str = "abcdef";
        int len = 2;
        /*String s = reverseLen(str, len);
        System.out.println("字符串间隔反转：" + s);*/
        String s = reverseLen1(str);
        System.out.println("字符串间隔反转：" + s);
    }

    /**
     * 字符串反转
     */
    public String reverseLen1(String str) {
        //非空判断
        if (StringUtils.isNotEmpty(str)) {
            String revStr = "";
            revStr = new StringBuilder(str).reverse().toString();
            return revStr;
        } else {
            return "字符串为空！！";

        }
    }

    /**
     * 最大和子序列
     */
    public int subMax(int a[]) {
        //用来保存最大连续子数组的值
        int max = a[0];
        //左下标
        int low = 0;
        //右下标
        int high = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum = sum + a[j];
                if (sum > max) {
                    max = sum;
                    low = i;
                    high = j;
                }
            }
        }
        System.out.println("开始下标：" + low + "结束下标：" + high);
        return max;
    }

    @Test
    public void subMaxTest() {
        int arr[] = {3, 4, 1, -5, -6, 28};
        int max = subMax(arr);
        System.out.println(max);
    }

    /**
     * 二分查找
     **/
    public int binarySearch(int a[], int value) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (value == a[mid]) {
                return mid;
            } else if (value < a[mid]) {
                high = mid - 1;
            } else if (value > a[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void binarySearchTest() {
//        //奇数个
        int a[]={1,2,3,4,5};
        //偶数个
        //int a[] = {1, 2, 3, 4};

        //测试要点：边界值，中间值，不在里面的值，直接都遍历一遍
        //int half = binarySearch(a, -1);
        int half = binarySearch(a, 5);
        System.out.println(half);
    }
}
