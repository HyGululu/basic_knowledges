import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Study {

    /**
     * 统计字符串中含有多少个子串
     *
     * @param str
     * @param subStr
     * @return
     */
    public int countSubString(String str, String subStr) {
        int count = 0;
        int index = 0;
        //子串长度,空格也是有长度的,子串为空格可以,子串为空会陷入死循环！！！子串为null会报空指针异常
        try {
            if (StringUtils.isNotEmpty(str) && StringUtils.isNotEmpty(subStr)) {
                //子串长度
                int subStrLen = subStr.length();
                while ((index = str.indexOf(subStr)) != -1) {
                    str = str.substring(index + subStrLen);
                    count++;
                }
                return count;
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常抛出了！！");
            return -1;
        }
    }

    @Test
    public void countSubStringTest() {
        //子串为null
//        String str="ha";
//        String subStr = null;

        //子串为空
//        String str="ha";
//        String subStr = "";

//        //子串为空格
//        String str="h  ala  la";
//        String subStr = "  ";

        //子串长度大于父字符串
        String str = "ha";
        String subStr = "aeuwroerue";

        //子串等于父串
//        String str="ha";
//        String subStr = "ha";

//        //正常数据包含
//        String str="haahahoiehaah";
//        String subStr = "ha";

        //不包含数据
//        String str="haahahoiehaah";
//        String subStr = "huyanfen";

        int i = countSubString(str, subStr);
        System.out.println("次数为:" + i);
    }


    /**
     * 字符串间隔反转
     *
     * @param str
     * @param len
     * @return
     */
    public String reverseLen(String str, int len) {
        //校验字符串不为空，不为null，空格虽然没有意义，但是就不校验了，空格也行吧；
        // 校验间隔长度大于0，间隔间隔长度小于等于字符串长度
        if (StringUtils.isNotEmpty(str) && str.length() >= len && len > 0) {
            String fina = "";
            for (int i = 0; i < str.length(); i = i + len) {
                //判断i+len会不会超过字符串长度，如果没超过尾部就是i+len，超过了就是字符串的长度str.length()
                if (i + len < str.length()) {
                    fina = fina + (new StringBuilder(str.substring(i, i + len))).reverse().toString();
                } else {
                    fina = fina + (new StringBuilder(str.substring(i, str.length()))).reverse().toString();
                }
            }
            return fina;
        } else {
            return "参数不合法";
        }
    }

    @Test
    public void reverseLen() {
        //字符串为空格、null、""
//        String str="     ";
//        int len=2;
        //间隔等于,小于，大于字符串长度，间隔小于等于0
        String str = "    ";
        int len = 2;

        String qwemvchu = reverseLen(str, len);
        System.out.println("返回值为：" + qwemvchu);
    }


    /**
     * 最大和子序列
     *
     * @param a
     * @return
     */
    public int subMax(int a[]) {
        int max = a[0];
        int low = 0;
        int high = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
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
        int a[] = {3, 4, 1, -5, -6, 28};
        int max = subMax(a);
        System.out.println(max);
    }


    /**
     * 二分查找
     *
     * @param a
     * @param
     * @return
     */
    public int findHalf(int a[], int value) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) { //必须取等
            mid = (high - low) / 2 + low;//注意点
            if (a[mid] == value) {
                return mid;
            }
            if (a[mid] > value) {
                high = mid - 1;
            }
            if (a[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void testFindHalf() {
//        //奇数个
//        int a[]={1,2,3,4,5};
        //偶数个
        int a[] = {1, 2, 3, 4};

        //测试要点：边界值，中间值，不在里面的值，直接都遍历一遍
        int half = findHalf(a, -1);
        System.out.println(half);
    }


    /**
     * 有100快钱，一瓶水3块钱，2个空瓶子可以换一瓶水，可以拥有多少瓶水
     */
    public int countBottle(int money, int price, int exchange) {
        int sum = money / price;
        int index = sum;
        while (index >= exchange) {
            sum += index / exchange;
            index = index / exchange + index % exchange;
        }
        return sum;
    }

    @Test
    public void countBottleTest() {
        //交换值不能为1，要大于1，为1会陷入死循环，意味一个空瓶子换一瓶水，恶性循环
        int i = countBottle(100, 3, 2);
        System.out.println(i);
    }


    //给一个目标值和数组，判断数组中是否有两数之和等于目标值
    public boolean isHave(int a[], int target) {
        if (a == null || a.length == 0) return false;//数组不用判断,求长度才不会报空指针异常呢，为null会
        //参数校验，判断数组是否为空
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void testIsHave() {
        //不会报空指针异常
//        int[] a=new int[3];
        //会报空指针异常
//        int[] a=null;
        int[] a = {2, 34, 5};
        boolean b = isHave(a, 10);
        System.out.println(b);
    }

    //找出字符串中第一个个数为1的字符
    public char notRepeatChar(String s) {
        //参数校验
        if (StringUtils.isEmpty(s)) return '空';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {//第一次出现的下标和最后一次出现的下标相等代表只出现过一次
                return c;
            }
        }
        return '无';
    }

    @Test
    public void notRepeatCharTest() {
        String s = "rytedwuqqr";
        char c = notRepeatChar(s);
        System.out.println(c);
    }


    //两个字符串的公共最长子串,找最短的，然后找其子序列，然后判断序列是否在长串中包含（indexOf不为-1），包含存入集合，遍历集合，找出最长

    //最长回文子串
    public String maxString(String s) {
        //判断入参是否为空和null，为空格
        if (StringUtils.isEmpty(s)) return "入参不能为空";
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {//注意边界本身不算
            for (int j = i + 2; j < s.length() + 1; j++) {//注意起始值，左闭右开，不包含本身
                String s1 = s.substring(i, j);
                System.out.println(s1);
                String s2 = (new StringBuilder(s1)).reverse().toString();
                if (s1.equals(s2)) {
                    strings.add(s1);
                }
            }
        }
        //判断集合是否为空
        if (CollectionUtils.isNotEmpty(strings)) {
            System.out.println(strings);
            String maxString = strings.get(0);
            for (int i = 1; i < strings.size(); i++) {
                if (strings.get(i).length() > maxString.length()) {
                    maxString = strings.get(i);
                }
            }
            return maxString;
        } else {
            return "不存在";
        }
    }

    @Test
    public void maxStringTest() {
        String s = "eramcbea";
        String string = maxString(s);
        System.out.println(string);
    }

    //字符串去重
    public String distinct(String s) {
        String sf = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                sf += c;
            }
        }
        return sf;
    }

    @Test
    public void distinctTest() {
        String s = "wuyevqwww";
        String distinct = distinct(s);
        System.out.println(distinct);
    }

    //判断某个字符在字符串中是否重复，不重复：s.indexOf(c)==s.lastIndexOf(c)，重复：s.indexOf(c)!=s.lastIndexOf(c)

    //求最长不重复的子串的长度
    public int maxSubString(String s) {
        int len = 1;
        //方法一
//        for (int i=0;i<s.length();i++){
//            for(int j=i+1;j<s.length()+1;j++){
//                String subStr=s.substring(i,j);
//                System.out.println(subStr);
//                int k=0;
//                while(k<subStr.length()){
//                    char c=subStr.charAt(k);
//                    if (subStr.indexOf(c)!=subStr.lastIndexOf(c)){
//                        break;
//                    }else {
//                        k++;
//                        continue;
//                    }
//                }
//                if(k==subStr.length()&&subStr.length()>len){
//                    len=subStr.length();
//                }
//            }
//        }


        //方法二
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String subStr = s.substring(i, j);
                System.out.println(subStr);
                Set<Character> hashSet = new HashSet();
                for (int k = 0; k < subStr.length(); k++) {
                    hashSet.add(subStr.charAt(k));
                }
//                System.out.println(hashSet);
                if (hashSet.size() == subStr.length() && subStr.length() > len) {
                    len = subStr.length();
                }
            }
        }
        return len;
    }

    @Test
    public void maxSubStringTest() {
        String s = "abcabcefghab";
        int i = maxSubString(s);
        System.out.println(i);
    }

    public static void main(String[] args) {
        String s = "abcabcefghab";
        System.out.println(res(s));
    }

    public static Integer res(String s) {
        int res = 0, len = s.length();
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();
        while (start < len && end < len) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }
        return res;
    }

    //两个字符串的最长公共子串
    public String longPublicSubStr(String s1, String s2) {
        int len = 0;
        String str = "无";
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j < s1.length() + 1; j++) {
                String subStr = s1.substring(i, j);
                if (s2.contains(subStr) && subStr.length() > len) {
                    len = subStr.length();
                    str = subStr;
//                    System.out.println(str);
                }
            }
        }
        return str;
    }

    @Test
    public void longPublicSubStrTest() {
        String s = longPublicSubStr("qwe", "fghqwjj");
        System.out.println(s);
    }

    //二进制字符串相加
    public String addBinary(String a, String b) {
        //短的前面补0
        String str = "";
        if (a.length() > b.length()) {
            for (int i = 0; i < a.length() - b.length(); i++) {
                str += '0';
            }
            str += b;
            b = str;
        } else {
            for (int i = 0; i < b.length() - a.length(); i++) {
                str += '0';
            }
            str += a;
            a = str;
        }
        //相加进位
        int flag = 0;
        int subSum = 0;
        String sum = "";
        for (int i = 0; i < a.length(); i++) {
            subSum = a.charAt(a.length() - 1 - i) - '0' + b.charAt(b.length() - 1 - i) - '0' + flag;
            if (subSum > 1) {
                sum += subSum - 2;
                flag = 1;
            } else {
                sum += String.valueOf(subSum);
                flag = 0;
            }
        }
        if (flag == 1) {
            sum += String.valueOf(flag);
        }
        sum = (new StringBuilder(sum)).reverse().toString();
        return sum;
    }

    @Test
    public void addBinaryTest() {
        String s = addBinary("11", "100000");
        System.out.println(s);
    }

    //字符串转整型
    //负数未支持
    public int strTOInt(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            a += (s.charAt(i) - '0') * Math.pow(10, s.length() - 1 - i);
        }
        return a;
    }

    @Test
    public void strTOIntTest() {
        int i = strTOInt("-1230");
        System.out.println(i);
    }

    //质数
    public ArrayList<Integer> find() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int a = 1; a <= 100; a++) {
            //指数
            int i;
            for (i = 2; i < a; i++) {
                if (a % i == 0) break;
            }
            if (i == a) System.out.println(a);
        }
        return integers;
    }

    @Test
    public void findTest() {
        ArrayList<Integer> integers = find();
    }

    //爬楼梯，n个台阶，可以1个，可以2个,有多少种情况

    public int clim(int n) {
        int c = 0;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
        return c;
    }

    @Test
    public void climTest() {
        int clim = clim(4);
        System.out.println("有多少种：" + clim);
    }

    //将数组中的0放到数组的后边，然后原来的非零数的顺序不改变
    public int[] lastZero(int[] a) {
        int cur = 0;
        //不为0，存放数组前面
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[cur++] = a[i];
            }
        }
        //从cur开始到数组长度，赋0
        for (int i = cur; i < a.length; i++) {
            a[i] = 0;
        }
        return a;
    }

    @Test
    public void lastZeroTest() {
        int[] a = {0, 3, 0, 6};
        int[] ints = lastZero(a);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 【215】
     * 在未排序的数组中找到第 k 个最大的元素
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     */
    public int findKthLargest(int[] nums, int k) {
        //1、给数组排序-快速排序（分治算法）
        quickSort(nums,0,nums.length-1);
        //2、遍历数组
        for (int i:nums) {
            System.out.println(i);
        }
        return -1;
    }

    /**
     * 快速排序
     *
     * 先分区，再处理子问题
     */
    private void quickSort(int[] nums,int low,int high) {
        //低的下标
        int start = low;
        //高的下标
        int end = high;
        //第一步，先从数组里找出一个基准元素，这里的基准元素取序列的第一个元素
        int key = nums[low];
        //开始循环，低的下标要小于高的下标，循环才能满足
        while (start < end) {

            //移动指针
            while (start < end && nums[end] >= key) {
                end--;
            }
            //填坑
            //第二步，比基准元素小的数移动到基准元素的左半边区间
            if (nums[end] <= key) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
            while (start < end && nums[start] <= key) {
                start++;
            }
            //第二步，比基准元素大的数移动到基准元素的右半边区间
            if (nums[start] >= key) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        //第三步，处理左半边区间元素
        if (start > low) {
            quickSort(nums, low, start - 1);
        }
        //第三步，处理右半边区间元素
        if (start < high) {
            quickSort(nums, end + 1, high);
        }
    }

    @Test
    public void findKthLargestTest() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println("数组中找到第 2 个最大的元素是：" + kthLargest);
    }


    //面试题48. 最长不含重复字符的子字符串（动态规划 / 双指针 + 哈希表，清晰图解）
    //https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
    //初始化，一个map集合；tmp；res
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = dic.getOrDefault(s.charAt(i), -1);
            tmp = tmp < i - index ? tmp + 1 : i - index;
            res = Math.max(res, tmp);

        }
        return res;
    }

}
