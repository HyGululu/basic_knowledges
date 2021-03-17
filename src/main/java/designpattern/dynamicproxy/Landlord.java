package designpattern.dynamicproxy;

/**
 * 真实角色，房东，房东要出租房子
 */
public class Landlord implements Rent {
    @Override
    public void rent() {
        System.out.println("房东，要出租房子了！");
    }
}
