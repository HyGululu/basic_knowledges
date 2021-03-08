package designpattern.chainofresponsibility;

public interface Approver {


    public abstract void handleRequest(int amount);

    public abstract void setNextHandler(Approver approver);
}
