package mayibishi;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/*
读取文件中，某个字符串出现次数

 */
public class FileStringCountDemo2 {
    public static void main(String args[]) throws IOException {

        //1、利用IO流将文档的单词读取
        // BufferedReader buf = new BufferedReader(new FileReader("/Users/guhuiyuan/Documents/2studyrepo/basic_knowledges/src/main/resources/java.txt"));
        /*
         * 首先将文件的内容读取到缓冲区bufferedreader中，
         * 利用的是BufferedReader中的readline()读取文件中的每一个文本行，
         * readline()并不是一行一行读取的，而是一个文本行一个文本行读取。 什么是文本行？
         * 看JavaAPI中BufferedReader类总中的readline()的解释。
         */
        BufferedReader buf = new BufferedReader(new FileReader("D:\\basicbasic\\basic_knowledges\\src\\main\\resources\\java.txt"));
        System.out.println("Read under this dir java.txt");
        //缓冲字符串
        StringBuffer sb = new StringBuffer();
        String text = null;
        while ((text = buf.readLine()) != null) {
            //追加到缓冲字符串中
            // 将从文件中读出来的字符串追加，形成一个字符串
            sb.append(text);
        }
        //读取结束
        buf.close();

        String str = sb.toString();
        System.out.println("读取的文件内容是：" + str);

        int count = searchCount(str, "甲骨文");
        System.out.println("字符串统计，甲骨文 出现的次数是：" + count);
    }


    public static void getKeyStringCount(String str, String word) {
    }

    // 定义searchCount方法，来返回字符串出现的个数
    public static int searchCount(String str, String word) {
        // 定义一个count来存放字符串出现的次数
        int count = 0;
        // 调用String类的indexOf(String str)方法，返回第一个相同字符串出现的下标
        while (str.indexOf(word) != -1) {
            // 如果存在相同字符串则次数加1
            count++;
            // 调用String类的substring(int beginIndex)方法，获得第一个相同字符出现后的字符串
            str = str.substring(str.indexOf(word)
                    + word.length());

        }
        // 返回次数
        return count;
    }

}
