package designpattern.dynamicproxy;

public class Student extends Person implements A, B {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student instanceof Person);
        System.out.println(student instanceof A);
        System.out.println(student instanceof B);
    }

    @Override
    public void aMethod() {

    }

    @Override
    public void bMethod() {

    }
}
/*
如果说继承的父类只有一个，那么实现的接口可以有多个。
接口无法创建对象，但实现该接口的类可以。
 */
class Person{
    public void perMethod(){}
}
interface A{
    void aMethod();
}
interface B{
    void bMethod();
}