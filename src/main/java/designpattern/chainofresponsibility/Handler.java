package designpattern.chainofresponsibility;

/**
 * 角色1：处理者Handler：接口，
 * 负责规定具体处理者处理用户请求的方法以及具体处理者后续对象的方法
 */
public interface Handler {
    //具体处理用户请求 60钻石抽一次or270钻石抽五次
    public abstract void handleRequest(int nums);

    public abstract void setNextHandler(Handler handler);
}
