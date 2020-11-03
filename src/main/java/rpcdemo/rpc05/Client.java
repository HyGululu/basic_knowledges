package rpcdemo.rpc05;

import rpcdemo.rpc1.IUserService;

public class Client {
    public static void main(String[] args) throws Exception {
        //代理模式--动态代理（rpc核心之一）
        IUserService service = Stub.getStub();
        System.out.println(service.findUserById(123));
        /*
        com.sun.proxy.$Proxy0
        interface rpcdemo.rpc1.IUserService
        User{id=123, name='ghy'}
        User{id=123, name='ghy'}
         */
    }
}
