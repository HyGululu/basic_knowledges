package designpattern.chainofresponsibility;

public class CEO implements Approver {
    private Approver approver;

    @Override
    public void handleRequest(int amount) {

        if (amount <= 10000) {
            System.out.println("10000元内，CEO审批通过");
        } else {
            //将请求传递给下一个处理者
            System.out.println("金额超出报销范围，驳回申请");
        }
    }

    @Override
    public void setNextHandler(Approver approver) {
        this.approver = approver;
    }
}
