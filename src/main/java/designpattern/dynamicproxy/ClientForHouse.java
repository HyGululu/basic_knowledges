package designpattern.dynamicproxy;

/**
 * 客户，Client，
 * 客户类找代理类
 */
public class ClientForHouse {
    public static void main(String[] args) {
        //房东要租房
        Landlord landlord = new Landlord();
        //代理实例的调用处理程序
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //把真实角色放置进去
        pih.setRent(landlord);
        //动态生成相应的代理类
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
    }
}
