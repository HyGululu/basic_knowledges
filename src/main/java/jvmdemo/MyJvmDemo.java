package jvmdemo;

public class MyJvmDemo {
    public static void main(String[] args) {
        new Thread(() -> {
        }, "myThread name: ").start();
    }

    //private  void start0();
    //凡是带来navite关键字的，java作用范围达不到了，要调用底层c语言的库
    //会进入本地方法栈 native method stack
    //调用本地方法本地接口 jni  java natie interface
    //jni作用：扩展java使用，融合不同编程语言为java使用，最初想要调c和c++，
    // java当初发展的时候，c和c++横行，想要立足，必须调用c的程序
    // 在内存区域中专门开辟了一块标记区域，为了登记navite方法，
    // 在最终执行的时候，去加载本地方法库中的方法通过jni
    //java驱动本地打印机，管理系统，企业级比较少用

    private native void start0();
    //现在调用其他接口：  socket、webservice 、http



}
