package shilihua;

/*
类实例化顺序为：
父类静态代码块/静态域->子类静态代码块/静态域 ->
 父类非静态代码块 -> 父类构造器 ->
 子类非静态代码块 -> 子类构造器
 */
public class TestShiLiHua {
    public static void main(String[] args) {
        Son son = new Son();
    }
}
/*
父类静态代码块
子类静态代码块
父类非静态代码块
父类构造器
子类非静态代码块
子类构造器
 */