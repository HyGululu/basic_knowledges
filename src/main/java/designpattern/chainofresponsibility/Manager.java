package designpattern.chainofresponsibility;

public class Manager implements Approver {
    private Approver approver;

    @Override
    public void handleRequest(int amount) {

        if (amount <= 5000) {
            System.out.println("5000元内，主管审批通过");
        } else {
            //将请求传递给下一个处理者
            System.out.println("主管无权审批，上报处理");
            approver.handleRequest(amount);
        }
    }

    @Override
    public void setNextHandler(Approver approver) {
        this.approver = approver;
    }
}
