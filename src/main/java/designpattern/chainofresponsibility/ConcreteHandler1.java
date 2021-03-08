package designpattern.chainofresponsibility;

/**
 * 角色2.1：具体处理者ConcreteHandler1：
 *  具体处理者是实现处理者接口的类的实例
 *
 */
public class ConcreteHandler1 implements Handler {
    //存放当前处理者后续的Handler接口变量
    private Handler handler;

    @Override
    public void handleRequest(int nums) {
        //60钻石抽一次
        if (nums == 60) {
            String random = "";
            String[] doc = {"白起", "夏侯淳", "甄姬", "金币288", "小喇叭5", "铭文碎片400", "铭文碎片25", "爱心气球（3日）", "亲密玫瑰", "钻石48", "龙域领主体验卡"};
            //随机选取其一输出
            int index = (int) (Math.random() * doc.length);
            random = doc[index];
            System.out.println(random);
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
