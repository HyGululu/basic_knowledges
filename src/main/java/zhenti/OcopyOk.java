/*
package zhenti;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class OcopyOk {
    //统计字符串中含有多少个子串
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

  @org.junit.jupiter.api.Test
    public void countSubStringTest() {
        String str = "abcabc";
        String subStr = "ab";


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

// 字符串间隔反转
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
        String s = reverseLen(str, len);
        System.out.println("字符串间隔反转：" + s);

        String s = reverseLen1(str);
        System.out.println("字符串间隔反转：" + s);
    }

// 字符串反转


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

// 最大和子序列


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

    //二分查找
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
        int a[] = {1, 2, 3, 4, 5};
        //偶数个
        //int a[] = {1, 2, 3, 4};

        //测试要点：边界值，中间值，不在里面的值，直接都遍历一遍
        //int half = binarySearch(a, -1);
        int half = binarySearch(a, 5);
        System.out.println(half);
    }

    */
/**
     * 有100块钱，一瓶水3块钱，2个空瓶子可以换一瓶水，可以拥有多少瓶水
     * <p>
     * 1、99/3=33，剩一块钱
     * 2、32/2=16，剩一块钱，剩一个瓶子
     * 3、16/2=8，剩一块钱，剩一个瓶子
     * 4、8/2=4，剩一块钱，剩一个瓶子
     * 5、4/2=2，剩一块钱，剩一个瓶子
     * 6、2/2=1，剩一块钱，剩两个瓶子
     * 7、2/1=1，剩一块钱
     * <p>
     * 7、33+16+8+4+2+1+1 =65
     * <p>
     * 有100块钱，一瓶水2块钱，2个空瓶子可以换一瓶水，可以拥有多少瓶水
     * 1、100/2 =50，瓶子有50个
     * 2、50/2=25，50%2=0
     * 3、25/2 =12 , 25%2=1 ,剩一个瓶子
     * 4、12/2=6 ,12%2=0
     * 5、6/2=3, 6%2=0
     * 6、3/2=1,3%2=1，又剩一个瓶子
     * 7、1/2=0;
     * <p>
     * 8、50+25+12+6+3+1+1=98
     *//*



    public int countBottle(int money, int price, int exchange) {
        int count = 0;
        //这么多钱能买多少瓶水
        int countWB = money / price;
        count = countWB;
        //有多少个空瓶子可以换多少个水瓶子
        int a = countWB / exchange;
        int b = countWB % exchange;
        count = count + countWB;
        System.out.println("取模% ： " + b);
        System.out.println("取余% ： " + a);
        //如果空水瓶除以数不为1，就递归
        countWB = countWB / exchange;
        count = count + countWB;
        System.out.println("count3: " + count + "  现在有多少3: " + countWB);
        countWB = countWB / exchange;
        count = count + countWB;
        System.out.println("count4: " + count + "  现在有多少4: " + countWB);
        countWB = countWB / exchange;
        count = count + countWB;
        System.out.println("count5: " + count + "  现在有多少5: " + countWB);
        countWB = countWB / exchange;
        count = count + countWB;
        System.out.println("count6: " + count + "  现在有多少6: " + countWB);
        countWB = countWB / exchange;
        System.out.println("count7: " + count + "  现在有多少7: " + countWB);

        //几个瓶子可以换，和瓶子剩余个数比较
        //取模的值
        int countM = 0;
        while ((countWB / exchange) > 0) {
            countWB = countWB / exchange;
            count += countWB;
            System.out.println("count: " + count + "  现在有多少: " + countWB);
        }
        return count;
    }

    @Test
    public void countBottleTest() {
        int i = countBottle(100, 3, 2);
        System.out.println("统计数量是： " + i);
    }

    //给一个目标值和数组，判断数组中是否有两数之和等于目标值
    //int[] a = {2, 34, 5}; target 10
    //1、a[0]+a[1]  2+34
    //2、a[0]+a[2]  2+5
    //3、a[1]+a[2]  34+5


    public boolean isHave(int a[], int target) {
        if (a.length == 0 || a == null) {
            return false;
        }
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                System.out.println(a[i] + "  " + a[j]);
                if (a[i] + a[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void isHaveTest() {
        //int[] a = {2, 34, 5};
        int[] a = {};
        boolean isHave = isHave(a, 10);
        System.out.println(isHave);
    }


    //限定语言：C、Python、C++、Javascript、Python 3、Java、Go
    //给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。

    //找到字符串的最长无重复字符子串
    public String findSubStr(String str) {
        if (str.length() == 0 || str == null) {
            System.out.println("参数错误！！");
            return "参数错误";
        } else {
            //最长子串
            String maxStr = null;
            //字符串长度
            int len = str.length();
            //存放字符串的集合
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len + 1; j++) {
                    int cc = 0;
                    System.out.println(str.substring(i, j));
                    char c = str.charAt(i);

                    map.put(str.substring(i, j), cc);
                    cc++;

                    for (int k = 0; k < len; k++) {
                        char c1 = str.charAt(k);
                        System.out.println("charAt " + c1);

                    }
                }
            }
            map.put(str.substring(0, 1), 0);
            map.put(str.substring(0, 2), 1);
            map.put(str.substring(0, 3), 2);
            map.put(str.substring(0, 4), 3);
            map.put(str.substring(2, 4), 4);

            map.put("a", 0);
            map.put("ab", 1);
            map.put("abc", 2);
            map.put("abca", 3);
            map.put("ad", 4);
            boolean a = "abc".contains("a");
            int length = "abc".length();


            map.put("ab", 4);


            for (String str1 : map.keySet()) {
                System.out.println("遍历key，结果 ： " + str1);
            }

            return maxStr;
        }

    }

    @Test
    public void findSubStrTest() {
        //findSubStr("");
        findSubStr("abcad");
    }

// 快速排序


    public void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int i, j, temp, t;
        i = low;
        j = high;
        //temp是基准位
        temp = arr[low];

        while (i < j) {
            //先看左边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看右边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足交换条件
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            //最后将基准为i和j相等位置的数字交换
            arr[low] = arr[i];
            arr[i] = temp;
            //递归调左半边数组
            quickSort(arr, low, j - 1);
            //递归调右半边数组
            quickSort(arr, j + 1, high);
        }
    }

    @Test
    public void quickSortTest() {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：");
        for (int i : arr) {
            System.out.println(i);
        }
    }


    //给一个目标值和数组，判断数组中是否有两数之和等于目标值
    public boolean isHaveSum(int a[], int target) {
        //  集合: 用来存放遍历过的数组中的值
        HashSet hashSet = new HashSet();
        // 目标值 - 当前遍历的值, 检查集合中是否有该值, 如果有, 证明存在
        for (int i = 0; i < a.length; i++) {
            if (hashSet.contains(target - a[i])) {
                return true;
            } else {
                // 如果没有, 则将该值放入集合
                hashSet.add(a[i]);
            }
        }
        // 全部遍历完都没有找到的话, 证明不存在, 返回false
        return false;
    }

    @Test
    public void isHaveSumTest() {
        int[] a = {1, 2, 3, 4, 5};
        boolean haveSum = isHaveSum(a, 5);
        System.out.println("数组中是否有两数之和等于目标值：" + haveSum);
    }



    */
/**
     * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1
     * "输入：1AB2345CD","12345EF"  返回："2345"
     * 考点：动态规划
     *//*



    public String LCS(String str1, String str2) {
        // 字符串长度
        int len1 = str1.length();
        int len2 = str2.length();
        // base case，默认 dp 中的每个元素都为 0。
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 最长公共子串， 用一个临时变量表示
        int resultLCS = 0;
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                // 以下是状态转移方程
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    resultLCS = Math.max(resultLCS, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }

        }
        return "";
    }

    @Test
    public void lcsTest() {
        // String lcs = LCS("1AB2345CD", "12345EF");
        String longabc = longabc("1AB2345CD", "12345EF");
        System.out.println("最长公共子串 " + longabc);
    }

    public String longabc(String str1, String str2) {
        int len1 = str1.length();
        String max = "无";
        int len = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = i + 1; j < len1 + 1; j++) {
                String subStr = str1.substring(i, j);
                if (subStr.length() > len && str2.contains(subStr)) {
                    max = subStr;
                    len = subStr.length();
                    System.out.println("len长度 " + len);
                    System.out.println("子串 " + max);
                }
            }

        }
        return max;
    }

// jinrongde
    //1.查找某个元素在有序数组中的位置
    //2.查找数组中出现次数超过一半的数字
    //3.统计一段文本中指定字符串出现的次数
    //4.传入日期的年月日,返回天数.
    //5.查找单链表的中间节点，要求只能遍历一次链表
    //6.一个数组中只有一个数字出现奇数次，其他都是出现偶数次，时间复杂度为O(n);

    public static int binSearch(int srcArray[], int start, int end, int key) {
        int mid = (end + start) / 2;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }

    public int moreThanHaft(int[] num) {
        int result = -1;
        int times = 0;
        for (int i = 0; i < num.length; i++) {
            if (times == 0) {
                result = num[i];
                times++;
            } else {
                if (num[i] == result) {
                    times++;
                } else {
                    times--;
                }
            }
        }

        return result;
    }


    public int text(String text, String input) {

        int count = 0;

        for (inti = 0; i <= text.length() - input.length(); i++) {

            String sb = text.substring(i, i + input.length());

            if (sb.equals(input)) {

                count++;

            }

        }

        return count;

    }

    public int orderDate(int year, int month, int day) {
        int dateSum = 0;
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    dateSum += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    dateSum += 30;
                    break;
                case 2:
                    if (((year % 4 == 0) & (year % 100 != 0)) | (year % 400 == 0))
                        dateSum += 29;
                    else dateSum += 28;
            }
        }
        return dateSum = dateSum + day;
    }
    //思路：快慢指针

    class ListNode {
        int data;
        ListNode next;
    }

    public class Link {
        public static void FindMid(ListNode first) {
            ListNode fast = first;
            ListNode slow = first;
            while ((fast != null) && (fast.next != null)) {
                fast = fast.next.next;
                slow = slow.next;
            }
            System.out.println(slow.data);

        }

        public static void main(String[] args) {
            ListNode n1 = new ListNode();
            ListNode n2 = new ListNode();
            ListNode n3 = new ListNode();
            ListNode n4 = new ListNode();
            ListNode n5 = new ListNode();
            n1.data = 1;
            n2.data = 2;
            n3.data = 3;
            n4.data = 4;
            n5.data = 5;
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            FindMid(n1);
        }
    }

    public class Test {
        public static void main(String[] args) {
            int[] arr = {1, 1, 2, 3, 4, 2, 3,};
            int res = arr[0];
            for (int i = 1; i < arr.length; i++) {
                res ^= arr[i];
            }
            System.out.println(res);
        }
    }


}
*/
