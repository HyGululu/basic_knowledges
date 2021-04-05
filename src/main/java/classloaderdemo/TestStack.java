package classloaderdemo;

/*
 栈--数据结构
 先进后出，后进先出
 栈内存，主管程序的运行，生命周期和线程同步
 线程结束，栈内存就释放了，对于栈来说，不存在垃圾回收问题，
 一旦线程结束，栈就over了
 栈：8种基本类型；对象的引用；实例的方法

 栈运行原理：栈帧，
 栈顶、栈底

 队列（管道）
 先进先出
 */
public class TestStack {
    //为什么main方法先执行，最后结束
    // main 方法先放到栈里，main方法上又压了一个方法test
    public static void main(String[] args) {
        new TestStack().test();
    }

    //无限压栈，栈肯定会满，栈溢出  java.lang.StackOverflowError
    public void test() {
        a();
    }

    public void a() {
        test();
    }
}
