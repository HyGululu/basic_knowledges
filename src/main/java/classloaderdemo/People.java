package classloaderdemo;

/**
 * Java对象在内存中实例化的过程
 */
public class People {
    /*
    定义三个成员变量：String name、int age、Double height  这三个变量都是只声明了没有初始化，
    然后定义了一个成员方法 sing();
     */
    String name; // 定义一个成员变量 name
    int age; // 成员变量 age
    Double height; // 成员变量 height

    void sing() {
        System.out.println("人的姓名：" + name);
        System.out.println("人的年龄：" + age);
        System.out.println("人的身高：" + height);
    }

    public static void main(String[] args) {
        /*
        main方法里同样定义了三个一样的变量，只不过这些是局部变量
         */
        String name; // 定义一个局部变量 name
        int age; // 局部变量 age
        Double height; // 局部变量 height

        /*
        main() 函数里实例化对象 people ,
        内存中在堆区内会给实例化对象 people 分配一片地址，
         */
        People people = new People(); //实例化对象people
        /*
          对实例化对象 people 进行了赋值。
          people 调用成员方法 sing() main()函数打印输入人的姓名，人的年龄和人的身高，系统执行完毕
         */
        people.name = "张三";       //赋值
        people.age = 18;             //赋值
        //people.stuid = 180.0;   //赋值
        people.sing();              //调用方法sing
    }
}
/*
首先类中的成员变量和方法体会进入到方法区
程序执行到 main() 方法时，main()函数方法体会进入栈区，这一过程叫做进栈(压栈)，定义了一个用于指向 Person 实例的变量 person
程序执行到 Person person = new Person(); 就会在堆内存开辟一块内存区间，用于存放 Person 实例对象，然后将成员变量和成员方法放在 new 实例中都是取成员变量&成员方法的地址值 如图
接下来对 person 对象进行赋值， person.name = “小二” ; perison.age = 13; person.height= 180.0;先在栈区找到 person，然后根据地址值找到 new Person() 进行赋值操作。
当程序走到 sing() 方法时，先到栈区找到 person这个引用变量，然后根据该地址值在堆内存中找到 new Person() 进行方法调用。在方法体void speak()被调用完成后，就会立刻马上从栈内弹出（出站 )最后，在main()函数完成后，main()函数也会出栈*/
