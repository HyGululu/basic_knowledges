package fanshedemo;

import org.junit.jupiter.api.Test;

public class GetClassTest {
    @Test
    public void test1(){
        Class<?> clz = Student.class;
        //没打印任何内容
    }
    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> clz = Class.forName("fanshedemo.Student");
        //打印了“静态方法”中的内容
        /*
        Student:静态代码块
         */
    }
    @Test
    public void test3(){
        Student student = new Student();
        Class<?> clz = student.getClass();
        //打印出了全部内容
        /*
        Student:静态代码块
        Student:动态代码块
        Student: 构造方法
         */
    }
}
