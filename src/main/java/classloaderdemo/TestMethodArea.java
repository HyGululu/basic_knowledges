package classloaderdemo;

/*
jvm --方法区
静态变量（static、final）Class模板、常量、类信息（构造方法、接口定义）、运行时的常量池存在方法区，
但是 实例变量存在堆内存中，与方法区无关

java基础、面向对象编程（创建对象的内存分析）

 */
public class TestMethodArea {
    private int a;//不赋值去常量池拿
    private String name = "zhangsan";

    /*
        字符串在常量池
     */
    public static void main(String[] args) {
        TestMethodArea t = new TestMethodArea();//t是引用地址，引用堆
        t.a = 1;//赋值就在堆里找

    }
}
