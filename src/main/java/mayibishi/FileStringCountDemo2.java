package mayibishi;

import java.io.*;

/*
读取文件中，某个字符串出现次数
 */
public class FileStringCountDemo2 {
    public static void main(String args[]) throws IOException {

        //1、利用IO流将文档的单词读取
       // BufferedReader buf = new BufferedReader(new FileReader("/Users/guhuiyuan/Documents/2studyrepo/basic_knowledges/src/main/resources/java.txt"));
        BufferedReader buf = new BufferedReader(new FileReader("D:\\basicbasic\\basic_knowledges\\src\\main\\resources\\java.txt"));
        System.out.println("Read under this dir java.txt");
        //缓冲字符串
        StringBuffer sbuf = new StringBuffer();
        String line = null;
        while ((line = buf.readLine()) != null) {
            //追加到缓冲字符串中
            sbuf.append(line);
        }
        //读取结束
        buf.close();

        String str = sbuf.toString();
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
