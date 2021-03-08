package designpattern.chainofresponsibility;

public class CEO2 extends Approver2 {

    public CEO2(String name) {
        super(name);
    }

    @Override
    public void approver(int amount) {
        if (amount <= 10000) {
            System.out.println("10000元内，ceo[" + name + "]审批通过");
        } else {
            //将请求传递给下一个处理者
            System.out.println("金额超出报销范围，ceo[" + name + "]驳回申请");
        }
    }
}
