package mayibishi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/*
读取文件中，某个字符串出现次数

读取一个文档，并统计出其中重复性单词的TopN：
利用IO流将文档的单词读取
将其存为map的K,V，新的单词记为K，出现次数记为V，
利用比较器进行比较，遇到重复的单词找到他对应的V加一
 */
public class FileStringCountDemo4 {
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

        // 用Pattern类中的complie()方法，将正则表达式编译到模式中
        Pattern patten = compile("[a-zA-Z]+");

        // 用Pattern类中的matcher()方法,生成一个匹配器对象，Matcher类是匹配器类
        String sbstring = sb.toString();
        Matcher matcher = patten.matcher(sbstring);
        Map<String, Integer> tp = new TreeMap<String, Integer>();
        while (matcher.find()) {//匹配到的字符串可以在任何位置
            // 用Matcher类中的find()方法，查找与模式匹配的下一个子序列
            String word = matcher.group();
            // 用Matcher类中的group()方法， 返回匹配的子序列
            if (tp.containsKey(word)) {
                // 统计每个单词出现的次数
                Integer wordfrequency = tp.get(word);
                tp.put(word, wordfrequency + 1);
            } else {
                tp.put(word, 1);
            }
        }

        /*
        不用比较器排序，直接打印
         */
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(tp.entrySet());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }


}
/*
    Pattern类方法详解
    1、Pattern complie(String regex)：编译正则表达式，并创建Pattern类。
    由于Pattern的构造函数是私有的，不可以直接创建，所以通过静态的简单工厂方法compile(String regex)方法来创建，将给定的正则表达式编译并赋予给Pattern类。
 */