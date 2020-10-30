package jvmdemo;

import java.util.Random;

public class MyJvmDemo4 {
    //-Xms8m -Xmx8m -XX:+PrintGCDetails
    //GC 轻GC
    //Full GC 重GC
    public static void main(String[] args) {
        String str = "ghy";
        while (true){
            //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            str+= str+new Random().nextInt(88888888)+new Random().nextInt(99999999);
        }
    }
}
