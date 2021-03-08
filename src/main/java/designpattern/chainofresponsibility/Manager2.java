package designpattern.chainofresponsibility;

public class Manager2 extends Approver2 {

    public Manager2(String name) {
        super(name);
    }

    @Override
    public void approver(int amount) {
        if (amount <= 5000) {
            System.out.println("5000元内，主管[" + name + "]审批通过");
        } else {
            //将请求传递给下一个处理者
            System.out.println("主管["+name+"]无权审批，上报处理");
            this.nextApprover.approver(amount);
        }
    }
}
