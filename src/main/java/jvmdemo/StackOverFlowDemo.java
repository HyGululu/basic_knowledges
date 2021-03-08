package jvmdemo;

/*
写出 StackOverflow 代码的两种方式就有了
* 死递归（没有边界，一直在循环调用自己）：写一个方法调用自己即可
* 线程栈内存分配
 */
public class StackOverFlowDemo {

    public static void  Test2(int num){
        if (num>0){
            //死递归
            Test2(num);
        }
    }
    public static void Test3(int num){
        if (num>0){
            Test3(--num);
        }
    }



    public static void main(String[] args) {

        Test2(1);
        Test3(3);
    }

}
