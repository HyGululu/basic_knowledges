package jichu;


/**
 * 类什么时候会初始化
 */
public class ReflectionTest05 {
    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1、主动引用
        //Son son = new Son();

        //2、反射也会产生主动引用
        //Class.forName("jichu.Son");

        //不会产生类的引用方法，不会发生类的初始化-子类调用父类的静态方法，链接阶段赋值了
        //System.out.println(Son.b);

        //不会产生类的引用方法，不会发生类的初始化-数组，只是开辟个空间
        //Son[] array = new Son[5];

        //不会产生类的引用方法，不会发生类的初始化-常量，链接阶段赋值了
        System.out.println(Son.M);
    }
}

class Father{
    static int b = 2;

    static {
        System.out.println("父类被加载");
    }


}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;//常量大写

}

//类的主动引用（一定会发生类的初始化）
//类的被动引用

//java rt.jar