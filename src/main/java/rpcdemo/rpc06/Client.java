package rpcdemo.rpc06;

import rpcdemo.rpc1.IUserService;

public class Client {
    public static void main(String[] args) throws Exception {
        //代理模式--动态代理（rpc核心之一）
        IUserService service = (IUserService)Stub.getStub(IUserService.class);
        System.out.println(service.findUserById(123));
    }
}
