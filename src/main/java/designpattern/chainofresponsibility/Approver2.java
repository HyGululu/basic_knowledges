package designpattern.chainofresponsibility;

public abstract class Approver2 {
    //抽象出审批人的姓名
    protected String name;
    //下一个审批人，更高级别领导
    protected Approver2 nextApprover;

    public Approver2(String name) {
        this.name = name;
    }

    public abstract void approver(int amount);

    protected Approver2 setNextApprover(Approver2 approver) {
        this.nextApprover = approver;
        //返回下一个审批人
        return this.nextApprover;
    }
}
