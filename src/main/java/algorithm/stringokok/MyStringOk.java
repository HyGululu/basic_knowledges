package algorithm.stringokok;

public class MyStringOk {
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
}
