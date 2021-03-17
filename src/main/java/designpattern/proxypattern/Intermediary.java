package designpattern.proxypattern;

/**
 * 代理角色ProxyRole，中介，中介出租房子
 */
public class Intermediary implements Rent {
    private Landlord landlord;

    public Intermediary() {
    }

    public Intermediary(Landlord landlord) {
        this.landlord = landlord;
    }

    //租房
    @Override
    public void rent() {
        seeHouse();
        landlord.rent();
        fare();
    }

    //看房
    public void seeHouse() {
        System.out.println("中介，带客户看房");
    }

    //收中介费
    public void fare() {
        System.out.println("中介，收中介费");
    }
}
