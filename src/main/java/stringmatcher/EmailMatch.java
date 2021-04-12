package stringmatcher;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;


/*
 * 一个简单的邮件地址匹配程序
*/
public class EmailMatch  {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();

            // 检测输入的EMAIL地址是否以非法符号"."或"@"作为起始字符
            Pattern p = compile("^@");
            Matcher m = p.matcher(input);
            if (m.lookingAt()) {//对前面的字符串进行匹配
                System.out.println("EMAIL地址不能以'@'作为起始字符");
            }

            // 检测是否以"www."为起始
            p = compile("^www.");
            m = p.matcher(input);
            if (m.lookingAt()) {//对前面的字符串进行匹配
                System.out.println("EMAIL地址不能以'www.'起始");
            }

            // 检测是否包含非法字符
            p = compile("[^A-Za-z0-9.@_-~#]+");
            m = p.matcher(input);
            StringBuffer sb = new StringBuffer();
            boolean result = m.find();//匹配到的字符串可以在任何位置
            boolean deletedIllegalChars= false;

            while (result) {
                // 如果找到了非法字符那么就设下标记
                deletedIllegalChars= true;
                // 如果里面包含非法字符如冒号双引号等，那么就把他们消去，加到SB里面
                m.appendReplacement(sb, "");
                result = m.find();
            }

            // 此方法从添加位置开始从输入序列读取字符，并将其添加到给定字符串缓冲区。
            // 可以在一次或多次调用 appendReplacement 方法后调用它来复制剩余的输入序列。
            m.appendTail(sb);
            if (deletedIllegalChars){
                System.out.println("输入的EMAIL地址里包含有冒号、逗号等非法字符，请修改");
                System.out.println("您现在的输入为: " + input);
                System.out.println("修改后合法的地址应类似: " + sb.toString());
            }
        }

        sc.close();
    }


}
