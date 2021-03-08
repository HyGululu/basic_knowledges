package jvmdemo;

import java.util.ArrayList;
import java.util.List;

/*
当出现java.lang.OutOfMemoryError:Java heap space异常时
就是堆内存溢出了

例子：
编译以下代码，执行时jvm参数设置为-Xms20m -Xmx20m

解决方式
1、调整-Xms和-Xmx两个jvm参数，使用压力测试来调整这两个参数达到最优值
2、尽量避免大的对象的申请，像文件上传
 */
public class OutOfMemoryDemo {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(new byte[5 * 1024 * 1024]);
            System.out.println("count is " + (++i));
        }
    }

}
