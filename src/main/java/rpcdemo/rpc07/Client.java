package rpcdemo.rpc07;

import rpcdemo.rpc1.IProductService;
import rpcdemo.rpc1.IUserService;

public class Client {
    public static void main(String[] args) throws Exception {
        //IUserService service = (IUserService) Stub.getStub(IUserService.class);
        IProductService service = (IProductService) Stub.getStub(IProductService.class);
        System.out.println(service.findProductById(321));
    }
}
