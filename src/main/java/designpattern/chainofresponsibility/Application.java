package designpattern.chainofresponsibility;


/**
    责任链模式在王者中应用
        夺宝抽奖
            方式1：'60钻石'抽一次
            方式2：'270钻石'抽五次
                3：钻石抽奖'幸运值达201'
 */
public class Application {
    //责任链上的对象
    private Handler handler1, handler2, handler3;

    //建立责任链
    public void createChain() {

        handler1 = new ConcreteHandler1();
        handler2 = new ConcreteHandler2();
        handler3 = new ConcreteHandler3();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

    }

    //响应用户的请求
    public void responseChain(int number) {
        handler1.handleRequest(number);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.createChain();
        System.out.println("当点击'60钻石'抽一次时：");
        System.out.println("[购买成功]");
        application.responseChain(60);
        System.out.println("------------------------------");
        System.out.println("当点击'270钻石'抽五次时：");
        System.out.println("[购买成功]");
        application.responseChain(270);
        System.out.println("------------------------------");
        System.out.println("当钻石抽奖'幸运值达201'时：");
        System.out.println("[购买成功]");
        application.responseChain(201);
    }

}
