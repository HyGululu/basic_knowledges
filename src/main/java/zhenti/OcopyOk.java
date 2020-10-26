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
        int a[] = {1, 2, 3, 4, 5};
        //偶数个
        //int a[] = {1, 2, 3, 4};

        //测试要点：边界值，中间值，不在里面的值，直接都遍历一遍
        //int half = binarySearch(a, -1);
        int half = binarySearch(a, 5);
        System.out.println(half);
    }

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
     */
    public int countBottle(int money, int price, int exchange) {
        int count = 0;
        //这么多钱能买多少瓶水
        int countWB = money / price;
        count = countWB;
       /*  //有多少个空瓶子可以换多少个水瓶子
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
        System.out.println("count7: " + count + "  现在有多少7: " + countWB);*/
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


}
