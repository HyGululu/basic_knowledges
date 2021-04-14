package designpattern.dynamicproxy.jingtai;

/**
 * 静态代理
 */
public class ProxyStaticDemo {
    public static void main(String args[])
    {
        Subject sub = new SubjectProxy();
        sub.doSomething();
    }
}
interface Subject
{
    public void doSomething();
}

class RealSubject implements Subject
{
    @Override
    public void doSomething()
    {
        System.out.println( "call doSomething()" );
    }
}

class SubjectProxy implements Subject
{
    Subject subimpl = new RealSubject();
    @Override
    public void doSomething()
    {
        subimpl.doSomething();
    }
}

