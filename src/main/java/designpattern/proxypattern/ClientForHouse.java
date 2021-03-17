package designpattern.proxypattern;

/**
 * 客户，Client，
 * 客户类找代理类
 */
public class ClientForHouse {
    public static void main(String[] args) {
        //房东要租房
        Landlord landlord = new Landlord();
        //中介帮房东租房
        Intermediary intermediary = new Intermediary(landlord);
        //客户找中介
        intermediary.rent();
    }
}
