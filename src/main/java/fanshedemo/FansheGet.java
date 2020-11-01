package fanshedemo;

public class FansheGet {
    //获取反射机制三种方式
    public static void main(String[] args) throws ClassNotFoundException {
        //1、建立对象
        Student student = new Student();
        Class studentClass = student.getClass();
        System.out.println(studentClass.getName());
        //2、通过相对路径
        Class class1 = Class.forName("fanshedemo.Student");
        System.out.println(class1.getName());
        //3、通过类名
        Class class2 = Student.class;
        System.out.println(class2.getName());
    }
}
