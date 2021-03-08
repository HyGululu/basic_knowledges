package designpattern.chainofresponsibility;


/**
 * 责任链模式在报销业务流程中应用
 * 报销审批
 * 经理：<=1000
 * 主管：<=5000
 * ceo：<=10000
 */
public class Application3 {

    public static void main(String[] args) {
        //责任链上的对象
        Approver2 staff, manager, ceo;

        //建立责任链
        staff = new Staff2("张三");
        manager = new Manager2("李四");
        ceo = new CEO2("王五");

        staff.setNextApprover(manager);
        manager.setNextApprover(ceo);

        //响应用户的请求
        System.out.println("当报销1000元内时：");
        staff.approver(999);
        System.out.println("------------------------------");
        System.out.println("当报销5000元内时：");
        staff.approver(4999);
        System.out.println("------------------------------");
        System.out.println("当报销10000元内时：");
        staff.approver(10000);
        System.out.println("------------------------------");
        System.out.println("当报销>10000元内时：");
        staff.approver(10001);
    }

}
