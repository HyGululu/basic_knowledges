package designpattern.chainofresponsibility;

public class Staff implements Approver {
    private Approver approver;

    @Override
    public void handleRequest(int amount) {

        if (amount <= 1000) {
            System.out.println("1000元内，经理审批通过");
        } else {
            //将请求传递给下一个处理者
            System.out.println("经理无权审批，上报处理");
            approver.handleRequest(amount);
        }
    }

    @Override
    public void setNextHandler(Approver approver) {
        this.approver = approver;
    }
}
