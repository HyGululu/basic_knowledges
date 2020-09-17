package rpcdemo;

/*
HelloServices接口实现类
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
