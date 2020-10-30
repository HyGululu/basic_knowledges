package jvmdemo;

import java.util.ArrayList;

public class MyJvmDemo5 {
    //栈里面没有垃圾回收，堆里99%都有垃圾回收
    //-Xms 设置初始化内存分配大小，默认1/64，测试过程中设置小点
    //-Xmx 设置最大分配内存，默认1/4，测试过程中设置小点
    //-XX:+HeapDumpOnOutOfMemoryError  //打印GC垃圾回收信息
    //-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError  //oom DUMP
    byte[] array =new byte[1*1024*1024];//1M

    public static void main(String[] args) {
        ArrayList<MyJvmDemo5> list = new ArrayList<>();
        int count =0;


        try {
            while (true){
                list.add(new MyJvmDemo5());//问题所在
                count = count+1;
            }
        } catch (Error e) {
            System.out.println("count: "+count);
            e.printStackTrace();
        }

    }
}
