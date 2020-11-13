package chuangjianduixiang;

public class Son {
    {
        System.out.println("Son非静态代码块");
    }

    static {
        System.out.println("Son静态代码块");
    }

    public Son() {
        System.out.println("Son构造方法");
    }
}
