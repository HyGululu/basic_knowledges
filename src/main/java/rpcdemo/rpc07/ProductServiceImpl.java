package rpcdemo.rpc07;

import rpcdemo.rpc1.IProductService;
import rpcdemo.rpc1.IUserService;
import rpcdemo.rpc1.Product;
import rpcdemo.rpc1.User;

public class ProductServiceImpl implements IProductService {
    @Override
    public Product findProductById(Integer id) {

        return new Product(id, "gogogo");
    }
}
