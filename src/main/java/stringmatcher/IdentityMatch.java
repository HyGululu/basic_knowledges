package stringmatcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * 判断身份证：
 * 要么是15位，要么是18位，
 * 最后一位可以为字母，并写程序提出其中的年月日
 */
public class IdentityMatch {
    public static void main(String[] args) {

        // 测试是否为合法的身份证号码
        String[] id_cards = { "130681198712092019","13068119871209201x","13068119871209201","123456789012345",
                "12345678901234x","1234567890123"};

        // 测试是否为合法身份证的正则表达式
        Pattern idPat = compile("(\\d{17}[0-9a-zA-Z]|\\d{14}[0-9a-zA-Z])");
        // 用于提取出生日字符串的正则表达式
        Pattern birthdayPat = compile("\\d{6}(\\d{8}).*");
        // 用于将生日字符串分解为年月日的正则表达式
        Pattern yymmPat = compile("(\\d{4})(\\d{2})(\\d{2})");

        Matcher matcher = idPat.matcher("");
        for (int i = 0; i < id_cards.length; i++) {
            //重置此匹配器
            matcher.reset(id_cards[i]);
            System.out.println(id_cards[i] + " is id cards：" + matcher.matches());//全部匹配
            // 如果它是一个合法的身份证号，提取出出生的年月日
            if (matcher.matches()) {
                Matcher matcher1 = birthdayPat.matcher(id_cards[i]);
                matcher1.lookingAt();
                String birthday = matcher1.group(1);

                Matcher matcher2 = yymmPat.matcher(birthday);
                if (matcher2.find()) {//匹配到的字符串可以在任何位置
                    System.out.println("它对应的出生年月日为：" + matcher2.group(1) + "年" + matcher2.group(2) + "月"
                            +matcher2.group(3) + "日");
                }
            }
            System.out.println();
        }

    }
}

/*
   可以使用正则表达式来定义复杂的字符串格式：
    (\d{17}[0-9a-zA-Z]|\d{14}[0-9a-zA-Z])可以用来判断是否为合法的15位或18位身份证号码。
    因为15位和18位的身份证号码都是从7位到第12位为身份证为日期类型。
    这样我们可以设计出更精确的正则模式，提取身份证号中的日期信息。

    find()方法是部分匹配，是查找输入串中与模式匹配的子串，如果该匹配的串有组还可以使用group()函数。
    matches()是全部匹配，是将整个输入串与模式匹配，如果要验证一个输入的数据是否为数字类型或其他类型，一般要用matches()。
    Matcher 类提供了三个匹配操作方法，
    三个方法均返回 boolean 类型，当匹配到时返回 true，没匹配到则返回 false 。
    matches() 对整个字符串进行匹配，只有整个字符串都匹配了才返回true
    lookingAt() 对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true。
    find()对字符串进行匹配，匹配到的字符串可以在任何位置。
 */