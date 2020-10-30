package jvmdemo;

import org.omg.SendingContext.RunTime;

public class MyJvmDemo3 {
    public static void main(String[] args) {
        //返回虚拟机试图使用的最大内存
        long max = Runtime.getRuntime().maxMemory();

        //返回jvm的初始化总内存
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max="+max+"字节\t"+(max/(double)1024/1024)+"MB");
        System.out.println("total="+total+"字节\t"+(total/(double)1024/1024)+"MB");

        //默认情况下，分配的总内存，是电脑内存的1/4，而初始化内存是64/1
        //oom:1、扩大堆内存看结果  2、分析内存，看哪里出问题（专业工具）
        //-Xms1024m -Xmx1024m -XX:+PrintGCDetails

        //Heap
        // PSYoungGen      total 305664K
        //eden space 262144K
        //from space 43520K
        //to   space 43520K
        //ParOldGen       total 699392K
        //年轻代+永久代区域  305664K+699392K=1005056k 981.5M（约等于内存大小，元空间逻辑上存在，物理上不存在）

    }
}
