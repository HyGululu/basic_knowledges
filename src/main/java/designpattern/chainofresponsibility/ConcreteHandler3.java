package designpattern.chainofresponsibility;

/**
 * 角色2.3：具体处理者ConcreteHandler3：
 * 具体处理者是实现处理者接口的类的实例
 */
public class ConcreteHandler3 implements Handler {
    //存放当前处理者后续的Handler接口变量
    private Handler handler;

    @Override
    public void handleRequest(int nums) {
        //当幸运值满201时，出稀有水晶
        if (nums == 201) {
            System.out.println("【稀有】王者水晶");
        } else {
            //将请求传递给下一个处理者
            handler.handleRequest(nums);
        }

    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
