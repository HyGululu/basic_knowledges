package designpattern.chainofresponsibility;

public class Staff2 extends Approver2 {

    public Staff2(String name) {
        super(name);
    }

    @Override
    public void approver(int amount) {
        if (amount <= 1000) {
            System.out.println("1000元内，经理[" + name + "]审批通过");
        } else {
            //将请求传递给下一个处理者
            System.out.println("经理["+name+"]无权审批，上报处理");
            this.nextApprover.approver(amount);
        }
    }
}
