package classloaderdemo;

import java.util.Random;

/*
jvm--堆

Heap
一个jvm只有一个堆内存，堆内存大小可以调节的
类加载器读取了类文件后，一般会把什么东西放到堆中（new一个对象怎么放到堆中）
类、方法、常量、变量，保存所有引用类型的真实对象

堆内存还要细分三个区域
新生代（Eden）
老年代
永久代 Perm-->1.8后为元空间


 */
public class TestHeap {
    public static void main(String[] args) {
        String str = "hello one day";

        //oom错误搞起来
        //无限的加字符串
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        while (true) {
            str += str + new Random().nextInt(1231212) + new Random().nextInt(12213113);
        }
    }
}
