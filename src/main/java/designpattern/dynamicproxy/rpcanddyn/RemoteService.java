package designpattern.dynamicproxy.rpcanddyn;

/**
 *
 *
 * 有一个接口
 * 只有方法名称，也不知道接口在远端的实现类的名称
 *
 * 代理的接口类，InvocationHandler和proxy分开，没有添加泛型
 *
 * JDK动态代理是针对接口和实现类的代理，
 * 也就是JDK的动态代理只能应用于接口对接口实施代理
 *
 */
public interface RemoteService {
    public String getValue(String input);
}
/*
RPC的实现中一个重要的功能就是动态代理
 */