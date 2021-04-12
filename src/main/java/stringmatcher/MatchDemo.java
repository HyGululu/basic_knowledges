package stringmatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class MatchDemo {
    public static void main(String[] args) {
        Pattern p = compile("\\d+");

        Matcher m = p.matcher("22bb23");
        System.out.println(m.matches());// 返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
        m = p.matcher("2223");
        System.out.println(m.matches());// 返回true,因为\d+匹配到了整个字符串
        System.out.println("=====================");
       /* 我们现在回头看一下Pattern.matcher(String regex,CharSequence input)，它与下面这段代码等价
        Pattern.compile(regex).matcher(input).matches()。*/

        Pattern p2 = compile("\\d+");
        Matcher m2 = p2.matcher("22bb23");
        System.out.println(m2.lookingAt());// 返回true,因为\d+匹配到了前面的22
        m2 = p.matcher("aa2223");
        System.out.println(m2.lookingAt());// 返回false,因为\d+不能匹配前面的aa
        System.out.println("=====================");

        Pattern p3 = compile("\\d+");
        Matcher m3 = p3.matcher("22bb23");
        System.out.println(m3.find());// 返回true
        m3 = p.matcher("aa2223");
        System.out.println(m3.find());// 返回true
        m3 = p.matcher("aa2223bb");
        System.out.println(m3.find());// 返回true
        m3 = p.matcher("aabb");
        System.out.println(m3.find());// 返回false
    }
}
/*
    find()方法是部分匹配，是查找输入串中与模式匹配的子串，如果该匹配的串有组还可以使用group()函数。
    matches()是全部匹配，是将整个输入串与模式匹配，如果要验证一个输入的数据是否为数字类型或其他类型，一般要用matches()。
    Matcher 类提供了三个匹配操作方法，
    三个方法均返回 boolean 类型，当匹配到时返回 true，没匹配到则返回 false 。
    matches() 对整个字符串进行匹配，只有整个字符串都匹配了才返回true
    lookingAt() 对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true。
    find()对字符串进行匹配，匹配到的字符串可以在任何位置。
 */