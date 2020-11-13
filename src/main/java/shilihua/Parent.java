package shilihua;

public class Parent {
    {
        System.out.println("父类非静态代码块");
    }

    static {
        System.out.println("父类静态代码块");
    }

    public Parent() {
        System.out.println("父类构造器");
    }
}