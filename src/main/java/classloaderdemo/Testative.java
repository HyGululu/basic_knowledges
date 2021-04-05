package classloaderdemo;

import java.net.HttpCookie;
import java.net.Socket;

/**
 * jvm--native关键字
 * private native void start0()
 *
 * Thread.start()
 *
 */
public class Testative {
    public static void main(String[] args) {
        new Thread(()->{

        },"my Thread name").start();
    }
    //凡是带了native关键字的，说明java的作用域达不到了，会掉底层c语言的库
    //本地方法接口（JNI），JNI调本地方法库
    //凡是带了native关键字的，会进入本地方法栈,会调用本地方法接口JNI,
    // JNI作用：扩展java 的使用，融合不同的编程语言为java所用，最初想融合c和c++
    //必须有调c和c++的区域，在内存区域中开辟了标记区域 native method stack，等级本地方法
    //最终执行的时候，加载本地方法库中的方法通过JNI

    //java程序驱动打印机、管理系统、Root 在企业中应用较少
    private native void start0();
    //private void start0();

    //调用其他接口  Socket WebService Http

}
