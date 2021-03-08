package designpattern.chainofresponsibility;


/**
 * 责任链模式在报销业务神奇流程中应用
 * 报销审批
 * 经理：<=1000
 * 主管：<=5000
 * ceo：<=10000
 */
public class Application2 {
    //责任链上的对象
    private Approver staff, manager, ceo;

    //建立责任链
    public void createChain() {

        staff = new Staff();
        manager = new Manager();
        ceo = new CEO();

        staff.setNextHandler(manager);
        manager.setNextHandler(ceo);

    }

    //响应用户的请求
    public void responseChain(int amount) {
        staff.handleRequest(amount);
    }

    public static void main(String[] args) {
        Application2 application2 = new Application2();
        application2.createChain();
        System.out.println("当报销1000元内时：");
        application2.responseChain(999);
        System.out.println("------------------------------");
        System.out.println("当报销5000元内时：");
        application2.responseChain(4999);
        System.out.println("------------------------------");
        System.out.println("当报销10000元内时：");
        application2.responseChain(10000);
        System.out.println("------------------------------");
        System.out.println("当报销>10000元内时：");
        application2.responseChain(10001);
    }

}
